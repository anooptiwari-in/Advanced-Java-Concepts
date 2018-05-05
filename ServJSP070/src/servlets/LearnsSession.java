package servlets;

import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LearnsSession")
public class LearnsSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Create a Session
		HttpSession session = request.getSession(true);  // If session does not exist create it and if exist do not create again but bring reference
														// of existing session.
		
		System.out.println(session.getId());		// Returns unique session id generated.
		System.out.println(session.getCreationTime());	// Returns a time of creation of session.
		System.out.println(session.getLastAccessedTime());	// Returns a time of last access of session.
		System.out.println(session.getMaxInactiveInterval());	// Returns for how much time session remains inactive.
		
		session.setAttribute("x", 15);	// Session is a scope larger than Request. 
		Enumeration<String> attributes = session.getAttributeNames();
		
		while(attributes.hasMoreElements()){
			System.out.println(attributes.nextElement());
		}
		
		session.invalidate();		// Removes/deletes a session scope, object.
	}
}
