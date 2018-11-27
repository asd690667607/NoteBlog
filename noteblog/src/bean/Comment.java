package bean;

public class Comment {

	private int comment_id;
	private String comment_content;
	private String comment_time;
	private int blog_id;
	private String user_email;

	public Comment() {

	}

	public Comment(int comment_id, String comment_content, String comment_time, int blog_id, String user_email) {
		super();
		this.comment_id = comment_id;
		this.comment_content = comment_content;
		this.comment_time = comment_time;
		this.blog_id = blog_id;
		this.user_email = user_email;
	}

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}

	public String getComment_time() {
		return comment_time;
	}

	public void setComment_time(String comment_time) {
		this.comment_time = comment_time;
	}

	public int getBlog_id() {
		return blog_id;
	}

	public void setBlog_id(int blog_id) {
		this.blog_id = blog_id;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	@Override
	public String toString() {
		return "Comment [comment_id=" + comment_id + ", comment_content=" + comment_content + ", comment_time="
				+ comment_time + ", blog_id=" + blog_id + ", user_email=" + user_email + "]";
	}
	

}
