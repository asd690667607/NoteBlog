package service;

import java.util.List;

import bean.Note;
import bean.SelectNote;

public interface NoteService {

	List<Note> findNoteByUid(int user_id);
	//增加笔记信息
	 int insertNote(Note note);
	 
	 List<Note>  findNoteByntext(SelectNote sn);//模糊查询
	
}
