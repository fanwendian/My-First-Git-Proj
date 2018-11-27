package com.wlf.home.service.impl;

import com.wlf.home.dao.AdminDao;
import com.wlf.home.domain.Admin;
import com.wlf.home.dto.AdminDTO;
import com.wlf.home.service.AdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

	@Resource
	private AdminDao adminDao;

	@Override
	public void addAdmin(AdminDTO admin) {
		Admin adminPojo = new Admin();
		BeanUtils.copyProperties(admin, adminPojo);
		adminDao.insertSelective(adminPojo);
	}

	@Override
	public void deleteAdmin(long id) {
		adminDao.deleteByPrimaryKey(id);
	}

	@Override
	public void updateAdmin(AdminDTO admin) {
		Admin adminPojo = new Admin();
		BeanUtils.copyProperties(admin, adminPojo);
		adminDao.updateByPrimaryKeySelective(adminPojo);
	}

	@Override
	public AdminDTO selectAdminById(long id) {
		AdminDTO adminDTO = new AdminDTO();
		Admin admin = adminDao.selectByPrimaryKey(id);
		if(admin == null) {
			return null;
		}else {
			BeanUtils.copyProperties(admin, adminDTO);
			return adminDTO;
		}
		
	}

	@Override
	public AdminDTO selectAdminByUsername(String username) {
		AdminDTO adminDTO = new AdminDTO();
		List<Admin> admins = adminDao.selectByUsername(username);
		if(admins != null && admins.size() > 0) {
			BeanUtils.copyProperties(admins.get(0), adminDTO);
			return adminDTO;
		}else {
			return null;
		}
	}

	@Override
	public AdminDTO selectAdminByUsernameAndPassword(String username, String password) {
		AdminDTO adminDTO = new AdminDTO();
		List<Admin> admins = adminDao.selectByUsernameAndPassword(username,password);
		if(admins != null && admins.size() > 0) {
			BeanUtils.copyProperties(admins.get(0), adminDTO);
			return adminDTO;
		}else {
			return null;
		}
	}

}
