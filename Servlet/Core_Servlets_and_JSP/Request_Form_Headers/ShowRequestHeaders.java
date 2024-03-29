package coreservlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

/** Shows all the request headers sent on this
* particular request.
*/
public class ShowRequestHeaders extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Servlet Example: Showing Request Headers";
		out.println(ServletUtilities.headWithTitle(title) +
			"<BODY BGCOLOR=\"#FDF5E6\">\n" +
			"<H1 ALIGN=CENTER>" + title + "</H1>\n" +
			"<B>Request Method: </B>" +
			//request.getMethod()
			//*******************
			request.getMethod() + "<BR>\n" +
			"<B>Request URI: </B>" +
			//request.getRequestURI()
			//***********************
			request.getRequestURI() + "<BR>\n" +
			"<B>Request Protocol: </B>" +
			//request.getProtocol()
			//*********************
			request.getProtocol() + "<BR><BR>\n" +
			"<TABLE BORDER=1 ALIGN=CENTER>\n" +
			"<TR BGCOLOR=\"#FFAD00\">\n" +
			"<TH>Header Name<TH>Header Value");
		//request.getHeaderNames()
		//************************
		Enumeration headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			String headerName = (String)headerNames.nextElement();
			out.println("<TR><TD>" + headerName);
			//request.getHeader(headerName)
			//*****************************
			out.println(" <TD>" + request.getHeader(headerName));
		}

		out.println("</TABLE>\n</BODY></HTML>");
	}

	/** Let the same servlet handle both GET and POST. */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}