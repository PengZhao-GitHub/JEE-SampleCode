// JAXP packages 
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import org.w3c.dom.*;

import java.io.*;

public class dom {
	public static void main(String args[]){
		String data="";
		try{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setValidating(true);
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse("priceList.xml");

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
				thisNode.getParentNode().insertBefore(newNode,thisNode);
				System.out.println("after inserted...");
			}

			NodeList newList = document.getElementsByTagName("name");
			System.out.println("list's length:" + newList.getLength());
			for (int i=0; i< newList.getLength(); i++){
				Node node = newList.item(i);
				System.out.println(node.getFirstChild().toString());
				
			}

		} catch(Exception ex){
			System.out.println(ex);
		}
	}
}