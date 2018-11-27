package listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import entity.SessionContext;

/**监听session的创建与销毁 */
public class CreateSessionListener implements HttpSessionListener{

	public void sessionCreated(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		SessionContext.add(session);
	}

	public void sessionDestroyed(HttpSessionEvent event) {
		SessionContext.delete(event.getSession());
	}

}
