package study.jsp.tags;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;


public class SimpleTag extends TagSupport {	
	public int doStartTag() {
		try{
		    JspWriter out = pageContext.getOut();
		    out.print("<input type='text' name='text1' value='Hello world' > ");
		} catch (Exception ex){
		    System.out.println(ex);
		}
		return(SKIP_BODY);
	}
}