/*
 * Stateless EJB study.
 * This the bean
 * by Peng Zhao 2002/10/09
 */
 
 import java.rmi.RemoteException;
 import javax.ejb.SessionBean;
 import javax.ejb.SessionContext;
 
 public class MyMathBean implements SessionBean {
    //Constructor
    //-----------
    public MyMathBean(){};
    
    //SessionBean interface's methods
    //-------------------------------
    public void ejbCreate() {}
    public void ejbRemove() {}
    public void ejbActivate()  {}
    public void ejbPassivate() {}
    public void setSessionContext(SessionContext sc) {}
    
    //Business logic
    //--------------
    public int add(int a, int b) {
        return a+b;
    }
    public int minus(int a, int b){
        return a-b;
    }
    
 }