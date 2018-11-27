package service;

import mapper.AdminDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bean.Admin;
@Service
public class AdminServiceImpl implements AdminService{
		  
	@Autowired
	private AdminDao adminDao;
	public Admin findAdminByName(String admin_name) {
		// TODO Auto-generated method stub
		return adminDao.findAdminByName(admin_name);
	}
	public int updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.updateAdmin(admin);
	}

}
