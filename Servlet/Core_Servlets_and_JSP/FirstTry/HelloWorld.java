package mytest;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloWorld extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setStatus(500);
		out.println("Hello World");
	}

	public void doOptions(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		response.setHeader("Allow","Hello");
		response.setHeader("key1","cool");

		PrintWriter out = response.getWriter();
		out.println("Hello World");
		
	}
}