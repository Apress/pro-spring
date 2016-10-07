/*
 * Created on Aug 5, 2004
 */
package com.apress.prospring.ch5.mi;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.util.StopWatch;

/**
 * @author robh
 */
public class MethodReplacementExample {

    public static void main(String[] args) {
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource(
                "./ch5/src/conf/mi/replacement.xml"));

        ReplacementTarget replacementTarget = (ReplacementTarget) factory
                .getBean("replacementTarget");
        ReplacementTarget standardTarget = (ReplacementTarget) factory
                .getBean("standardTarget");

        displayInfo(replacementTarget);
        displayInfo(standardTarget);
    }

    private static void displayInfo(ReplacementTarget target) {
        System.out.println(target.formatMessage("Hello World!"));

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("perfTest");

        for (int x = 0; x < 1000000; x++) {
            String out = target.formatMessage("foo");
        }

        stopWatch.stop();

        System.out.println("1000000 invocations took: "
                + stopWatch.getTotalTimeMillis() + " ms");
    }
}