package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:8181/ServJSP010/FirstServlet

/*
 * 1. Class extends javax.servlet.http.HttpServlet
 * 2. The @WebServlet is an annotation which declares this class object as a servlet.
 * 3. The alias for following servlet is 'FirstServlet'.  It is called as URL.
 * 4. The doGet() takes two parameters Request and Response.
 * 5. The request object is populated with the data client has submitted through browser.
 * 6. On receipt of the request from Browser, web server collects the query string data/form data, populate that data into newly created
 * 		Request object(HttpServletRequest) and its reference is given to the doGet();
 * 7. Also web server creates an empty Response object.  The doGet() method has to create a web page within Response object.
 * 8. Web server sends this web page created within Response object back to client side browser.
 * 9. Deployment is the process in which server instantiate a servlet, treat it as web component, make it to undergo life cycle methods
 * 		and  make it ready to receive requests.
 * 10. Cold deployment means shutting and restarting a server.
 * 11. Warm Deployment means without shutting the server ensuring deployment of the servlet.  
 * 		It happens in the server which can sense change in the time stamp of .class file.
 * 
 * Observations on Life cycle of servlet...
 * 1. There are three life cycle methods- 
 * 		init(): Once for the first time the object is deployed.
 * 		destroy(): Once for last time the object is un-deployed.
 * 		service(): Every time on receipt of the request.
 * 
 * 2. Server needs default constructor for creating Servlet Object.  No other constructor is used by server.
 * 3. Do not explicitly mention constructor.  For initialization use init().  And for closing resources, use destroy().
 * 4. MyServlet extends HttpServlet extends GenericServlet implements interfaces- Servlet, ServletConfig, Serializable.
 * 5. Servlet interface defines life cycle methods.
 * 6. HttpServlet defines doXXX methods.
 * 7. The WEB-INF makes a project as web project.
 * 8. web.xml: Web configuration file.
 * 9. Declare a servlet either using annotation or configuring in XML.  Both configuration approached are not allowed for a servlet.
 * 10. In same project you can have some servlets configured through annotation and some of them may be through XML.
 * 
 * Directory Structured..
 * 	1. A Deployment directory structure is STANDARD.  It means same directory structure must followed for deploying a project on any Java Web Server.
 * 		classes: To hold all .class files of servlets and supporting classes
 * 		lib: A place to keep supporting JAR files.(May be DB driver).
 * 		web.xml: Configuration file for web application.
 */

//@WebServlet("/FirstServlet") // Runtime, Class level Annotation
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FirstServlet(){
		System.out.println("In constructor");
	}
	
	@Override	// This method is executed immediate before un-deploying servlet from server.
	public void destroy() {
		System.out.println("In destroy()");
		super.destroy();
	}

	@Override   // This method is executed immediate after constructor.  This is for initializing servlet.  Avoid writing constructor.
	public void init() throws ServletException {
		super.init();
		System.out.println("In init()");
	}
 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In doGet()");
		PrintWriter out = response.getWriter();
		out.write("<html>");
		out.write("<head>");
			out.write("<title>First page</title>");
		out.write("</head>");
			out.write("<body>");
				out.write("<H1>First web page.</H1>");
				out.write("Hello world.");
			out.write("</body>");
		out.write("</html>");
		
		out.close();
	}
}
