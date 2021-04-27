/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentimentanalyticstool;

import java.io.IOException;
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
public class SentimentClassifierTest {
    
    public SentimentClassifierTest() {
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
     * Test of analyzeText method, of class SentimentClassifier.
     */
    @Test
    public void testPositiveEnglishInput() throws IOException {
        
        String text = "beautiful happy outstanding fraudulent";
        String language = "1";
        SentimentClassifier instance = new SentimentClassifier(text,language);
        String expResult = "POSITIVE";
        String result = instance.analyzeText();
        assertEquals(expResult, result);        
    }
    
    @Test
    public void testNegativeEnglishInput() throws IOException {
        
        String text = "sad pain die funnier";
        String language = "1";
        SentimentClassifier instance = new SentimentClassifier(text,language);
        String expResult = "NEGATIVE";
        String result = instance.analyzeText();
        assertEquals(expResult, result);
    }
    @Test
    public void testPositiveFrenchInput() throws IOException {
        
        String text = "sensibles exceptionnel opprimés déconnecté";
        String language = "2";
        SentimentClassifier instance = new SentimentClassifier(text,language);
        String expResult = "POSITIVE";
        String result = instance.analyzeText();
        assertEquals(expResult, result);        
    }
    
    @Test
    public void testNegativeFrenchInput() throws IOException {
    
        String text = "inquiet vulnérabilité filsdepute apaisée";
        String language = "2";
        SentimentClassifier instance = new SentimentClassifier(text,language);
        String expResult = "NEGATIVE";
        String result = instance.analyzeText();
        assertEquals(expResult, result);
    }
    
}
