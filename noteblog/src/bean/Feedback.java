package bean;

public class Feedback {
	private String content;
	private String contact;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Feedback() {
		
	}
	public Feedback(String content, String contact) {
		
		this.content = content;
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "Feedback [contact=" + contact + ", content=" + content + "]";
	}
	
	
	
	
}
