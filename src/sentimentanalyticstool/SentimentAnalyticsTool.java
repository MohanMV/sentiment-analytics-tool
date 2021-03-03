/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentimentanalyticstool;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mohan;
 */
public class SentimentAnalyticsTool {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        TextAnalysis input = new TextAnalysis("Checking to 2152see if it removes51*&^&^&( spaces and add££$$$s every word and char$%%$£acter to a ne)'.;[]1 w line");
        System.out.println(input.toString());
        
    }
    
}
