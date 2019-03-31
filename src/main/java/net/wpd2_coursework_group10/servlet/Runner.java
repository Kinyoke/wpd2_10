
package net.wpd2_coursework_group10.servlet;


import net.wpd2_coursework_group10.database.H2Person;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Runner {
    @SuppressWarnings("unused")
    static final Logger LOG = LoggerFactory.getLogger(Runner.class);

    private static final int PORT = 9000;

    private final H2Person h2Person;

    public Runner() {
        h2Person = new H2Person();
    }

    public void start() throws Exception {
        Server server = new Server(PORT);

        ServletContextHandler handler = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);
        handler.setContextPath("/");
        handler.setInitParameter("org.eclipse.jetty.servlet.Default." + "resourceBase", "src/main/resources/webapp");

        handler.addServlet(new ServletHolder(new PersonServlet(h2Person)), "/index.html");
        handler.addServlet(new ServletHolder(new PersonServlet(h2Person)), "/add"); // we post to here

        DefaultServlet ds = new DefaultServlet();
        handler.addServlet(new ServletHolder(ds), "/");

        server.start();
        LOG.info("Server started, will run until terminated");
        System.out.println("Server started, will run until terminated");
        server.join();
    }

    public static void main(String[] args) {
        try {
            LOG.info("starting dbdemo");
            Runner runner = new Runner();
            runner.start();
        } catch (Exception e) {
            LOG.error("Unexpected error running dbdemo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
