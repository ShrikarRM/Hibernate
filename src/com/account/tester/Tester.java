package com.account.tester;

import java.util.List;

import com.account.dao.OotaDAO;
import com.account.dao.OotaDAOImpl;
import com.account.dto.OotaDTO;

public class Tester {

	public static void main(String[] args) {
		OotaDTO dto = new OotaDTO();
		dto.setName("Jamoon");
		dto.setType("veg");
		dto.setPlace("home");

		OotaDAO ootaDAO = new OotaDAOImpl();
		//ootaDAO.saveOota(dto);
//		ootaDAO.getOota(dto);
//		ootaDAO.getOota("Roti");
//		System.out.println("Roti");
		//ootaDAO.getOotaPlaceByName("Roti");
		//ootaDAO.getOotaPlaceByName();
		//ootaDAO.updateTable("Roti");
		ootaDAO.saveDetails(dto);

	}

}
