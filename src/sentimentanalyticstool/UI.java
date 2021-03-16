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
        
        TextManager input = new TextManager(" y£)O ___00000*7&%*^&$%*&^MA22222MA A BI108*&^5G a$$SS ^B1111iT5875765$*4)(*&()*67c&^^h 68897F9089u8c987&^^%k ");
        input.sortText();
        input.removeStopWords();
        ArrayList<String> words = new ArrayList<>();
        words = input.getWordList();
        System.out.println(input.toString());
        /// Choose language:
        // Enter text
        // out sentiment 
 
        
    }
    
}
