package com.wlf.home.service;

import com.wlf.home.dto.HouseDTO;

import java.util.List;


public interface HouseService {
	
	void addHouse(HouseDTO house);
	
	void deleteHouse(long id);
	
	void updateHouse(HouseDTO house);
	
	HouseDTO selectHouseById(long id);
	
	List<HouseDTO> selectHouseByCityId(long cityId);
	
	List<HouseDTO> selectHouseByAdminId(long adminId);
	
	List<HouseDTO> selectHouseByTypeId(long typeId);
	
	List<HouseDTO> selectHouseAll();
}
