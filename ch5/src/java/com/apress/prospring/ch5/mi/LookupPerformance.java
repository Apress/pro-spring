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
public class LookupPerformance {

    public static void main(String[] args) {

        BeanFactory factory = new XmlBeanFactory(new FileSystemResource(
                "./ch5/src/conf/mi/lookup.xml"));

        DemoBean abstractBean = (DemoBean) factory.getBean("abstractLookupBean");
        DemoBean factoryBean = (DemoBean) factory.getBean("factoryLookupBean");

        testPerf(abstractBean);
        testPerf(factoryBean);
    }

    public static void testPerf(DemoBean bean) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("perfTest");

        for (int x = 0; x < 1000000; x++) {
            MyHelper helper = bean.getMyHelper();
            helper.doSomethingHelpful();
        }

        stopWatch.stop();

        System.out.println("1000000 gets took "
                + stopWatch.getTotalTimeSeconds() + " seconds");
    }
}