import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class contextTest extends HttpServlet { 

  private static final String CONTENT_TYPE = "text/html; charset=Shift_JIS";
  
  /**HTTP Get リクエストの処理*/
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    response.setContentType(CONTENT_TYPE);

    //Get servlet context
    ServletContext sc = getServletContext();

    //Get init parameter names
    //Enumeration em = sc.getInitParameterNames();

    Enumeration em = getInitParameterNames();

    PrintWriter out = response.getWriter();
    
    out.println("<html>");
    out.println("<head><title>ServletContext TEST</title></head>");
    out.println("<body>");

    //out.println("<table>");    

    while(em.hasMoreElements()){
        String name = (String)(em.nextElement());
        out.println(name + "=");
	out.println(getInitParameter(name));
        out.println("<br>");

    }
    out.println("<br>");
    out.println("<hr>");

    sc.setAttribute("attr1","Hello");
    sc.setAttribute("attr2","World");

    em = sc.getAttributeNames();
    while(em.hasMoreElements()){
        String name = (String)(em.nextElement());
        out.println(name + "=");
        out.println(sc.getAttribute(name));
        out.println("<br>");
    }

    
    //out.println("</table>");

    out.println("</body></html>");
    
    out.close();
  }

}