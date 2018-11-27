package bean;

public class Admin {
  private int admin_id;
  private String admin_name;
  private String admin_nickname;
  private String admin_password;
public int getAdmin_id() {
	return admin_id;
}
public void setAdmin_id(int adminId) {
	admin_id = adminId;
}
public String getAdmin_name() {
	return admin_name;
}
public void setAdmin_name(String adminName) {
	admin_name = adminName;
}
public String getAdmin_nickname() {
	return admin_nickname;
}
public void setAdmin_nickname(String adminNickname) {
	admin_nickname = adminNickname;
}
public String getAdmin_password() {
	return admin_password;
}
public void setAdmin_password(String adminPassword) {
	admin_password = adminPassword;
}
public Admin(int adminId, String adminName, String adminNickname,
		String adminPassword) {
	super();
	admin_id = adminId;
	admin_name = adminName;
	admin_nickname = adminNickname;
	admin_password = adminPassword;
}
public Admin() {
	super();
}
@Override
public String toString() {
	return "Admin [admin_id=" + admin_id + ", admin_name=" + admin_name
			+ ", admin_nickname=" + admin_nickname + ", admin_password="
			+ admin_password + "]";
}

  
}
