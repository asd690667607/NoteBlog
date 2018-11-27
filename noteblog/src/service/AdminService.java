package service;

import bean.Admin;

public interface AdminService {
	Admin findAdminByName(String admin_name);
	int updateAdmin(Admin admin);
	
}
