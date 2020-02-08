package jmri.jmrix.can.adapters.gridconnect.sproggen5.serialdriver;

import jmri.util.JUnitUtil;
import org.junit.After;
import org.junit.Before;

/**
 * Tests for CanisbConnectionConfig class.
 *
 * @author Andrew Crosland (C) 2020
 **/
public class CanisbConnectionConfigTest extends jmri.jmrix.AbstractSerialConnectionConfigTestBase {

   @Before
   @Override
   public void setUp() {
        JUnitUtil.setUp();

        JUnitUtil.initDefaultUserMessagePreferences();
        cc = new CanisbConnectionConfig();
   }

   @After
   @Override
   public void tearDown(){
        cc = null;
        JUnitUtil.tearDown();
   }

}
