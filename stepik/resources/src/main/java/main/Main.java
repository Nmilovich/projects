package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import resourceServer.ResourceServer;
import resourceServer.ResourceServerController;
import resourceServer.ResourceServerControllerMBean;
import resources.TestResource;
import servlets.Servlet;

import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class Main {

    public static void main(String[] args) throws Exception {

        ResourceServer resourceServer = new ResourceServer(new TestResource());

        ResourceServerControllerMBean serverStatistics = new ResourceServerController(resourceServer);
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("Admin:type=ResourceServerController");
        mbs.registerMBean(serverStatistics, name);

        Server server = new Server(8080);
        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);

        contextHandler.addServlet(new ServletHolder(new Servlet(resourceServer)),Servlet.PAGE_URL);

        server.setHandler(contextHandler);

        server.start();
        System.out.println("Server started");
        server.join();


    }
}
