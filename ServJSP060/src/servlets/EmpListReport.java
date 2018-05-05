package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import domain.Emp;

@WebServlet("/EmpListReport")
public class EmpListReport extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmpDao empDao;
	
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
			empDao = new EmpDao(driver, url, userName, password);
		} catch (ClassNotFoundException | SQLException e) {
			throw new ServletException("Database Problem.", e);	// Exception wrapping and conversion.  Exception Chaining.
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empNo = Integer.parseInt(request.getParameter(""));
		ArrayList<Emp> empList = empDao.getEmpList();	// empDao.getEmp(empNo);
		request.setAttribute("listEmp", empList);	// Request scope.
		
		// User dispatcher to go to JSP.  We are deciding 1. Which data to send forward.  2. To whom to send the data.
		RequestDispatcher dispatch = request.getRequestDispatcher("/EmpList.jsp");
		dispatch.forward(request, response);
	}

	@Override
	public void destroy() {
		try {
			empDao.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.destroy();
	}
}
