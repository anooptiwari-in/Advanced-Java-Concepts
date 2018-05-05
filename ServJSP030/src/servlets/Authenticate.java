package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Authenticate")
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// It is scriptlet.  It embeds java code.
		String usrNm = request.getParameter("userName");  // Collecting form data from Request.
		String passwd = request.getParameter("password"); 
		
		if (usrNm.equals("aaa") && passwd.equals("111")){
			
			// Request as a scope
			request.setAttribute("UserName", usrNm); // setAttribute() and getAttribute() for handling request scope.
			
			// Dispatcher for moving from this servlet to JSP.  Here is a forward dispatcher.
			RequestDispatcher dispatch = request.getRequestDispatcher("/Welcome.jsp");
			dispatch.forward(request, response);
		} else {
			RequestDispatcher dispatch = request.getRequestDispatcher("/Login.jsp");
			dispatch.forward(request, response);
		}
	}
}
