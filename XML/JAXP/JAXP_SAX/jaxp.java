/**
 * This is a test of the Java API for XML Processing
 * By Peng Zhao 
 * 06/17/2002
 */
//Java api for xml processing
//***************************
// JAXP packages
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

import java.util.*;
import java.io.*;

public class jaxp extends DefaultHandler {
	public static void main(String args[]){
		try{
			SAXParserFactory factory = SAXParserFactory.newInstance();
			factory.setValidating(true);
			SAXParser saxParser = factory.newSAXParser();
			saxParser.parse("priceList.xml", new jaxp());
		} catch (Exception ex){
			System.out.println(ex);
		}
	}

	public void startDocument() {
		System.out.println("Parsing start...");
	}

	public void startElement(String uri,String localName,String qName,Attributes attributes) throws SAXException{
		System.out.println("<" + qName + ">");
	}

	public void characters(char[] ch,int start,int length) throws SAXException {
		String str = new String(ch,start,length);
		System.out.println(str);
	}
	
	public void endElement(String uri,String localName,String qName) throws SAXException {
		System.out.println("</" + qName + ">");
	}

	public void endElement(String uri,String localName,String qName,Attributes attributes) throws SAXException {
		System.out.println("uri=" + uri + " localName=" + localName + " qName=" + qName);
	}

	public void endDocument() {
		System.out.println("Parsing end...");
	}

	public void error(SAXParseException e) throws SAXException {
		System.out.println("Error:" + e);
	}

	public void fatalError(SAXParseException e) throws SAXException {
		System.out.println("FatalError:" + e);
	}

}