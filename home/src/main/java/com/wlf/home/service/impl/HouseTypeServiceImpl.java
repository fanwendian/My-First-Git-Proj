package com.wlf.home.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.wlf.home.dao.HouseTypeDao;
import com.wlf.home.domain.HouseType;
import com.wlf.home.dto.HouseTypeDTO;
import com.wlf.home.service.HouseTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("houseTypeService")
public class HouseTypeServiceImpl implements HouseTypeService {

	@Resource
	private HouseTypeDao houseTypeDao;

	@Override
	public void addHouseType(HouseTypeDTO houseType) {
		HouseType houseTypePojo = new HouseType();
		BeanUtils.copyProperties(houseType, houseTypePojo);
		houseTypeDao.insertSelective(houseTypePojo);
	}

	@Override
	public void deleteHouseType(long id) {
		houseTypeDao.deleteByPrimaryKey(id);
	}

	@Override
	public List<HouseTypeDTO> selectAllHouseType() {
		List<HouseTypeDTO> houseTypeDTOs = new ArrayList<>();
		List<HouseType> selectAllHouseType = houseTypeDao.selectAll();
		if(selectAllHouseType!=null&&selectAllHouseType.size()>0) {
			for (HouseType houseType : selectAllHouseType) {
				HouseTypeDTO houseTypeDTO = new HouseTypeDTO();
				BeanUtils.copyProperties(houseType, houseTypeDTO);
				houseTypeDTOs.add(houseTypeDTO);
			}
		}
		return houseTypeDTOs;
	}

}
