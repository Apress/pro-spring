/*
 * Created on 20-Sep-2004
 */
package com.apress.prospring.ch13.ejbtest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.CreateException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.apress.prospring.ch13.ejb.CounterService;
import com.apress.prospring.ch13.ejb.CounterServiceHome;
import com.apress.prospring.ch13.ejb.EchoService;

/**
 * @author robh
 */
public class EjbTestServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "/WEB-INF/applicationContext.xml");

        PrintWriter writer = response.getWriter();

        response.setContentType("text/html");

        writer.write("<html><head><title>EJB Samples</title></head>");

        writer.write("<body>");

        writer.write("<h1>Echo Service (Stateless Session Bean)</h1>");

        doStatelessExample(ctx, writer);

        writer.write("<h1>Counter Service (Stateful Session Bean)</h1>");

        doStatefulExample(ctx, writer, request.getSession());

        writer.write("</body></html>");

    }

    private void doStatelessExample(ApplicationContext ctx, PrintWriter writer) {
        // access the EJB proxy
        EchoService service = (EchoService) ctx.getBean("echoService");
        writer.write(service.echo("Foo"));
    }

    private void doStatefulExample(ApplicationContext ctx, PrintWriter writer,
            HttpSession session) {
        CounterService service = (CounterService) session
                .getAttribute("counterService");

        if (service == null) {

            try {
                CounterServiceHome home = (CounterServiceHome) ctx
                        .getBean("counterServiceHome");

                service = (CounterService) home.create();

                session.setAttribute("counterService", service);
            } catch (CreateException ex) {
                ex.printStackTrace(writer);
                return;
            }
        }

        writer.write("Counter: " + service.increment());
    }
}