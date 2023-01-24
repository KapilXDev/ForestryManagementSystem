package com.cg.fms.service;



import java.util.List;

import com.cg.fms.dto.Admin;



public interface IAdminService {

	Admin getAdmin(int id) throws Exception;
	List<Admin> getAllAdmins();
	Admin getAdminByName(String name) throws Exception;
	Admin deleteAdmin(int id) throws Exception;
	Admin updateAdmin(Admin admin) throws Exception;
	Admin addAdmin(Admin admin);
	
}
