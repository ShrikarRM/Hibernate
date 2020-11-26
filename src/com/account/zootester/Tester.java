package com.account.zootester;

import com.account.zooDAO.ZooDAO;
import com.account.zooDAO.ZooDAOImpl;
import com.account.zooDTO.ZooDTO;


public class Tester {

	public static void main(String[] args) {
		ZooDTO dto = new ZooDTO();
		dto.setName("MysuruZoo");
		dto.setNoOfAnimals(300);
		dto.setPlace("Bengaluru");
		
		ZooDAO dao=new ZooDAOImpl();
		//dao.saveZoo(dto);
		dao.fetch("MysuruZoo");
		//dao.deleteRecord(2);
	}

}
