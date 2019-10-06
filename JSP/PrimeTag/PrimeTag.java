package coreservlets.tags;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;


public class PrimeTag extends TagSupport {
	protected int len = 50;
	
	public int doStartTag() {
		try {
			JspWriter out = pageContext.getOut();
			out.print("<input type='text' name='text1' value='Hello world' size=" + len + " > ");
		} catch(IOException ioe) {
			System.out.println("Error generating prime: " + ioe);
		}
		return(SKIP_BODY);
	}
	
	public void setLength(String length) {
		try {
			len = Integer.parseInt(length);
		} catch(NumberFormatException nfe) {
			len = 50;
		}
	}
}