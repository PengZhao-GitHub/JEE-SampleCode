import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

import MyMath;
import MyMathHome;

public class MyMathClient {
    public static void main(String[] args){
        try{
            Context initial = new InitialContext();
            Object objref = initial.lookup("java:comp/env/ejb/MyMath");
            
            MyMathHome home = (MyMathHome)PortableRemoteObject.narrow(
                objref, 
                MyMathHome.class
                );
            
            MyMath handler = home.create();
            
            System.out.println(handler.add(10,20));
            System.out.println(handler.minus(10,20));
            
            System.exit(0);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}