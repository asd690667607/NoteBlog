package mapper;

import java.util.List;


import bean.Note;
import bean.SelectNote;


public interface NoteDao {
//获取数据库个人笔记的信息
	
	List<Note> findNoteByUid(int user_id);
	//增加笔记信息
	 int insertNote(Note note);
	 List<Note>  findNoteByntext(SelectNote sn);
	
}
