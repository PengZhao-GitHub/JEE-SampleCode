package examples;

import javax.ejb.SessionContext;

/**
 * Demonstration stateless session bean.
 */
public class HelloBean implements javax.ejb.SessionBean
{
    //
    // EJB-required methods
    //
    public void ejbCreate()
    {
        System.out.println("ejbCreate()");
    }

    public void ejbRemove()
    {
        System.out.println("ejbRemove()");
    }

    public void ejbActivate()
    {
        System.out.println("ejbActivate()");
    }

    public void ejbPassivate()
    {
        System.out.println("ejbPassivate()");
    }

    public void setSessionContext(SessionContext ctx)
    {
        System.out.println("setSessionContext()");
    }

    //
    // Business methods
    //
    public String hello()
    {
        System.out.println("hello()");
        return "Hello, World!";
    }
}
