package coreservlets.tags;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;

public class ProcessOrder{
	public int doStartTag(){
		JspWriter out = pageContext.getOut();
		out.println("doStartTag<br>");
		System.out.println("*****doStartTag()****");
		return(EVAL_BODY_INCLUDE);
	}

	
	public int doAfterBody(){
		BodyContent body = getBodyContent();
		try{
			JspWriter out = body.getEnclosingWriter();
			out.print("doAfterBody<br>");
		} catch(IOException ioe){
			System.out.println("Error in doAfterBody");
		}
				
	}
}