/*
 * Created on 20-Sep-2004
 */
package com.apress.prospring.ch13.jndi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author robh
 */
public class JndiDemoServlet extends HttpServlet {

    public static final String JNDI_NAME = "java:comp/env/message";

    private ApplicationContext ctx;

    public void init() throws ServletException {
        ctx = new ClassPathXmlApplicationContext(
                "/WEB-INF/applicationContext.xml");
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        PrintWriter writer = response.getWriter();

        writeWithBean("messageWriterTraditional", writer);
        writeWithBean("messageWriterTemplate", writer);
        writeWithBean("messageWriterFactoryBean", writer);
    }

    private void writeWithBean(String beanName, PrintWriter writer) {
        MessageResolver traditional = (MessageResolver) ctx.getBean(beanName);
        writer.write(traditional.getMessage());
        writer.write("\n");
    }
}