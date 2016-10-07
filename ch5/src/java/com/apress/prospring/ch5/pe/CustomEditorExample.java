/*
 * Created on Aug 6, 2004
 */
package com.apress.prospring.ch5.pe;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

/**
 * @author robh
 */
public class CustomEditorExample {

    private Pattern searchPattern;

    private String textToSearch;

    public static void main(String[] args) {
        ConfigurableListableBeanFactory factory = new XmlBeanFactory(
                new FileSystemResource("./ch5/src/conf/pe/custom.xml"));

        CustomEditorConfigurer config = (CustomEditorConfigurer) factory
                .getBean("customEditorConfigurer");

        config.postProcessBeanFactory(factory);

        CustomEditorExample bean = (CustomEditorExample) factory
                .getBean("exampleBean");

        System.out.println(bean.getMatchCount());
    }

    public void setSearchPattern(Pattern searchPattern) {
        this.searchPattern = searchPattern;
    }

    public void setTextToSearch(String textToSearch) {
        this.textToSearch = textToSearch;
    }

    public int getMatchCount() {
        Matcher m = searchPattern.matcher(textToSearch);

        int count = 0;
        while (m.find()) {
            count++;
        }

        return count;
    }
}