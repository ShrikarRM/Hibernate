package com.account.players;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PlayersDetails {
	public static void main(String[] args) {
		// String fileName="Players.xlsx";
		File file = new File("D:\\Java Prog-StudyMaterials\\Players.csv");
		try {
			file.createNewFile();
		} catch (IOException e) {

			e.printStackTrace();
		}
		try {
			Scanner sc = new Scanner(file);
			sc.next();		//apart from header
			while (sc.hasNext()) {
				String data = sc.next();
				String[] values = data.split(",");
				String id = values[0];
				// System.out.println(data);
				String name = values[1];
				String country = values[2];
				System.out.println(id + " " + name + " " + country);
				String url = ("jdbc:mysql://localhost:3306?user=root&password=root");

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection(url);
					PreparedStatement preparedStatement = connection
							.prepareStatement("insert into jdbc.players_table  values(?,?,?)");
					preparedStatement.setInt(1,Integer.parseInt(id) );
					preparedStatement.setString(2, name);
					preparedStatement.setString(3, country);
					preparedStatement.execute();
				} catch (SQLException | ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
