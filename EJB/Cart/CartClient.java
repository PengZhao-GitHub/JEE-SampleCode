import java.util.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

public class CartClient {
	public static void main(String[] args) {
		try{
			Context initial = new InitialContext();
			Object objref = initial.lookup("java:comp/env/ejb/MyCart");
		
			CartHome home = (CartHome)PortableRemoteObject.narrow(objref,CartHome.class);
		
			Cart shoppingCart = home.create("Duke DeEarl","123");

			shoppingCart.addBook("The Martian Chronicles");
			shoppingCart.addBook("2001 A Space Odyssey");
			shoppingCart.addBook("The Left Hand of Darkness");

			Vector bookList = new Vector();
			bookList = shoppingCart.getContents();

			Enumeration enumer = bookList.elements();
			while(enumer.hasMoreElements()){
				String title = (String) enumer.nextElement();
				System.out.println(title);
			}

			shoppingCart.removeBook("Alice in Wonderland");
			shoppingCart.remove();
			
			System.exit(0);
		} catch(BookException ex){
			System.err.println("Caught a BookException:" + ex.getMessage());
		} catch(Exception ex){
			System.err.println("Caught an unexpected exception!");
			ex.printStackTrace();
			System.exit(1);
		}
	}
}