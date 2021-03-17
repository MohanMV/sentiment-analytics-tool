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
 * @author Mohan;
 */
public class UI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        SentimentClassifier bruh = new SentimentClassifier("This movie was really good. The actor was fucking awful  though");
        ArrayList<String> l = new ArrayList<>(bruh.getSortedInput());
        System.out.println(bruh.analyze(l));
        /// Choose language:
        // Enter text
        // out sentiment 
 
        
    }
    
}
