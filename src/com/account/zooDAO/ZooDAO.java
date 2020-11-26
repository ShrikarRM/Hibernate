package com.account.zooDAO;

import com.account.zooDTO.ZooDTO;

public interface ZooDAO {
public void saveZoo(ZooDTO zooDTO);
public void fetch(String name);
public void deleteRecord(int id);

}
