/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventuregame.board.fields;

import adventuregame.board.Board;
import adventuregame.explorer.Explorer;
import adventuregame.explorer.Explorers;
import adventuregame.explorer.Filozof;
import adventuregame.utils.IDialog;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fake
 */
public class MiastoTest {
    
    public MiastoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of action method, of class Miasto.
     */
    @Test
    public void testAction() {
        System.out.println("action");
        Board board = null;
        Explorers explorers = null;
        Miasto instance = new Miasto();
        instance.action(board, explorers);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateCyrulik method, of class Miasto.
     */
    @Test
    public void testValidateCyrulik() {
        System.out.println("validateCyrulik");
        Explorer explorer = new Filozof();
        Miasto instance = new Miasto();
        boolean expResult = false;
        boolean result = instance.validateCyrulik(explorer);
        assertEquals(expResult, result);
    }

    /**
     * Test of visitCyrulik method, of class Miasto.
     */
    @Test
    public void testVisitCyrulik() {
        System.out.println("visitCyrulik");
        IDialog dialog = null;
        Explorer explorer = null;
        Miasto instance = new Miasto();
        instance.visitCyrulik(dialog, explorer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
