package com.wlf.home.service;

import com.wlf.home.dto.AddressDTO;

import java.util.List;


public interface AddressService {
	
	void addAddress(AddressDTO address);
	
	void deleteAddress(long id);
	
	List<AddressDTO> selectAllAddress();
}
