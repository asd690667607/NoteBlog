package bean;

public class Praise {

	/*
	 * 点赞状态判断，user_email,blog_id,praiseStatus点赞状态
	 */
	private int ps_id;
	private String ps_user_email;
	private int ps_blog_id;
	private String ps_status;
	public Praise() {
		
	}
	public Praise(int ps_id, String ps_user_email, int ps_blog_id, String ps_status) {
		super();
		this.ps_id = ps_id;
		this.ps_user_email = ps_user_email;
		this.ps_blog_id = ps_blog_id;
		this.ps_status = ps_status;
	}
	public int getPs_id() {
		return ps_id;
	}
	public void setPs_id(int ps_id) {
		this.ps_id = ps_id;
	}
	public String getPs_user_email() {
		return ps_user_email;
	}
	public void setPs_user_email(String ps_user_email) {
		this.ps_user_email = ps_user_email;
	}
	public int getPs_blog_id() {
		return ps_blog_id;
	}
	public void setPs_blog_id(int ps_blog_id) {
		this.ps_blog_id = ps_blog_id;
	}
	public String getPs_status() {
		return ps_status;
	}
	public void setPs_status(String ps_status) {
		this.ps_status = ps_status;
	}
	@Override
	public String toString() {
		return "PraiseStatus [ps_id=" + ps_id + ", ps_user_email=" + ps_user_email + ", ps_blog_id=" + ps_blog_id
				+ ", ps_status=" + ps_status + "]";
	}
	
}
