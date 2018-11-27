package bean;

public class Blog_list {
	private int blog_id;
	private String blog_title;
	private String blog_class;
	private String blog_summary;
	private String blog_tag;
	private String blog_time;
	private String user_id;
	private int blog_praise;
	public Blog_list() {
		
	}
	
	public int getBlog_id() {
		return blog_id;
	}

	public void setBlog_id(int blogId) {
		blog_id = blogId;
	}

	public String getBlog_title() {
		return blog_title;
	}

	public void setBlog_title(String blogTitle) {
		blog_title = blogTitle;
	}

	public String getBlog_class() {
		return blog_class;
	}

	public void setBlog_class(String blogClass) {
		blog_class = blogClass;
	}

	public String getBlog_summary() {
		return blog_summary;
	}

	public void setBlog_summary(String blogSummary) {
		blog_summary = blogSummary;
	}

	public String getBlog_tag() {
		return blog_tag;
	}

	public void setBlog_tag(String blogTag) {
		blog_tag = blogTag;
	}

	public String getBlog_time() {
		return blog_time;
	}

	public void setBlog_time(String blogTime) {
		blog_time = blogTime;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String userId) {
		user_id = userId;
	}

	public int getBlog_praise() {
		return blog_praise;
	}

	public void setBlog_praise(int blogPraise) {
		blog_praise = blogPraise;
	}

	public Blog_list(int blogId, String blogTitle, String blogClass,
			String blogSummary, String blogTag, String blogTime, String userId,
			int blogPraise) {
		super();
		blog_id = blogId;
		blog_title = blogTitle;
		blog_class = blogClass;
		blog_summary = blogSummary;
		blog_tag = blogTag;
		blog_time = blogTime;
		user_id = userId;
		blog_praise = blogPraise;
	}

	@Override
	public String toString() {
		return "Blog_list [blog_class=" + blog_class + ", blog_id=" + blog_id
				+ ", blog_praise=" + blog_praise + ", blog_summary="
				+ blog_summary + ", blog_tag=" + blog_tag + ", blog_time="
				+ blog_time + ", blog_title=" + blog_title + ", user_id="
				+ user_id + "]";
	}
	
	
	
	
	
	
}
