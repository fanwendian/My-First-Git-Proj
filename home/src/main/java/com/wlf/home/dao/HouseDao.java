package com.wlf.home.dao;

import com.wlf.home.domain.House;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface HouseDao {
	
	void insertSelective(House house);
	
	void deleteByPrimaryKey(Long id);
	
	void updateByPrimaryKeySelective(House house);
	
	House selectByPrimaryKey(Long id);
	
	List<House> selectByCityId(Long cityId);
	
	List<House> selectByAdminId(Long adminId);
	
	List<House> selectByTypeId(Long typeId);
	
	List<House> selectAll();

}
