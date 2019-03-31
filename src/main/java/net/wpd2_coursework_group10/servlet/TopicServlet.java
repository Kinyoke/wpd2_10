package net.wpd2_coursework_group10.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class TopicServlet implements Servlet {

    private ServletConfig servletConfig = null;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

        this.servletConfig = servletConfig;

        System.out.println("Initializing Servlet...");

    }

    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        servletResponse.setContentType("text/html");

        PrintWriter printWriter = servletResponse.getWriter();

        printWriter.println(
                        "<html>" +
                        "<body>" +
                        "<p> simple servlet application<p>" +
                        "</body>" +
                        "</html>"
        );

    }

    @Override
    public String getServletInfo() {
        return "copyright (C) 2019 by MessageBoard.net";
    }

    @Override
    public void destroy() {
        System.out.println("Terminating servlet process");
    }
}
