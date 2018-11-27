package bean;

public class User {
	private int user_id;
	private String user_email;
	private String user_password;
	private String user_nickname;
	private String emailVerifyCode; // 邮箱验证码
	private int userIntegral; // 用户级别:VIP 普通用户
	private String user_name;//真实姓名
	private String user_address;
	private String user_company;
	private String user_job;
	private String user_weixin;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int userId) {
		user_id = userId;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String userEmail) {
		user_email = userEmail;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String userPassword) {
		user_password = userPassword;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String userNickname) {
		user_nickname = userNickname;
	}
	public String getEmailVerifyCode() {
		return emailVerifyCode;
	}
	public void setEmailVerifyCode(String emailVerifyCode) {
		this.emailVerifyCode = emailVerifyCode;
	}
	public int getUserIntegral() {
		return userIntegral;
	}
	public void setUserIntegral(int userIntegral) {
		this.userIntegral = userIntegral;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String userName) {
		user_name = userName;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String userAddress) {
		user_address = userAddress;
	}
	public String getUser_company() {
		return user_company;
	}
	public void setUser_company(String userCompany) {
		user_company = userCompany;
	}
	public String getUser_job() {
		return user_job;
	}
	public void setUser_job(String userJob) {
		user_job = userJob;
	}
	public String getUser_weixin() {
		return user_weixin;
	}
	public void setUser_weixin(String userWeixin) {
		user_weixin = userWeixin;
	}
	public User(int userId, String userEmail, String userPassword,
			String userNickname, String emailVerifyCode, int userIntegral,
			String userName, String userAddress, String userCompany,
			String userJob, String userWeixin) {
		super();
		user_id = userId;
		user_email = userEmail;
		user_password = userPassword;
		user_nickname = userNickname;
		this.emailVerifyCode = emailVerifyCode;
		this.userIntegral = userIntegral;
		user_name = userName;
		user_address = userAddress;
		user_company = userCompany;
		user_job = userJob;
		user_weixin = userWeixin;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [emailVerifyCode=" + emailVerifyCode + ", userIntegral="
				+ userIntegral + ", user_address=" + user_address
				+ ", user_company=" + user_company + ", user_email="
				+ user_email + ", user_id=" + user_id + ", user_job="
				+ user_job + ", user_name=" + user_name + ", user_nickname="
				+ user_nickname + ", user_password=" + user_password
				+ ", user_weixin=" + user_weixin + "]";
	}
    

	
}
