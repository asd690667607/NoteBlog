package service;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mapper.NoteDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bean.Note;
import bean.SelectNote;


@Service
public class NoteServiceImpl implements NoteService{
	@Autowired
	private NoteDao noteDao;
	@Autowired  
	private HttpSession session;  

	@Autowired  
	private HttpServletRequest request; 
    
	public List<Note> findNoteByUid(int user_id) {
		// TODO Auto-generated method stub
		return noteDao.findNoteByUid(user_id);
	}
   
	public int insertNote(Note note) {
		// TODO Auto-generated method stub
		Date current_date = new Date();
		SimpleDateFormat  SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = SimpleDateFormat.format(current_date.getTime());
		int userId=(Integer)session.getAttribute("uId"); 
		note.setUser_id(userId);
		note.setNote_time(date);
		return noteDao.insertNote(note);
	}

	public List<Note> findNoteByntext(SelectNote sn) {
		// TODO Auto-generated method stub
		System.out.println("33333333333333333333333333333"+sn);
		List<Note> list=noteDao.findNoteByntext(sn);
		System.out.println("33333333333344444444444444");
		return list;
	}
	
	
	

}
