package com.account.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Gaming")
public class ServletGaming extends HttpServlet {
public ServletGaming() {
System.out.println("Default contructor");
}
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Initializing the resources");

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Processing the client request");
		String name=req.getParameter("nm");
		String type=req.getParameter("nt");
		String noOfPlayers=req.getParameter("np");

		PrintWriter printWriter=resp.getWriter();
		//resp.setContentType("text/html");    //To make font type of print()
		printWriter.print("Thank you for choosing "+name+" game");
		
		String url = ("jdbc:mysql://localhost:3306?user=root&password=root");
		
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection = DriverManager.getConnection(url); 
				PreparedStatement preparedStatement = connection
					.prepareStatement("insert into jdbc.gaming  values(?,?,?)");
				preparedStatement.setString(1, name);
				preparedStatement.setString(2, type);
				preparedStatement.setInt(3,Integer.parseInt(noOfPlayers));
				preparedStatement.execute();
			}catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}	
	}
	
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("Closing costly resources");
	}
}
