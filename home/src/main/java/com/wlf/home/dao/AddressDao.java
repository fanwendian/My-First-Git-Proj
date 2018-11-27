package com.wlf.home.dao;

import com.wlf.home.domain.Address;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface AddressDao {
	
	void insertSelective(Address address);
	
	void deleteByPrimaryKey(Long id);
	
	Address selectByPrimaryKey(Long id);
	
	List<Address> selectAll();
	
}
