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
import java.util.LinkedHashMap;

/**
 * This class is used to Classify the user input.
 * It sorts the user input using methods from the TextManager class.
 *  Analyses the text based on the Afinn Library
 * 
 * @author Mohankumaar MV student-id = 17048038;
 */
public class SentimentClassifier {
    
    private LinkedHashMap<String,Integer> afinnLibrary = new LinkedHashMap<String, Integer>(); // a Hash Map used to hold words and its associated score
    private TextManager input; // TextManager object used to hold the user input
    private String language; // language user has chosen
    private Polarity state; // the Polarity/state of the input
    private ArrayList<String> wordList = new ArrayList<>();
    
    /**
     * Loads either English or French version of the Afinn Library based on the language the user has chosen 
     * @param input User input text
     * @param language User chosen language
     * @throws FileNotFoundException if AfinnLibrary text file not found
     * @throws IOException if user input is corrupted
     */
    public SentimentClassifier(String input, String language) throws FileNotFoundException, IOException {
        
        this.input = new TextManager(input, language); // Initializes textManager object with user input
         //Reads the Afinn Libarary text file into a HashMap based on user chosen language
        if(language.equals("1")){
            
            loadEnAfinnLibrary();
        } else if(language.equals("2")){

            loadFrAfinnLibrary(); 
        }    
    }
       
    /**
     * Analyses the input text and provides the polarity to the user 
     * @return the polarity of the text given 
     */
    public String analyseText(){
       
        input.sortText();
        input.removeStopWords();
        
        wordList = input.getCompletedWordList();
        int score = 0;
        
        for(String word: wordList){
            for (String key : afinnLibrary.keySet())
            {
                if(word.equals(key)){
                    score += afinnLibrary.get(key);
                }
            }
        }
        
        if(score>0){ //if score is more than 0 return name of this enum: Positive
            return Polarity.POSITIVE.name();
        } 
        else if(score<0){// if not more than 0 return Negative
            
            return Polarity.NEGATIVE.name();
        }else{
            return "0";
        }

    }  
    
    /**
     * Read the Afinn English Library  text file into a HashMap.
     */
    private void loadEnAfinnLibrary() throws FileNotFoundException, IOException{
        
        BufferedReader reader = new BufferedReader(new FileReader("src/language_libraries/AFINN-en-165.txt"));
        String line ;
       
        while ((line = reader.readLine()) != null) 
        {
            String[] parts = line.split("	", 2); //split each line into 2 parts separated by whitespace
            if(parts.length == 2){
               
                String key = parts[0].replaceAll("[\\p{P}\\p{S}]" ,""); // part 1 is the words
                int value = Integer.parseInt(parts[1]); // part 2 is the word score
                afinnLibrary.put(key,value);//store in hashmap
            }
        }
        reader.close();
    }
    
    /**
     * Read the Afinn French Library text file into a HashMap.
     */
    private void loadFrAfinnLibrary() throws FileNotFoundException, IOException{
        
        BufferedReader reader = new BufferedReader(new FileReader("src/language_libraries/AFINN-fr-165.txt"));
        String line;
       
        while ((line = reader.readLine()) != null) 
        {
            String[] parts = line.split("	", 2); //split each line into 2 parts separated by whitespace
            
            if(parts.length == 2){
               
                String key = parts[0].replaceAll("[\\s+|\\p{P}+|\\p{S}+]" ,""); // part 1 is the words. replace any symbols or punctuation marks ""
                int value = Integer.parseInt(parts[1]); // part 2 is the word score
                afinnLibrary.put(key,value);//store in hashmap
            }
        }
        reader.close();
    }
    
//    /**
//     *
//     */
//    public void printStopWords(){
//
//
//        for (String word: input.getStopWordList())
//        {
//            System.out.println(word);
//        }   
//    }
//    
//    
//    
//    /**
//     *
//     */
//    public void printWordList(){
//
//
//        for (String word: input.getCompletedWordList())
//        {
//            System.out.println(word);
//        }
//        
//    }
//    
//    public void printLibrary(){
//        for (String key : afinnLibrary.keySet())
//        {
//            System.out.println(key+"\n");
//        }
//    }
//    
//
//        
//    /**
//     *
//     */
//    public void printFullLibrary(){
//
//        for (String key : afinnLibrary.keySet())
//        {
//            String value = afinnLibrary.get(key).toString();
//            System.out.println(key+" "+value + "\n" + afinnLibrary.size() + "\n");
//
//        }
//        
//    }
}
