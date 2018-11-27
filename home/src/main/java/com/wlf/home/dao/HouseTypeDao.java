package com.wlf.home.dao;

import com.wlf.home.domain.HouseType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface HouseTypeDao {
	
	void insertSelective(HouseType houseType);
	
	void deleteByPrimaryKey(Long id);
	
	HouseType selectByPrimaryKey(Long id);
	
	List<HouseType> selectAll();

}
