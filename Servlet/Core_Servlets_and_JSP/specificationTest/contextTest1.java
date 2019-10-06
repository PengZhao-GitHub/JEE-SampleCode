import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class contextTest1 extends HttpServlet { 

  private static final String CONTENT_TYPE = "text/html; charset=Shift_JIS";
  
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    response.setContentType(CONTENT_TYPE);

    //Get servlet context
    ServletContext sc = getServletContext();

    PrintWriter out = response.getWriter();
    
    out.println("<html>");
    out.println("<head><title>ServletContext TEST1</title></head>");
    out.println("<body>");

    out.println("Another Servlet <br>");
    out.println("<hr>");

    Enumeration em = sc.getAttributeNames();
    while(em.hasMoreElements()){
        String name = (String)(em.nextElement());
        out.println(name + "=");
        out.println(sc.getAttribute(name));
        out.println("<br>");
    }

    out.println("</body></html>");
    
    out.close();
  }
}