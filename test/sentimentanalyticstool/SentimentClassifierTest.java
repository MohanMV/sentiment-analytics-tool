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
    public void testPositiveEnglishInputScore_pos1() throws IOException {
        
        System.out.println("\nTesting positive english input. Total = 1");
        System.out.println("prepared = 1. Total = 1");
        String text = "prepared";
        String language = "1";
        SentimentClassifier instance = new SentimentClassifier(text,language);
        String expResult = "POSITIVE";
        String result = instance.analyzeText();
        assertEquals(expResult, result);
    }
 
    @Test
    public void testPositiveEnglishInputScore_pos2() throws IOException {
        
        System.out.println("\nTesting positive english input. Total = 2");
        System.out.println("poignant = 2. Total = 2");
        String text = "poignant";
        String language = "1";
        SentimentClassifier instance = new SentimentClassifier(text,language);
        String expResult = "POSITIVE";
        String result = instance.analyzeText();
        assertEquals(expResult, result);        
    }
    
    @Test
    public void testPositiveEnglishInputScore_pos10() throws IOException {
        System.out.println("\nTesting positive english input. Total = 10");
        System.out.println("hurrah = 5, breathtaking = 5. Total = 10");
        String text = "breathtaking hurrah";
        String language = "1";
        SentimentClassifier instance = new SentimentClassifier(text,language);
        String expResult = "POSITIVE";
        String result = instance.analyzeText();
        assertEquals(expResult, result);        
    }
    
    @Test
    public void testPositiveEnglishInputScore_pos15() throws IOException {       
        System.out.println("\nTesting positive english input. Total = 15");
        System.out.println("hurrah = 5, breathtaking = 5. Total = 2(hurrah) + breathtaking = 15");
        String text = "hurrah hurrah breathtaking";
        String language = "1";
        SentimentClassifier instance = new SentimentClassifier(text,language);
        String expResult = "POSITIVE";
        String result = instance.analyzeText();
        assertEquals(expResult, result);        
    }
    
    @Test
    public void testPositiveEnglishInputScore_pos21() throws IOException {        
        System.out.println("\nTesting positive english input. Total = 21");
        System.out.println("hurrah = 5, breathtaking = 5, prepared = 1. Total = 3(hurrah) + breathtaking + prepared = 21");
        String text = "hurrah breathtaking hurrah hurrah prepared";
        String language = "1";
        SentimentClassifier instance = new SentimentClassifier(text,language);
        String expResult = "POSITIVE";
        String result = instance.analyzeText();
        assertEquals(expResult, result);        
    }
    
    @Test
    public void testNegativeEnglishInput_neg1() throws IOException {
        System.out.println("\nTesting negative english input. Total = -1");
        System.out.println("moody = -1. Total = -1");
        String text = "moody";
        String language = "1";
        SentimentClassifier instance = new SentimentClassifier(text,language);
        String expResult = "NEGATIVE";
        String result = instance.analyzeText();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testNegativeEnglishInput_neg2() throws IOException {
        System.out.println("\nTesting negative english input. Total = -2");
        System.out.println("moody = -1, monotone = -1. Total = -2");
        String text = "moody monotone";
        String language = "1";
        SentimentClassifier instance = new SentimentClassifier(text,language);
        String expResult = "NEGATIVE";
        String result = instance.analyzeText();
        assertEquals(expResult, result);
    }

    @Test
    public void testNegativeEnglishInput_neg10() throws IOException {
        System.out.println("\nTesting negative english input. Total = -10");
        System.out.println("bastard = -5. Total = 2(bastard) = -10");
        String text = "bastard bastard";
        String language = "1";
        SentimentClassifier instance = new SentimentClassifier(text,language);
        String expResult = "NEGATIVE";
        String result = instance.analyzeText();
        assertEquals(expResult, result);
    }

    @Test
    public void testNegativeEnglishInput_neg15() throws IOException {
        System.out.println("\nTesting negative english input. Total = -15");
        System.out.println("bastard = -5. Total = 3(bastard) = -15");
        String text = "bastard bastard bastard";
        String language = "1";
        SentimentClassifier instance = new SentimentClassifier(text,language);
        String expResult = "NEGATIVE";
        String result = instance.analyzeText();
        assertEquals(expResult, result);
    }

    @Test
    public void testNegativeEnglishInput_neg21() throws IOException {
        System.out.println("\nTesting negative english input. Total = -21");
        System.out.println("bastard = -5, moody = -1. Total = 4(bastard) + (-1) = -21");
        String text = "bastard bastard bastard bastard moody";
        String language = "1";
        SentimentClassifier instance = new SentimentClassifier(text,language);
        String expResult = "NEGATIVE";
        String result = instance.analyzeText();
        assertEquals(expResult, result);
    }   
    
    @Test
    public void testPositiveFrenchInput() throws IOException {
        System.out.println("\nTesting positive french input.");
        System.out.println("sensibles = 2, exceptionnel = 5, inquiet = -3. Total = 4");
        String text = "sensibles exceptionnel inquiet";
        String language = "2";
        SentimentClassifier instance = new SentimentClassifier(text,language);
        String expResult = "POSITIVE";
        String result = instance.analyzeText();
        assertEquals(expResult, result);        
    }
    
    @Test
    public void testNegativeFrenchInput() throws IOException {
        System.out.println("\nTesting negative french input.");
        System.out.println("inquiet = -3, sensibles = 2. Total = -1 ");
        String text = "inquiet sensibles";
        String language = "2";
        SentimentClassifier instance = new SentimentClassifier(text,language);
        String expResult = "NEGATIVE";
        String result = instance.analyzeText();
        assertEquals(expResult, result);
    }
    
}
