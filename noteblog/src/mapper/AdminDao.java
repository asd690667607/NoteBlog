package mapper;

import bean.Admin;


public interface AdminDao {
	Admin findAdminByName(String admin_name);
	int updateAdmin(Admin admin);
}
