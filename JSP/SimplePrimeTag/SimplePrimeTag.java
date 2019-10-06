package coreservlets.tags;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.math.*;

/** Generates a prime of approximately 50 digits.
* (50 is actually the length of the random number
* generated -- the first prime above that number will
* be returned.)
*/
public class SimplePrimeTag extends TagSupport {
	protected int len = 50;
	
	public int doStartTag() {
		try {
			JspWriter out = pageContext.getOut();
			out.print("<input type='text' name='text1' value='Hello world'");
		} catch(IOException ioe) {
			System.out.println("Error generating prime: " + ioe);
		}
		return(SKIP_BODY);
	}
}