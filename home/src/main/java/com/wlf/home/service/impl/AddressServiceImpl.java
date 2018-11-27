package com.wlf.home.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.wlf.home.dao.AddressDao;
import com.wlf.home.domain.Address;
import com.wlf.home.dto.AddressDTO;
import com.wlf.home.service.AddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("addressService")
public class AddressServiceImpl implements AddressService {

	@Resource
	private AddressDao addressDao;

	@Override
	public void addAddress(AddressDTO address) {
		Address addressPojo = new Address();
		BeanUtils.copyProperties(address, addressPojo);
		addressDao.insertSelective(addressPojo);
	}

	@Override
	public void deleteAddress(long id) {
		addressDao.deleteByPrimaryKey(id);
	}

	@Override
	public List<AddressDTO> selectAllAddress() {
		List<AddressDTO> addressDTOs = new ArrayList<>();
		List<Address> selectAllAddress = addressDao.selectAll();
		if(selectAllAddress!=null&&selectAllAddress.size()>0) {
			for (Address address : selectAllAddress) {
				AddressDTO addressDTO = new AddressDTO();
				BeanUtils.copyProperties(address, addressDTO);
				addressDTOs.add(addressDTO);
			}
		}
		return addressDTOs;
	}

}
