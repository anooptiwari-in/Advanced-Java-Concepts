package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserMasterDao;

@WebServlet("/Authenticate")
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserMasterDao userDao;
	
	@Override	// init() is for overriding.  And init(ServletConfig) should be avoided for overriding because it has some pre-requisite.
	public void init() throws ServletException {
		//  Getting context reference
		ServletContext ctx = super.getServletContext();
		
		// Getting context data
		String driver = ctx.getInitParameter("driver");
		String url    = ctx.getInitParameter("url");
		String userName = ctx.getInitParameter("userName");
		String password = ctx.getInitParameter("password");
				
		try {
			userDao = new UserMasterDao(driver, url, userName, password);
		} catch (ClassNotFoundException | SQLException e) {
			throw new ServletException("Database Problem.", e);	// Exception wrapping and conversion.  Exception Chaining.
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		// pass on these username and password to the UserMasterDao for authetication check.
		String userNameChecked = userDao.checkAuthentication(userName, password);	// Expected values userName for valid authentication and 'null' for failed authentication.
		RequestDispatcher dispatch;
		if (userNameChecked != null){
			dispatch = request.getRequestDispatcher("/WEB-INF/innerPages/Welcome.jsp");
			
			// Start a session.
			HttpSession session = request.getSession(true);
			session.setAttribute("userName", userNameChecked);
		} else {
			dispatch = request.getRequestDispatcher("/Login.jsp");
		}
		
		dispatch.forward(request, response);
	}
}
