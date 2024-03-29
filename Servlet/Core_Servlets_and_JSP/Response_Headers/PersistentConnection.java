package coreservlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

/** Illustrates the value of persistent HTTP connections for
* pages that include many images, applet classes, or
* other auxiliary content that would otherwise require
* a separate connection to retrieve.
*/
public class PersistentConnection extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream(7000);
		PrintWriter out = new PrintWriter(byteStream, true);	
		String persistenceFlag =
		request.getParameter("usePersistence");
		boolean usePersistence = ((persistenceFlag == null) ||(!persistenceFlag.equals("no")));
		String title;
		if (usePersistence) {
			title = "Using Persistent Connection";
		} else {
			title = "Not Using Persistent Connection";
		}

		out.println(ServletUtilities.headWithTitle(title) +
			"<BODY BGCOLOR=\"#FDF5E6\">\n" +
			"<H1 ALIGN=\"CENTER\">" + title + "</H1>");
		int numImages = 1;
		for(int i=0; i<numImages; i++) {
			out.println(makeImage(i, usePersistence));
			out.println(request.getServerPort());
		}

		out.println("</BODY></HTML>");
		if (usePersistence) {
			response.setContentLength(byteStream.size());
		}

		byteStream.writeTo(response.getOutputStream());
	}

	private String makeImage(int n, boolean usePersistence) {
		String file =
			"/servlets/coreservlets.ImageRetriever?gifLocation=" +
			"/1.gif";
		if (!usePersistence)
			file = file + "&usePersistence=no";
		return("<IMG SRC=\"" + file + "\"\n" +" WIDTH=30 HEIGHT=30 ALT=\"\">");
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		doGet(request, response);
	}
}