/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentimentanalyticstool;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mohankumaar MV student-id = 17048038;
 */
public class SentimentClassifier {
    
    private HashMap<String,Integer> afinnLibrary = new HashMap<>();
    private TextManager input;
    private Polarity state;
    
    public SentimentClassifier(String input) throws FileNotFoundException, IOException{

        this.input = new TextManager(input);
        loadAfinnLibrary();
    }
    
    public ArrayList<String> getSortedInput(){
        
        input.sortText();
        input.removeStopWords();
        
        return input.getCompletedWordList();
    }
    
    public String analyze(ArrayList<String> textInput){
        
        int score = 0;
        for(String word: textInput){
            for (String key : afinnLibrary.keySet())
            {
                if(word.equals(key)){
                    score += afinnLibrary.get(key);
                }
            }
        }
        
        if(score>0){
            return Polarity.POSITIVE.name();
        }
        return Polarity.NEGATIVE.name();
    }  
    

    private void loadAfinnLibrary() throws FileNotFoundException, IOException{
        
        BufferedReader reader = new BufferedReader(new FileReader("src/resources/AFINN-en-165.txt"));
        String line ;
       
        while ((line = reader.readLine()) != null) 
        {
            String[] parts = line.split("	", 2);
            
            if(parts.length == 2){
               
                String key = parts[0];
                int value = Integer.parseInt(parts[1]);
                afinnLibrary.put(key,value);
            }
        }
        reader.close();
    }
    
    
    
    
    
    
    public void toStsring(){
        String ss = "";
        for (String key : afinnLibrary.keySet())
        {
            String k = key;
            String value = afinnLibrary.get(key).toString();
            System.out.println(key+" "+value);
        }
        
    }
}
