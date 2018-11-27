package com.wlf.home.service;

import com.wlf.home.dto.HouseTypeDTO;

import java.util.List;


public interface HouseTypeService {
	
	void addHouseType(HouseTypeDTO houseType);
	
	void deleteHouseType(long id);
	
	List<HouseTypeDTO> selectAllHouseType();

}
