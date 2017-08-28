package jmri.jmrix;

import jmri.util.JUnitUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Paul Bender Copyright (C) 2017	
 */
public class AbstractNodeTest {

    @Test
    public void testCTor() {
        AbstractNode t = new AbstractNode(){
           @Override
           protected boolean checkNodeAddress(int address){
              return true;
           }
           @Override
           public AbstractMRMessage createInitPacket(){
              return null;
           }
           @Override
           public AbstractMRMessage createOutPacket(){
              return null;
           }
           @Override
           public boolean getSensorsActive(){
              return true;
           }
           @Override
           public boolean handleTimeout(AbstractMRMessage m, AbstractMRListener l){
              return true;
           }
           @Override
           public void resetTimeout(AbstractMRMessage m){
           }
        };
        Assert.assertNotNull("exists",t);
    }

    // The minimal setup for log4J
    @Before
    public void setUp() {
        JUnitUtil.setUp();
    }

    @After
    public void tearDown() {
        JUnitUtil.tearDown();
    }

    // private final static Logger log = LoggerFactory.getLogger(AbstractNodeTest.class.getName());

}
