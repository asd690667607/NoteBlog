package bean;

import java.util.Date;

public class Note {

   private int note_id;
   private String note_time;
   private String note_title;
   private String note_content;
   private int user_id;
public int getNote_id() {
	return note_id;
}
public void setNote_id(int noteId) {
	note_id = noteId;
}
public String getNote_time() {
	return note_time;
}
public void setNote_time(String noteTime) {
	note_time = noteTime;
}
public String getNote_title() {
	return note_title;
}
public void setNote_title(String noteTitle) {
	note_title = noteTitle;
}
public String getNote_content() {
	return note_content;
}
public void setNote_content(String noteContent) {
	note_content = noteContent;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int userId) {
	user_id = userId;
}
public Note(int noteId, String noteTime, String noteTitle, String noteContent,
		int userId) {
	super();
	note_id = noteId;
	note_time = noteTime;
	note_title = noteTitle;
	note_content = noteContent;
	user_id = userId;
}
public Note() {
	super();
}
@Override
public String toString() {
	return "Note [note_content=" + note_content + ", note_id=" + note_id
			+ ", note_time=" + note_time + ", note_title=" + note_title
			+ ", user_id=" + user_id + "]";
}

}