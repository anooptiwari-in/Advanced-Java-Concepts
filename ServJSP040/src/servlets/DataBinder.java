package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// URL: http://localhost:8181/ServJSP040/DataBinder

@WebServlet("/DataBinder")
public class DataBinder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("DataBinder", 10);
		
		PrintWriter out = response.getWriter();
		
		out.write("Data Binder");
		
		RequestDispatcher dispatch = request.getRequestDispatcher("/DataProcessor");
		dispatch.forward(request, response);
	}
}
