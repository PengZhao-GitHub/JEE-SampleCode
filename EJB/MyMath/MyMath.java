/*
 * Stateless EJB study.  
 * This is the object interface which implements the business logic.
 * by Peng Zhao 2002/10/09
 *
 */
 
 import javax.ejb.EJBObject;
 import java.rmi.RemoteException;
 
 public interface MyMath extends EJBObject {
     public int add(int a, int b) throws RemoteException;
     public int minus(int a, int b) throws RemoteException;
 }