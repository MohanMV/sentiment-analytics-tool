/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentimentanalyticstool;

import java.io.IOException;
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
     * Test of removeStopWords method, of class TextManager.
     */
    @Test
    public void testRemovalOfEnglishStopWords() throws IOException {
        
        ArrayList<String> expResult = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        String input="The weather today is so lovely and fine a boy was doing nothing and i feel sad";
        String language="1";
        
        TextManager instance = new TextManager(input,language);       
        instance.sortText();
        instance.removeStopWords();
        
        expResult.add("weather");
        expResult.add("today");
        expResult.add("lovely");
        expResult.add("fine");
        expResult.add("boy");
        expResult.add("doing");
        expResult.add("feel");
        expResult.add("sad");
        
        result = instance.getCompletedWordList();
        assertEquals(expResult,result);   
    }

    /**
     * Test of removeStopWords method, of class TextManager.
     */
    @Test
    public void testRemovalOfFrenchStopWords() throws IOException {
        
        ArrayList<String> expResult = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        String input="Le temps aujourd'hui est si beau et triste";
        String language="2";
        
        TextManager instance = new TextManager(input,language);       
        instance.sortText();
        instance.removeStopWords();
        
        expResult.add("le");
        expResult.add("temps");
        expResult.add("aujourdhui");
        expResult.add("si");
        expResult.add("beau");
        expResult.add("et");
        expResult.add("triste");
        
        result = instance.getCompletedWordList();
        assertEquals(expResult,result);   
    }

    /**
     * Test of sortText method, of class TextManager.
     */
    @Test
    public void testSortText_Numbers() throws IOException {
        ArrayList<String> expResult = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        String input="The w1e3ather t6o56da7y";
        String language="1";
        
        TextManager instance = new TextManager(input,language);       
        instance.sortText();
        expResult.add("the");
        expResult.add("weather");
        expResult.add("today");
        
        result = instance.getSortedWordList();
        assertEquals(expResult,result);
    }

    /**
     * Test of sortText method, of class TextManager.
     */
    @Test
    public void testSortText_Characters() throws IOException {
        ArrayList<String> expResult = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        String input="T*&(7h))e &&w$e^%^at__{{he><?r ~~~~~to{}{}{>><<da*&*(y";
        String language="1";
        
        TextManager instance = new TextManager(input,language);       
        instance.sortText();
        expResult.add("the");
        expResult.add("weather");
        expResult.add("today");
        
        result = instance.getSortedWordList();
        assertEquals(expResult,result);
    }

    /**
     * Test of sortText method, of class TextManager.
     */
    @Test
    public void testSortText_Spaces() throws IOException {
        ArrayList<String> expResult = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        String input="The   weather    today";
        String language="1";
        
        TextManager instance = new TextManager(input,language);       
        instance.sortText();
        expResult.add("the");
        expResult.add("weather");
        expResult.add("today");
        
        result = instance.getSortedWordList();
        assertEquals(expResult,result);
    }
    
}
