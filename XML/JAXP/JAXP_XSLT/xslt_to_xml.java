// JAXP packages 
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import org.w3c.dom.*;

import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import java.io.*;

public class xslt_to_xml{
	public static void main(String args[]){
		String data="";
		try{
			//Create the DOM builder
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setValidating(true);
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse("priceList.xml");
			
			//Add a new element in the DOM
			NodeList list = document.getElementsByTagName("name");
			System.out.println("list's length:" + list.getLength());
			Node thisNode = list.item(0);

			if(thisNode.getFirstChild().getNodeType() == Node.TEXT_NODE) {
				data = thisNode.getFirstChild().toString();
				System.out.println(data);
			}
			
			if (data.equals("Mocha Java")) { 
				Node newNode = document.createElement("coffee");
				Node nameNode = document.createElement("name");
				Text textNode = document.createTextNode("Kona");
				nameNode.appendChild(textNode);
				Node priceNode = document.createElement("price");
				Text tpNode = document.createTextNode("13.50");
				priceNode.appendChild(tpNode);
				newNode.appendChild(nameNode);
				newNode.appendChild(priceNode);
				System.out.println("before insert....");
				(thisNode.getParentNode().getParentNode()).insertBefore(newNode,thisNode.getParentNode());
				System.out.println("after inserted...");
			}

			NodeList newList = document.getElementsByTagName("name");
			System.out.println("list's length:" + newList.getLength());
			for (int i=0; i< newList.getLength(); i++){
				Node node = newList.item(i);
				System.out.println(node.getFirstChild().toString());
			}
		
			//Transfer it to another xml file
			//*******************************
			TransformerFactory transFactory = TransformerFactory.newInstance();
			Transformer transformer = transFactory.newTransformer();

			DOMSource source = new DOMSource(document);

			File newXML = new File("newXML.xml");
			FileOutputStream os = new FileOutputStream(newXML);
			StreamResult result = new StreamResult(os);
			transformer.transform(source, result);
		} catch(Exception ex){
			System.out.println(ex);
		}
	}
}