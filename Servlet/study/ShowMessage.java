package servletStudy;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ShowMessage extends HttpServlet {
    private String message;
    private String defaultMessage = "No message.";
    private int repeats = 1;
    
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        message = config.getInitParameter("message");
        if (message == null) {
            message = defaultMessage;
        }
        
        try{
            String repeatString = config.getInitParameter("repeats");
            repeats = Integer.parseInt(repeatString);
        } catch(NumberFormatException nfe){
        
        }
    }
    
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "The ShowMessage Servlet";
        out.println("<HTML><HEAD><TITLE>" + title + "</TITLE></HEAD>" + 
                    "<BODY>" + 
                    "<H1 ALIGN=CENTER>" + title + "</H1>");
        for (int i=0; i<repeats; i++){
            out.println(message + "<BR>");
        }
        
        out.println("</BODY></HTML>");
                    
    }
}