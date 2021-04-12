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
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Mohankumaar MV student-id = 17048038;
 */
public class LibraryManager {
    
    private LibraryInitializer Lib;
    private List<String> stopWords = new ArrayList<String>(); //A list that holds stop-words.
    private List<String> afinnLibrary = new ArrayList<String>();
    private LinkedHashMap<String,Integer> myLibrary = new LinkedHashMap<String,Integer>();
    private ArrayList<String> posKeyWords = new ArrayList<String>();
    private ArrayList<String> negKeyWords = new ArrayList<String>();
    private int posOccurences; 
    private int negOccurences;
    
    public LibraryManager() throws IOException{
        Lib = new LibraryInitializer();
        
        loadStopWords();
        loadEnAfinnLibrary();
        posKeyWords = removeStopWords(Lib.loadPos());
        negKeyWords = removeStopWords(Lib.loadNeg());
       
    }
    
    public LinkedHashMap<String,Integer> Library() throws IOException{
        

        int polarityInt;
        System.out.println(posKeyWords.size());
        System.out.println(negKeyWords.size());
        for(String word : afinnLibrary){
            posOccurences = 0;
            negOccurences = 0;
            polarityInt = 0;
            
            for(String pWord : posKeyWords){
                if(!pWord.isEmpty()){
                    if(word.equals(pWord)){
                        posOccurences++; 
                    }
                }
            }
            for(String nWord: negKeyWords){
                if(!nWord.isEmpty()){
                    if(word.equals(nWord)){
                        negOccurences++;
                    }
                }
            }
            System.out.println(word + posOccurences);
            System.out.println(word + negOccurences);
            
            if((posOccurences + negOccurences) == 0){
                polarityInt = 0;
            } else{
                polarityInt = ((posOccurences - negOccurences)/(posOccurences + negOccurences)) * 5;
                myLibrary.put(word,polarityInt);
            }
            
            
        }

        return myLibrary;
    }
    
    private ArrayList removeStopWords(String[] wordListWithStopWords){
        
        ArrayList<String> wordList = new ArrayList<String>(); 
        wordList.addAll(Arrays.asList(wordListWithStopWords));
        
        for(String word : wordListWithStopWords){
            for(String sWord : stopWords){
                if(word.equals(sWord)){
                    wordList.remove(sWord);
                }
            }
        }
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
            stopWords.add(sWord);
        }
        reader.close();
    }
    
    /**
     * Read the Afinn Library English text file into a HashMap.
    */
    private void loadEnAfinnLibrary() throws FileNotFoundException, IOException{
        
        BufferedReader reader = new BufferedReader(new FileReader("src/languages/AFINN-en-165.txt"));
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
