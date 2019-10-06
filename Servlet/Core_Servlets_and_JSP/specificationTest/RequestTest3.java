import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class RequestTest3 extends HttpServlet { 

  private static final String CONTENT_TYPE = "text/html; charset=Shift_JIS";
  
  /**HTTP Get リクエストの処理*/
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    response.setContentType(CONTENT_TYPE);
    PrintWriter out = response.getWriter();
    ServletContext sc = getServletContext();

    out.println("<html>");
    out.println("<head><title>HttpServletRequest TEST</title></head>");
    out.println("<body>");
    out.println("<hr><br>");

    out.println("<table border=1>");    
    out.println("<tr><td>path</td><tr>");
    out.println("<tr><td>ContextPath</td><td>" + request.getContextPath() + "</td></tr>");
    out.println("<tr><td>ServletPath</td><td>" + request.getServletPath() + "</td></tr>");
    out.println("<tr><td>PathInfo</td><td>" + request.getPathInfo() + "</td></tr>");
    out.println("<tr><td>PathTranslated</td><td>" + request.getPathTranslated() + "</td></tr>");
    out.println("<tr><td>RealPath</td><td>" + sc.getRealPath(request.getContextPath()+request.getServletPath()) + "</td></tr>");
    out.println("</table>");
    
    out.println("<br>");
    out.println("<hr>");
    out.println("</body></html>");
    
    out.close();
  }
}