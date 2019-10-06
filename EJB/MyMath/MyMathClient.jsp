<%--
  This is a ejb client test.
  by Peng Zhao
  2002/11/11
--%>

<%@ page import="javax.ejb.*" %>
<%@ page import="javax.naming.*" %>
<%@ page import="javax.rmi.PortableRemoteObject" %>
<%@ page import="java.rmi.RemoteException" %>

<%@ page import="MyMath" %>
<%@ page import="MyMathHome" %>

<%!
   //Create a MyMath handler and it can be access in the whole page.
   private MyMath handler = null;

   public void jspInit() { 
      try {
         InitialContext ic = new InitialContext();
         Object objRef = ic.lookup("java:comp/env/ejb/MyMath");
         MyMathHome home = (MyMathHome)PortableRemoteObject.narrow(
                    objRef, 
                    MyMathHome.class
                );
            
         handler = home.create();
      } catch (RemoteException ex) {
            System.out.println("Couldn't create MyMath bean."+ ex.getMessage());
      } catch (CreateException ex) {
            System.out.println("Couldn't create MyMath bean."+ ex.getMessage());
      } catch (NamingException ex) {
            System.out.println("Unable to lookup home: "+ "MyMath "+ ex.getMessage());
      } 
   }

   public void jspDestroy() {    
         handler = null;
   }
%>

<html>
<header>
<title>Hello This is EJB Client TEST </title>
</header>
<body>
<%  
   int a = Integer.parseInt(request.getParameter("a"));
   int b = Integer.parseInt(request.getParameter("b"));
   out.println(handler.add(a,b));
%>
<body>
</html>






