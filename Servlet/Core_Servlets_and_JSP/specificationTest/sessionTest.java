import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class sessionTest extends HttpServlet { 

  private static final String CONTENT_TYPE = "text/html; charset=Shift_JIS";
  
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    response.setContentType(CONTENT_TYPE);

    PrintWriter out = response.getWriter();

    HttpSession session = request.getSession(true);
    
    out.println("<html>");
    out.println("<head><title>ServletContext TEST1</title></head>");
    out.println("<body>");

    // Context check
    out.println("Context check <br>");
    ServletContext sc = getServletContext();
    Enumeration em = sc.getAttributeNames();
    while(em.hasMoreElements()){
        String name = (String)(em.nextElement());
        out.println(name + "=");
        out.println(sc.getAttribute(name));
        out.println("<br>");
    }

    // Session Test
    out.println("Session Test Servlet <br>");
    out.println("Seesion ID:" + session.getId() );
    out.println("<hr>");

    session.setAttribute("key1","Hello");
    session.setAttribute("key2","World");
    
    em = session.getAttributeNames();
    while(em.hasMoreElements()){
        String name = (String)(em.nextElement());
        out.println(name + "=");
        out.println(session.getAttribute(name));
        out.println("<br>");
    }

    out.println("<a href='" + response.encodeURL("sessionTest") + "' >" + " click me" + " </a>");
    out.println("</body></html>");
    
    out.close();
  }

}