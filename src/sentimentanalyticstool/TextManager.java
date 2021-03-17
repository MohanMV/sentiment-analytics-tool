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
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * sorts text into array, removes stop words
 * @author Mohankumaar MV student-id = 17048038;
 */
public class TextManager {
    
    private String text;
    private String[] wordListWithStopWords;
    private ArrayList<String> wordList = new ArrayList<>();
    private List<String> stopWords = new ArrayList<>();
    private ArrayList<String> wordListWithoutStopWords = new ArrayList<>();
            
    public TextManager(String input) throws IOException{
        if(input == null || input.isEmpty()){
            throw new IllegalArgumentException("No text was provided.");
        }
        text = input;
        try {
            loadStopWords();
        } catch (IOException ex) {
           Logger.getLogger(TextManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sortText(){
        //regex removes numbers and punctuation marks 
        String result = text.replaceAll("[\\d+|\\p{P}\\p{S}]" ,"");
        wordListWithStopWords = result.toLowerCase().split(" ");//split words based on spaces and changes to lowercase for afinn library

        if(wordListWithStopWords == null | wordListWithStopWords.length == 0){
            throw new IllegalArgumentException("No proper text to analyse");// need to work more on this
        } else{
            wordList.addAll(Arrays.asList(wordListWithStopWords));
        }
    }
       
    public void removeStopWords(){
        
        wordListWithoutStopWords.addAll(Arrays.asList(wordListWithStopWords));
        for(String word : wordList){
            for(String sWord : stopWords){
                if(word.equals(sWord)){
                    wordListWithoutStopWords.remove(sWord);
                }
            }
        }
        if( wordListWithoutStopWords == null || wordListWithoutStopWords.isEmpty()){
            throw new IllegalArgumentException("Text provided only had stop words.");
        }
    }
    
    public ArrayList<String> getCompletedWordList(){
        return wordListWithoutStopWords;
    }
    
    private void loadStopWords() throws FileNotFoundException, IOException{
        
        BufferedReader reader = new BufferedReader(new FileReader("src/stopwords/scikitlearn.txt"));
        String sWord;
        while ((sWord = reader.readLine()) != null) 
        {
            stopWords.add(sWord);
        }
        reader.close();
    }
        
    
    
    @Override
    public String toString(){
        
        String output = "";
        for(String word : wordListWithoutStopWords){
            output += word + "\n";
        }
        return output;
    }
}
