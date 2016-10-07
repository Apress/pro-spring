/*
 * Created on 04-Aug-2004
 */
package com.apress.prospring.ch5.mi;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.util.StopWatch;

/**
 * @author robh
 */
public class LookupDemo {

    public static void main(String[] args) {
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource(
                "./ch5/src/conf/mi/lookup.xml"));

        DemoBean abstractBean = (DemoBean) factory.getBean("abstractLookupBean");
        DemoBean standardBean = (DemoBean) factory.getBean("standardLookupBean");

        displayInfo(standardBean);
        displayInfo(abstractBean);

    }

    public static void displayInfo(DemoBean bean) {
        MyHelper helper1 = bean.getMyHelper();
        MyHelper helper2 = bean.getMyHelper();

        System.out.println("Helper Instances the Same?: "
                + (helper1 == helper2));

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");

        for (int x = 0; x < 100000; x++) {
            MyHelper helper = bean.getMyHelper();
            helper.doSomethingHelpful();
        }

        stopWatch.stop();

        System.out.println("100000 gets took " + stopWatch.getTotalTimeMillis()
                + " ms");

    }
}