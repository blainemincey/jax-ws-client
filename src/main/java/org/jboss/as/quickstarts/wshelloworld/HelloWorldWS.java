package org.jboss.as.quickstarts.wshelloworld;

/**
 * This example demonstrates the use an external JAX-WS client
 * which interacts with a JAX-WS Web service that uses CDI 1.0 and JAX-WS 
 * in JBoss AS 7.  Specifically, this class acts as the web service in which
 * the test client will call.
 * 
 * Please refer to the README.md on how this class should be deployed to
 * JBoss AS 7.
 */
import javax.jws.WebService;
import javax.jws.WebMethod;

/**
 * The purpose of this class is to act as a JAX-WS
 * web service.  It utilizes simple annotations to
 * instrument the class as a web service.  This class
 * is referenced in the web.xml as a servlet.
 * 
 * @author Blaine Mincey, blaine.mincey@redhat.com
 * 
 */

// The @WebService annotation marks this class as a web service.
@WebService
public class HelloWorldWS
{
    // Constant to reference the response message
    private String message = new String("Hello, ");
    
    /**
     * Empty method declaration
     */
    public void Hello()
    {
        
    }
    
    /**
     * The purpose of this method is to combine the 
     * argument with the String constant above as a 
     * response to the web service call.
     * 
     * @param name The name or string value passed to the method
     * 
     * @return String "Hello, <name>!"
     */
    // The @WebMethod annotation marks this method as the interface
    // into this web service.
    @WebMethod
    public String sayHello(String name)
    {
        String returnMessage = message + name + "!";
        
        System.out.println("Return message: " + returnMessage);
        
        return returnMessage;
    }
}
