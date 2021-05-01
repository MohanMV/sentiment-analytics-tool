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
 * This class is used to handled the String input given by the user. 
 * It removes all numbers and punctuation marks. 
 * Splits words into an string array based on whitespace and changes all letters to lowercase.
 * Remove stop words based on external stop-words list.
 * 
 * @author Mohankumaar MV student-id = 17048038;
 */
public class TextManager {
    
    private String text; //Holds user input 
    private String[] wordList; // An array that holds the words from user input which contains stopwords.
    private String language; // Holds user chosen language
    private ArrayList<String> wordListSorted= new ArrayList<>(); // An array that holds words from the user input after removing punctuation marks and digits. 
    private ArrayList<String> stopWordList = new ArrayList<>();//A list that holds stop-words.
    private ArrayList<String> wordListWithoutStopWords = new ArrayList<>(); // An arraylist that holds the words from user input after removing stopwords 
            
    /**
     * Loads relevant stop words based on language that is chosen by the user
     * @param input User input string
     * @param language
     * @throws IOException if user input is null or empty
     */
    public TextManager(String input, String language) throws IOException{
        
        if(input == null || input.isEmpty()){
            throw new IllegalArgumentException("No text was provided.");// how can i change this if i need to throw error message in another language?
        }
        text = input;
        this.language = language;
        if(this.language.equals("1")){
            loadEngStopWords(); //Reads stop words into a List.
        }
        else if(this.language.equals("2")){
            loadFrStopWords();
        }          
    }
    
    /**
     * Getter method for accessing the  completed word list
     * @return array list of words from user input without any stop words, punctuation marks, symbol, digits and white-spaces. 
     */
    public ArrayList<String> getCompletedWordList(){
        return wordListWithoutStopWords;
    }
    
    /**
     * Getter method for accessing the sorted word list
     * @return array list of words from user input without punctuation marks, symbol, digits and white-spaces. 
    */
    public ArrayList<String> getSortedWordList(){
        return wordListSorted;
    }
    
    /**
     * Getter method for accessing text.
     * @return String of input text
     */
    public String getInput(){
        return text;
    }
    
    /**
     * Getter method for accessing stop words list.
     * @return String of input text
     */
    public List<String> getStopWordList(){
        return stopWordList;
    }
  
    /**
     * Removes all digits and punctuation marks, splits words based on whitespace
     * and changes all letters to lowercase. 
     * Stores sorted list of words in an array.  
     * @throws IllegalArgumentException if array list is empty or null after making changes. 
     */
    public void sortText(){
        //uses regex to replace all digits "d+", punctuations "P" and non-whitespace characters (Symbols) "S" with an empty string
        //split the input based on whitespaces and changes all letters to lowercase
        //throws error if arraylist is empty after sorting. 
        String result = text.replaceAll("[\\d+|\\p{P}+|\\p{S}+]" ,"");
        if(this.language.equals("1")){
            wordList = result.toLowerCase().split(" ");
        }
        else if(this.language.equals("2")){
            wordList = result.toLowerCase(new Locale("fr", "FR")).split(" ");
        }

        for(String word: wordList){
            if(!word.isEmpty()){
                wordListSorted.add(word);
            }
        }
                
        if(wordListSorted == null || wordListSorted.isEmpty()){
            throw new IllegalArgumentException("No proper text to analyse");// how can i change this if i need to throw an error message in another language?
        }
        
    }
         
    /**
     * Removes all stop words from the user input to be analysed later. 
     * @throws IllegalArgumentException if array list is null or empty after removing stop words.
     */
    public void removeStopWords(){
        
        ArrayList<String> stopWords = new ArrayList<>(); 
        for(String word : wordListSorted){
            for(String sWord : stopWordList){
                if(word.equals(sWord)){
                    stopWords.add(sWord);
                }
            }
        }
 
        wordListSorted.removeAll(stopWords);
        wordListWithoutStopWords = new ArrayList<>(wordListSorted);
        
        
        if( wordListWithoutStopWords == null || wordListWithoutStopWords.isEmpty()){
            throw new IllegalArgumentException("Text provided only had stop words.");
        }
    }
    
    /**
     * Read the english stop-words text file into an array list.
     */
    private void loadEngStopWords() throws FileNotFoundException, IOException{
        
        BufferedReader reader = new BufferedReader(new FileReader("src/stopwords/English.txt"));
        String sWord;
        while ((sWord = reader.readLine()) != null) 
        {
            stopWordList.add(sWord);
        }
        reader.close();
    }
    
     /**
     * Read the french stop-words text file into an array list.
     */
    private void loadFrStopWords() throws FileNotFoundException, IOException{
        
        BufferedReader reader = new BufferedReader(new FileReader("src/stopwords/French.txt"));
        String sWord;
        while ((sWord = reader.readLine()) != null) 
        {
            stopWordList.add(sWord);
        }
        reader.close();
    }
        
    
    
//    @Override
//    public String toString(){
//        
//        String output = "";
//        for(String word : wordListWithoutStopWords){
//            output += word + "\n";
//        }
//        return output;
//    }
}
