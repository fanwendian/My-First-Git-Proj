package com.wlf.home.service;


import com.wlf.home.dto.AdminDTO;

public interface AdminService {
	
	void addAdmin(AdminDTO admin);
	
	void deleteAdmin(long id);
	
	void updateAdmin(AdminDTO admin);
	
	AdminDTO selectAdminById(long id);
	
	AdminDTO selectAdminByUsername(String username);
	
	AdminDTO selectAdminByUsernameAndPassword(String username, String password);
}
