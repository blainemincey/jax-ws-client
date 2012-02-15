helloworld-ws: Helloworld Using JAX-WS (Java API for Web Services)
==========================================================================
Author: Blaine Mincey, blaine.mincey@redhat.com 

This example demonstrates the use an external JAX-WS client
which interacts with a JAX-WS Web service that uses *CDI 1.0* and *JAX-WS* 
in *JBoss AS 7*.  Specifically, the test external client "calls" the HelloWorld JAX-WS
Web Service that is created as part of this quickstart.

System requirements
-------------------

The example can be deployed using Maven from the command line or from Eclipse using JBoss Tools.

To set up Maven or JBoss Tools in Eclipse, refer to the 
<a href="https://docs.jboss.org/author/display/AS71/Getting+Started+Developing+Applications+Guide" 
title="Getting Started Developing Applications Guide">Getting Started Developing Applications Guide</a>.

Deploying the application
-------------------------

To deploy to JBoss AS 7 or JBoss Enterprise Application Platform 6, 
start the JBoss application server and type:

    mvn package jboss-as:deploy 

The application is deployed to <http://localhost:8080/jax-ws-client/HelloWorld>, 
so in order to get content you will have to run the external JAX-WS client.

To execute the test, be sure to run the above Maven command to deploy the web
service and then type the following to execute the test profile:

    mvn -P test
    
This will execute the JUnit4 test case.  There will be output on the server console
indicating the web service has been invoked.  Additionally, there will be output from
the Maven terminal console which should be similar to:

    Begin test of HelloWorld Web Service
    Result: Hello, world!
    End test of HelloWorld Web Service

