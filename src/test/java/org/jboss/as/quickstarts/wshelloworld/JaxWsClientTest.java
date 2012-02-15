package org.jboss.as.quickstarts.wshelloworld;

/**
 * This example demonstrates the use an external JAX-WS client
 * which interacts with a JAX-WS Web service that uses CDI 1.0 and JAX-WS 
 * in JBoss AS 7.  Specifically, this client "calls" the HelloWorld JAX-WS
 * Web Service created that is part of this quickstart.  
 * 
 * Please refer to the README.md on how to deploy the JAX-WS web service 
 * and how to invoke this test client.
 */
import javax.xml.ws.WebServiceRef;

import org.jboss.as.quickstarts.wshelloworld.HelloWorldWSI;
import org.jboss.as.quickstarts.wshelloworld.HelloWorldWSService;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The purpose of this class is to utilize JUnit4 as a test harness
 * to invoke the JAX-WS web service that should be deployed as part
 * of this quickstart.
 * 
 * It should be noted that this class interacts with classes that were
 * generated utilizing wsimport.  In order to generate the required client
 * classes for this quickstart, the following command was run:
 * 
 * wsimport -s . http://localhost:8080/jax-ws-client/HelloWorld?wsdl
 * 
 * This command generated the sources from the WSDL associated at the
 * URL above.  These classes were included as a convenience for this
 * quickstart.  The generated HelloWorldWS was renamed to HelloWorldWSI
 * to avoid naming conflicts with the actual web service that is part
 * of this quickstart.
 * 
 * @author Blaine Mincey, blaine.mincey@redhat.com
 *
 */
public class JaxWsClientTest
{
    /**
     * The @WebServiceRef annotation is used to define a reference
     * to a web service and an injection target for it.
     */
    @WebServiceRef(wsdlLocation = 
            "http://localhost:8080/jax-ws-client/HelloWorld?wsdl")

    /**
     * This is a reference to a generated class from wsimport.
     */
    private static HelloWorldWSService serviceProxy = new HelloWorldWSService();
    
    
    /**
     * The purpose of this method is to execute a JUnit4 test.  This
     * method will invoke the web service that was deployed earlier
     * as part of this quickstart.  The web service must be deployed
     * prior to executing this class.
     * 
     * The @Test annotation marks this method to be run by JUnit4.
     */
    @Test
    public void test()
    {
        // Output the start of the method
        System.out.println("\nBegin test of HelloWorld Web Service");
        
        // Get a reference to the interface port
        HelloWorldWSI port = serviceProxy.getHelloWorldWSPort();
       
        // Call the sayHello method from the Web Service interface.
        // Pass "world" as the argument
        String result = port.sayHello("world");
        
        // Output the result
        System.out.println("Result: " + result);
        
        // Assert that the result is the expected outcome
        assertEquals("Hello, world!", result);
        
        // Output the end of the method
        System.out.println("End test of HelloWorld Web Service\n");
    }

}
