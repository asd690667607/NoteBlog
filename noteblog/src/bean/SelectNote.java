package bean;

public class SelectNote {
private String ntext;
private int user_id;

public String getNtext() {
	return ntext;
}
public void setNtext(String ntext) {
	this.ntext = ntext;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public SelectNote(String ntext, int user_id) {
	super();
	this.ntext = ntext;
	this.user_id = user_id;
}
public SelectNote() {
	super();
}

}
