package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Note;
import bean.SelectNote;
import bean.User;


import service.NoteService;

@Controller
public class NoteController {
	@Autowired
	private NoteService noteService;
	
	
	 @RequestMapping("/findNote")
	 @ResponseBody
	    public List<Note> findNote(HttpSession session,HttpServletRequest request){
		    System.out.println("77777777777777777777777777777777777777777");
		    
		    List<Note> list=null;
		    if(session.getAttribute("uId")!=null){
		    int userId=(Integer)session.getAttribute("uId"); 
		    System.out.println(userId+"666666666666666666666666");
		     list = noteService.findNoteByUid(userId);
		    }
		    System.out.println(list);
		    return list;
	    }
	 
	 @RequestMapping("/findNoteByntext")
	 @ResponseBody
	    public List<Note> findNoteByntext(HttpSession session,HttpServletRequest request){
		 String ntext=request.getParameter("ntext");
		    System.out.println("8888888888"+ntext);
		    List<Note> ntexts=null;
		    if(session.getAttribute("uId")!=null){
		    int user_id=(Integer)session.getAttribute("uId"); 
		    System.out.println(user_id+"999999999");
		  SelectNote sn=new SelectNote();
		  sn.setNtext("%"+ntext+"%");
		  sn.setUser_id(user_id);
		     ntexts = noteService.findNoteByntext(sn);
		     System.out.println(ntexts+"111111111111111111111");
		    }
		    System.out.println(ntexts+"111111111111111111111");
		    return ntexts;
	    }
	 
	 @RequestMapping("/insertNote")
		public void insertNote(Note note,HttpServletRequest request,HttpSession session, HttpServletResponse response)throws ServletException, IOException{
			if(note.getNote_content()!=""){
		 int result=noteService.insertNote(note);
			 int userId=(Integer)session.getAttribute("uId"); 
			PrintWriter out=response.getWriter();
			if(result==1){
				System.out.println("加载成功");
				out.println(1);
			}
			else
			{
				out.println(0);
			}
		}
			
	 }
		
}
