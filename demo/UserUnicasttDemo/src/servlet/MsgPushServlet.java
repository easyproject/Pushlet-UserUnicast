package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.justobjects.pushlet.core.Dispatcher;
import nl.justobjects.pushlet.core.Event;

public class MsgPushServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		// ������Ϣ
		String msg=req.getParameter("msg");
//		String userId="JAY";
		// �����û�
		String userId=req.getParameter("userId");
		// �û����������ͷ�ʽ
		String type=req.getParameter("type");
		
		// �¼����������
		Event event = Event.createDataEvent("/push/hello");
		event.setField("msg", msg); //��������ת��ΪISO-8859-1
		
		// ����pushlet.properties��unicast.type����ֵ���͸�ָ���û�
//	    Dispatcher.getInstance().unicastUserId(event,userId);  
		
		 // ����ָ��type�������͸�ָ���û�
	    Dispatcher.getInstance().unicastUserId(event, userId, type); 
	}
}
