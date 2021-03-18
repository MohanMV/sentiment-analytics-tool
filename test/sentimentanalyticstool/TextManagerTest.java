/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentimentanalyticstool;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mohankumaar MV student-id = 17048038;
 */
public class TextManagerTest {
    
    public TextManagerTest() {
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
     * Test of sortText method, of class TextManagerEnglish.
     */
    @Test
    public void testSortText() {
        System.out.println("sortText");
        TextManagerEnglish instance = null;
        instance.sortText();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeStopWords method, of class TextManagerEnglish.
     */
    @Test
    public void testRemoveStopWords() {
        System.out.println("removeStopWords");
        TextManagerEnglish instance = null;
        instance.removeStopWords();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCompletedWordList method, of class TextManagerEnglish.
     */
    @Test
    public void testGetCompletedWordList() {
        System.out.println("getCompletedWordList");
        TextManagerEnglish instance = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getCompletedWordList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
