package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Presentor")
public class Presentor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer val1 = (Integer)request.getAttribute("DataBinder");
		Integer val2 = (Integer) request.getAttribute("DataProcessor");
		
		PrintWriter out = response.getWriter();
		
		out.write("Presentor");
		out.write(val1+"    "+val2);
		
		//response.flushBuffer();
	}
}
