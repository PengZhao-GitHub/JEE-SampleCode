package coreservlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;

/** Servlet that takes a search string, number of results per
* page, and a search engine name, sending the query to
* that search engine. Illustrates manipulating
* the response status line. It sends a 302 response
* (via sendRedirect) if it gets a known search engine,
* and sends a 404 response (via sendError) otherwise.
*/
public class SearchEngines extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		String searchString = request.getParameter("searchString");
		if ((searchString == null) || (searchString.length() == 0)) {
			reportProblem(response, "Missing search string.");
			return;
		}

		// The URLEncoder changes spaces to "+" signs and other
		// non-alphanumeric characters to "%XY", where XY is the
		// hex value of the ASCII (or ISO Latin-1) character.
		// Browsers always URL-encode form values, so the
		// getParameter method decodes automatically. But since
		// we�fre just passing this on to another server, we need to
		// re-encode it.
		searchString = URLEncoder.encode(searchString);
		String numResults = request.getParameter("numResults");
		if ((numResults == null) || (numResults.equals("0")) || (numResults.length() == 0)) {
			numResults = "10";
		}

		String searchEngine = request.getParameter("searchEngine");
		if (searchEngine == null) {
			reportProblem(response, "Missing search engine name.");
			return;
		}

		SearchSpec[] commonSpecs = SearchSpec.getCommonSpecs();
		for(int i=0; i<commonSpecs.length; i++) {
			SearchSpec searchSpec = commonSpecs[i];
			if (searchSpec.getName().equals(searchEngine)) {
				String url = searchSpec.makeURL(searchString, numResults);
				response.sendRedirect(url);
				return;
			}
		}

		reportProblem(response, "Unrecognized search engine.");
	}

	private void reportProblem(HttpServletResponse response, String message) throws IOException {
		response.sendError(response.SC_NOT_FOUND, "<H2>" + message + "</H2>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}