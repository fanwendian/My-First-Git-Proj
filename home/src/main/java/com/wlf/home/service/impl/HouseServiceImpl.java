package com.wlf.home.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.wlf.home.dao.AddressDao;
import com.wlf.home.dao.AdminDao;
import com.wlf.home.dao.HouseDao;
import com.wlf.home.dao.HouseTypeDao;
import com.wlf.home.domain.House;
import com.wlf.home.dto.HouseDTO;
import com.wlf.home.service.HouseService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("houseService")
public class HouseServiceImpl implements HouseService {
	@Resource
	private HouseDao houseDao;
	@Resource
	private AddressDao addressDao;
	@Resource
	private HouseTypeDao houseTypeDao;
	@Resource
	private AdminDao adminDao;

	@Override
	public void addHouse(HouseDTO house) {
		House housePojo = new House();
		BeanUtils.copyProperties(house, housePojo);
		houseDao.insertSelective(housePojo);
	}

	@Override
	public void deleteHouse(long id) {
		houseDao.deleteByPrimaryKey(id);
	}

	@Override
	public void updateHouse(HouseDTO house) {
		House housePojo = new House();
		BeanUtils.copyProperties(house, housePojo);
		houseDao.updateByPrimaryKeySelective(housePojo);
	}

	@Override
	public HouseDTO selectHouseById(long id) {
		HouseDTO houseDTO = new HouseDTO();
		House house = houseDao.selectByPrimaryKey(id);
		if(house == null) {
			return null;
		}else {
			BeanUtils.copyProperties(house, houseDTO);
			houseDTO.setAdminUsername(adminDao.selectByPrimaryKey(house.getAdminId()).getUsername());
			houseDTO.setCityName(addressDao.selectByPrimaryKey(house.getCityId()).getCityname());
			houseDTO.setTypeName(houseTypeDao.selectByPrimaryKey(house.getTypeId()).getTypename());
			return houseDTO;
		}
	}

	@Override
	public List<HouseDTO> selectHouseByCityId(long cityId) {
		List<HouseDTO> houseDTOs = new ArrayList<>();
		List<House> selectHouseByCityId = houseDao.selectByCityId(cityId);
		if(selectHouseByCityId != null && selectHouseByCityId.size() > 0) {
			for (House house : selectHouseByCityId) {
				HouseDTO houseDTO = new HouseDTO();
				BeanUtils.copyProperties(house, houseDTO);
				houseDTO.setAdminUsername(adminDao.selectByPrimaryKey(house.getAdminId()).getUsername());
				houseDTO.setCityName(addressDao.selectByPrimaryKey(house.getCityId()).getCityname());
				houseDTO.setTypeName(houseTypeDao.selectByPrimaryKey(house.getTypeId()).getTypename());
				houseDTOs.add(houseDTO);
			}
		}
		return houseDTOs;
	}

	@Override
	public List<HouseDTO> selectHouseByAdminId(long adminId) {
		List<HouseDTO> houseDTOs = new ArrayList<>();
		List<House> selectHouseByAdminId = houseDao.selectByAdminId(adminId);
		if(selectHouseByAdminId != null && selectHouseByAdminId.size() > 0) {
			for (House house : selectHouseByAdminId) {
				HouseDTO houseDTO = new HouseDTO();
				BeanUtils.copyProperties(house, houseDTO);
				houseDTO.setAdminUsername(adminDao.selectByPrimaryKey(house.getAdminId()).getUsername());
				houseDTO.setCityName(addressDao.selectByPrimaryKey(house.getCityId()).getCityname());
				houseDTO.setTypeName(houseTypeDao.selectByPrimaryKey(house.getTypeId()).getTypename());
				houseDTOs.add(houseDTO);
			}
		}
		return houseDTOs;
	}

	@Override
	public List<HouseDTO> selectHouseByTypeId(long typeId) {
		List<HouseDTO> houseDTOs = new ArrayList<>();
		List<House> selectHouseByTypeId = houseDao.selectByTypeId(typeId);
		if(selectHouseByTypeId!=null&&selectHouseByTypeId.size()>0) {
			for (House house : selectHouseByTypeId) {
				HouseDTO houseDTO = new HouseDTO();
				BeanUtils.copyProperties(house, houseDTO);
				houseDTO.setAdminUsername(adminDao.selectByPrimaryKey(house.getAdminId()).getUsername());
				houseDTO.setCityName(addressDao.selectByPrimaryKey(house.getCityId()).getCityname());
				houseDTO.setTypeName(houseTypeDao.selectByPrimaryKey(house.getTypeId()).getTypename());
				houseDTOs.add(houseDTO);
			}
		}
		return houseDTOs;
	}

	@Override
	public List<HouseDTO> selectHouseAll() {
		List<HouseDTO> houseDTOs = new ArrayList<>();
		List<House> selectAll = houseDao.selectAll();
		if(selectAll!=null&&selectAll.size()>0) {
			for (House house : selectAll) {
				HouseDTO houseDTO = new HouseDTO();
				BeanUtils.copyProperties(house, houseDTO);
				houseDTO.setAdminUsername(adminDao.selectByPrimaryKey(house.getAdminId()).getUsername());
				houseDTO.setCityName(addressDao.selectByPrimaryKey(house.getCityId()).getCityname());
				houseDTO.setTypeName(houseTypeDao.selectByPrimaryKey(house.getTypeId()).getTypename());
				houseDTOs.add(houseDTO);
			}
		}
		return houseDTOs;
	}

}
