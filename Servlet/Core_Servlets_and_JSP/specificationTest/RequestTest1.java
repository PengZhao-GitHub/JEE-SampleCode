import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class RequestTest1 extends HttpServlet { 

  private static final String CONTENT_TYPE = "text/html; charset=Shift_JIS";
  
  /**HTTP Get リクエストの処理*/
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    response.setContentType(CONTENT_TYPE);
    PrintWriter out = response.getWriter();

    out.println("<html>");
    out.println("<head><title>HttpServletRequest TEST</title></head>");
    out.println("<body>");
    out.println("<hr><br>");

    out.println("<table border=1>");    
    out.println("<tr><td>Parameters</td><tr>");
    Enumeration em = request.getParameterNames();
    
    while(em.hasMoreElements()){
        String name = (String)(em.nextElement());
        out.println("<tr>");
        out.println("<td> " + name + " </td>");
        String[] values = request.getParameterValues(name);
        for (int i=0; i < values.length; i++){
	          out.println("<td> " + values[i] + " </td>");
        }
        out.println("</tr>");

    }
    out.println("</table>");
    
    out.println("<br>");
    out.println("<hr>");
    out.println("</body></html>");
    
    out.close();
  }

}