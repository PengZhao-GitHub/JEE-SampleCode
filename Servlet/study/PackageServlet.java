package servletStudy;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class PackageServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        String docType = 
            "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
            "Transitional//EN\"\n";
        out.println(docType +
                    "<HTML>\n" +
                    "<HEAD><TITLE>Hello WWW</TITLE></HEAD>\n" + 
                    "<BODY>\n" + 
                    "<H1>Hello WWW</H1>\n" + 
                    "</BODY></HTML>"
            );
    }

}