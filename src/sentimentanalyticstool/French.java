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
import java.util.Locale;

/**
 *
 * @author Mohankumaar MV student-id = 17048038;
 */
public class French extends TextManagerEnglish {

    private String[] wordList; // An array that holds the words from user input which contains stopwords. 
    private ArrayList<String> wordListWithStopWords= new ArrayList<>(); // An array that holds words from the user input after removing punctuation marks and digits. 
    private List<String> stopWords = new ArrayList<>(); //A list that holds stop-words.
    private ArrayList<String> wordListWithoutStopWords = new ArrayList<>(); // An arraylist that holds the words from user input after removing stopwords      
    
    /**
     *
     * @param input
     * @throws IOException
     */
    public French(String input) throws IOException{
        super(input);
        loadFrStopWords();
    }
    
    
    @Override
    public void sortText(){
        //uses regex to replace all digits "d+", punctuations "P" and non-whitespace characters (Symbols) "S" with an empty string
        //split the input based on whitespaces and changes all letters to lowercase
        //throws error if arraylist is empty after sorting. 
        String result = getInput().replaceAll("[\\d+|\\p{P}\\p{S}]" ,"");
        wordList = result.toLowerCase(new Locale("fr", "FR")).split(" ");
        wordListWithStopWords.addAll(Arrays.asList(wordList));
        wordListWithoutStopWords.addAll(Arrays.asList(wordList));
                
        if(wordListWithStopWords == null | wordListWithStopWords.isEmpty()){
            throw new IllegalArgumentException("No proper text to analyse");// how can i change this if i need to throw an error message in another language?
        }
        
    }
    
    
    
    @Override
    public ArrayList<String> getCompletedWordList(){
        return wordListWithoutStopWords;
    }
    
    @Override
    public List<String> getStopWordList(){
        return stopWords;
    }
        
    @Override
    public void removeStopWords(){
        
        for(String word : wordListWithStopWords){
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
         
    private void loadFrStopWords() throws FileNotFoundException, IOException{
        
        BufferedReader reader = new BufferedReader(new FileReader("src/stopwords/French.txt"));
        String sWord;
        while ((sWord = reader.readLine()) != null) 
        {
            stopWords.add(sWord);
        }
        reader.close();
    }
}
