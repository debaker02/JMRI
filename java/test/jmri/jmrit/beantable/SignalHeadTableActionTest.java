package jmri.jmrit.beantable;

import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import jmri.InstanceManager;
import jmri.NamedBeanHandle;
import jmri.implementation.DoubleTurnoutSignalHead;
import jmri.implementation.QuadOutputSignalHead;
import jmri.implementation.SE8cSignalHead;
import jmri.util.JUnitUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.netbeans.jemmy.operators.JFrameOperator;

/**
 * Tests for the jmri.jmrit.beantable.SignalHeadTableAction class
 *
 * @author	Bob Jacobsen Copyright 2004, 2007, 2008, 2009
 */
public class SignalHeadTableActionTest extends AbstractTableActionBase {

    @Test
    public void testCreate() {
        Assert.assertNotNull(a);
    }

    @Override
    public String getTableFrameName(){
       return Bundle.getMessage("TitleSignalTable");
    }

    @Test
    public void testAddAndInvoke() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // add a few signals and see if they exist
        InstanceManager.getDefault(jmri.SignalHeadManager.class).register(
                new DoubleTurnoutSignalHead("IH2", "double example 1-2",
                        new NamedBeanHandle<>("IT1", InstanceManager.turnoutManagerInstance().provideTurnout("IT1")),
                        new NamedBeanHandle<>("IT2", InstanceManager.turnoutManagerInstance().provideTurnout("IT2"))
                ));
        InstanceManager.getDefault(jmri.SignalHeadManager.class).register(
                new QuadOutputSignalHead("IH4", "quad example 11-14",
                        new NamedBeanHandle<>("IT11", InstanceManager.turnoutManagerInstance().provideTurnout("IT11")),
                        new NamedBeanHandle<>("IT12", InstanceManager.turnoutManagerInstance().provideTurnout("IT12")),
                        new NamedBeanHandle<>("IT13", InstanceManager.turnoutManagerInstance().provideTurnout("IT13")),
                        new NamedBeanHandle<>("IT14", InstanceManager.turnoutManagerInstance().provideTurnout("IT14"))
                ));

        InstanceManager.getDefault(jmri.SignalHeadManager.class).register(
                new SE8cSignalHead(
                        new NamedBeanHandle<>("IT1", InstanceManager.turnoutManagerInstance().provideTurnout("IT21")),
                        new NamedBeanHandle<>("IT2", InstanceManager.turnoutManagerInstance().provideTurnout("IT22")),
                        "SE8c from handles")
        );

        InstanceManager.getDefault(jmri.SignalHeadManager.class).register(
                new SE8cSignalHead(31, "SE8c from number")
        );

        new SignalHeadTableAction().actionPerformed(null);
        JFrame f = JFrameOperator.waitJFrame(Bundle.getMessage("TitleSignalTable"), true, true);
        Assert.assertNotNull("found frame", f);
        JUnitUtil.dispose(f);
    }

    @Override
    @Test
    public void testGetClassDescription(){
         Assert.assertEquals("Signal Head Table Action class description","Signal Head Table",a.getClassDescription());
    }

    /**
     * Check the return value of includeAddButton.  The table generated by 
     * this action includes an Add Button.
     */
    @Override
    @Test
    public void testIncludeAddButton(){
         Assert.assertTrue("Default include add button",a.includeAddButton());
    }

    // The minimal setup for log4J
    @Override
    @Before
    public void setUp() {
        JUnitUtil.setUp();
        JUnitUtil.initDefaultUserMessagePreferences();
        JUnitUtil.initInternalTurnoutManager();
        JUnitUtil.initInternalSignalHeadManager();
        a = new SignalHeadTableAction();
    }

    @Override
    @After
    public void tearDown() {
        a = null;
        JUnitUtil.tearDown();
    }
}
