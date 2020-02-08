package jmri.jmrix.can.adapters.gridconnect.sproggen5.serialdriver.configurexml;

import jmri.jmrix.can.adapters.gridconnect.sproggen5.serialdriver.PiSprog3ConnectionConfig;
import jmri.util.JUnitUtil;
import org.junit.After;
import org.junit.Before;

/**
 * PiSprog3ConnectionConfigXmlTest.java
 * 
 * Description: tests for the PiSprog3ConnectionConfigXml class
 *
 * @author  Andrew Crosland  Copyright (C) 2020
 */
public class PiSprog3ConnectionConfigXmlTest extends jmri.jmrix.configurexml.AbstractSerialConnectionConfigXmlTestBase {

    // The minimal setup for log4J
    @Before
    @Override
    public void setUp() {
        JUnitUtil.setUp();
        xmlAdapter = new PiSprog3ConnectionConfigXml();
        cc = new PiSprog3ConnectionConfig();
    }

    @After
    @Override
    public void tearDown() {
        JUnitUtil.tearDown();
        xmlAdapter = null;
        cc = null;
    }
}
