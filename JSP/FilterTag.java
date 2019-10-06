package coreservlets.tags;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import coreservlets.*;

/** A tag that replaces <, >, ", and & with their HTML
* character entities (&lt;, &gt;, &quot;, and &amp;).
* After filtering, arbitrary strings can be placed
* in either the page body or in HTML attributes.
*/
public class FilterTag extends BodyTagSupport {
	public int doAfterBody() {
		BodyContent body = getBodyContent();
		
		try {
			JspWriter out = body.getEnclosingWriter();
			out.print("<B>" + body.getString() + " world" + "</B>");
		} catch(IOException ioe) {
			System.out.println("Error in FilterTag: " + ioe);
		}
		// SKIP_BODY means I'm done. If I wanted to evaluate
		// and handle the body again, I'd return EVAL_BODY_TAG.
		return(SKIP_BODY);
	}
}