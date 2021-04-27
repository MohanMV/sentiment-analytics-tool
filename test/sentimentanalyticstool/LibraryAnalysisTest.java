/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentimentanalyticstool;

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
public class LibraryAnalysisTest {
    
    public LibraryAnalysisTest() {
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
     * Test of getAccuracyStats method, of class LibraryAnalysis.
     */
    @Test
    public void testGetAccuracyStats() throws Exception {
        System.out.println("Testing getAccuracyStats method");
        LibraryAnalysis instance = new LibraryAnalysis("4");
        float[] expResult = {50, 50};
        float[] result = instance.getAccuracyStats();
        assertArrayEquals(expResult, result, 0.0f);

    }

    /**
     * Test of getTotalScore_Negative method, of class LibraryAnalysis.
     */
    @Test
    public void testGetTotalScore_Negative() throws Exception {
        System.out.println("Testing getTotalScore_Negative method");
        LibraryAnalysis instance = new LibraryAnalysis("4");
        int[] expResult = {2,1};
        int[] result = instance.getTotalScore_Negative();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of getTotalScore_Positive method, of class LibraryAnalysis.
     */
    @Test
    public void testGetTotalScore_Positive() throws Exception {
        System.out.println("Testing getTotalScore_Positive method");
        LibraryAnalysis instance = new LibraryAnalysis("4");
        int[] expResult = {1,2};
        int[] result = instance.getTotalScore_Positive();
        assertArrayEquals(expResult, result);

    }
    
}
