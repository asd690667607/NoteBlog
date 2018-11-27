package entity;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

/**session的上下文类:封装针对session操作的方法 */
public class SessionContext {
    //存放的是整个项目里面所有的session
	private static Map<String, HttpSession> map=new HashMap<String, HttpSession>();
	
	/**往SessionContext上下文里面添加session */
	public static void add(HttpSession session){
		System.out.println(" :--->SessionContext add:"+session.getId());
		map.put(session.getId(), session);
	}
	
	/**SessionContext上下文里面 查找session */
	public static HttpSession get(String sessionId){
		System.out.println(map.entrySet());
		System.out.println(sessionId+" :--->SessionContext get:"+map.get(sessionId));
		return map.get(sessionId);
	}
	
	/**SessionContext上下文里面删除session */
	public static void delete(HttpSession session){
		map.remove(session.getId());
	}
}
