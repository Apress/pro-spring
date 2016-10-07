/*
 * Created on Jul 26, 2004
 */
package com.apress.prospring.business;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

/**
 * @author robh
 */
public class ObscenityFilterTest extends TestCase {

    public void testReplaceObscenity() {

        ListBasedObscenityFilter filter = new ListBasedObscenityFilter();
        List<String> list = new ArrayList<String>();
        list.add("crap");
        list.add("damn");
        list.add("arse");
        list.add("bugger");

        filter.setObscenities(list);

        String testData = "Crap! Kiss my arse, you damn bugger!";

        assertTrue("Test data should contain obscenities", filter
                .containsObscenities(testData));

        String val = filter.obfuscateObscenities(testData);

        System.out.println(val);

        assertTrue(val.indexOf("arse") == -1);
        assertTrue(val.indexOf("Crap") == -1);
        assertTrue(val.indexOf("damn") == -1);
        assertTrue(val.indexOf("bugger") == -1);
        assertTrue(val.indexOf("Kiss") > -1);
    }
}