/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentimentanalyticstool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Mohankumaar MV student-id = 17048038;
 */
public class UI {
    

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
       LanguageManager Language;
       SentimentClassifier classifier;
       LibraryInitializer lib = new LibraryInitializer();
       BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
        
       System.out.println("Choose English or French/Choisissez l'anglais ou le français: ");
       String lang = reader.readLine();
       
       String language = lang.toLowerCase();
       Language = new LanguageManager(language);
       
       System.out.println(Language.getWelcomeMessage());
       String text = reader.readLine();
       
       classifier = new SentimentClassifier(text, language);
       String pol = classifier.analyzeText(language);
       classifier.printMyLibrary();
       System.out.println(Language.getPolarityMessage(pol) + "\n");
     
//       classifier.printStopWords();
//       classifier.printLibrary();
//       classifier.printWordList();
       
        
        // Choose language:
        // Enter text
        // print out sentiment 
 
        
    }
    
}
