/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentimentanalyticstool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mohankumaar MV student-id = 17048038;
 */
public class UI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        SentimentClassifier bruh = new SentimentClassifier("The world is in chaos. Life is beautiful but the sadness is depressing.");
        
        System.out.println(bruh.analyzeText("English"));
        /// Choose language:
        // Enter text
        // print out sentiment 
 
        
    }
    
}
