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
import java.util.List;

/**
 *
 * @author Mohankumaar MV student-id = 17048038;
 */
public class MyLibraryManager {
    
    private MyLibrary Lib;
    private List<String> stopWordList = new ArrayList<>(); //A list that holds stop-words.
    private List<String> afinnLibrary = new ArrayList<>();
    private LinkedHashMap<String,Integer> myLibrary = new LinkedHashMap<>();
    private ArrayList<String> posKeyWords = new ArrayList<>();
    private ArrayList<String> negKeyWords = new ArrayList<>();
    private float posOccurrences; 
    private float negOccurrences;
    
    public MyLibraryManager() throws IOException{
        
        Lib = new MyLibrary();
        posKeyWords = removeStopWords(Lib.getPosWordlist());
        negKeyWords = removeStopWords(Lib.getNegWordlist());
        
        loadStopWords();
        loadEnAfinnLibrary();
    }
    
    public LinkedHashMap<String,Integer> getLibrary() throws IOException{
        
        int polarityInt;
        
        Outer:
        for(String word : afinnLibrary){
            posOccurrences = 0;
            negOccurrences = 0;
            polarityInt = 0;
            
            for(String pWord : posKeyWords){
                if(!pWord.isEmpty()){
                    if(word.equals(pWord)){
                        posOccurrences++; 
                    }
                }
            }
            
            for(String nWord: negKeyWords){
                if(!nWord.isEmpty()){
                    if(word.equals(nWord)){
                        negOccurrences++;
                    }
                }
            }
            
            if(posOccurrences == 0 && negOccurrences == 0){
                continue Outer;
            }
           
            polarityInt = (int)Math.round(((posOccurrences-negOccurrences)/(posOccurrences+negOccurrences))*5.0);
            myLibrary.put(word,polarityInt);  
        }
        return myLibrary;
    }
    
    private ArrayList removeStopWords(ArrayList<String> wordListWithSWords){
        
        ArrayList<String> stopWords = new ArrayList<>();
        ArrayList<String> wordList = wordListWithSWords;         
        
        for(String word : wordList){
            for(String sWord : stopWordList){
                if(word.equals(sWord)){
                    stopWords.add(sWord);
                }
            }
        }
        
        wordList.removeAll(stopWords);
        
        if( wordList.isEmpty()){
            throw new IllegalArgumentException("Text provided only had stop words.");
        }   
        
        return wordList;
    }

    private void loadStopWords() throws FileNotFoundException, IOException{

        BufferedReader reader = new BufferedReader(new FileReader("src/stopwords/English.txt"));
        String sWord;
        while ((sWord = reader.readLine()) != null) 
        {
            stopWordList.add(sWord);
        }
        reader.close();
    }
    
    /**
     * Read the Afinn English text file into a HashMap.
    */
    private void loadEnAfinnLibrary() throws FileNotFoundException, IOException{
        
        BufferedReader reader = new BufferedReader(new FileReader("src/language_libraries/AFINN-en-165.txt"));
        String line ;
       
        while ((line = reader.readLine()) != null) 
        {
            String[] parts = line.split("	", 2); //split each line into 2 parts separated by whitespace
            if(parts.length == 2){
               
                String key = parts[0].replaceAll("[\\p{P}\\p{S}]" ,""); // part 1 is the words
                afinnLibrary.add(key);//store in hashmap
            }
        }
        reader.close();
    }
}
