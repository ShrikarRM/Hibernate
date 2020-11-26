package com.account.dao;

import java.util.List;

import com.account.dto.OotaDTO;

public interface OotaDAO {
//public void saveOota(OotaDTO dto);
	public void saveDetails(OotaDTO dto);
/*public List<OotaDTO> getOota(OotaDTO dto);
public List<OotaDTO> getOota(String name);
public Object[] getOotaPlaceByName(String name);
public List<Object[]> getOotaPlaceByName();
*/
public String updateTable(String name);
}
