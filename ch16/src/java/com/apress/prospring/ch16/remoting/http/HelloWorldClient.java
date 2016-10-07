/*
 * Created on Oct 25, 2004
 */
package com.apress.prospring.ch16.remoting.http;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.apress.prospring.ch16.remoting.HelloWorld;

/**
 * @author robh
 *
 */
public class HelloWorldClient {

	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext(
        "./ch16/src/conf/http/helloWorld.xml");

        HelloWorld helloWorld = (HelloWorld)ctx.getBean("helloWorldService");
        System.out.println(helloWorld.getMessage());
	}
}
