/*
 * Stateless EJB study.
 * This the HOME interface which implements the control function of the EJB.
 * by Peng Zhao 2002/10/09
 */
 
 import java.io.Serializable;
 import java.rmi.RemoteException;
 import javax.ejb.CreateException;
 import javax.ejb.EJBHome;
 
 public interface MyMathHome extends EJBHome {
     MyMath create() throws RemoteException, CreateException;
 }