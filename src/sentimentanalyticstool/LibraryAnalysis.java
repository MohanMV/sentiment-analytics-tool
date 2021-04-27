/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentimentanalyticstool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author mm18adt
 */
public class LibraryAnalysis {
    
    private MyLibraryManager myLibrary = new MyLibraryManager();
    private LinkedHashMap<String,Integer> mohanLibrary = new LinkedHashMap<>();
    private LinkedHashMap<String,Integer> afinnEnglishLibrary = new LinkedHashMap<String, Integer>();
    private LinkedHashMap<String,Integer> afinnFrenchLibrary = new LinkedHashMap<String, Integer>();
    private List<String> stopWordList = new ArrayList<>(); //A list that holds stop-words.
    private final int testSetSize = 6;
    
    public LibraryAnalysis(String language) throws IOException{
        
        if(language.equals("1")){
            loadEnAfinnLibrary();
        } 
        else if(language.equals("2"))
        {
            loadFrAfinnLibrary();  
        }
        else if(language.equals("3")){
            mohanLibrary = myLibrary.getLibrary();
        }
        else if(language.equals("4")){
            loadEnAfinnLibrary();
            mohanLibrary = myLibrary.getLibrary();
            loadStopWords();
        }
        
    }
        
    public float[] getAccuracyStats() throws IOException{
                
        int negativeScores[] = new int[2];
        int positiveScores[] = new int[2];
        float afinnNegative;
        float afinnPositive;
        float mohanNegative;
        float mohanPositive;
        float total[] = new float[2];
        
        negativeScores = getTotalScore_Negative();
        positiveScores = getTotalScore_Positive();
     
        afinnNegative = negativeScores[0];
        afinnPositive = positiveScores[0];
        mohanNegative = negativeScores[1];
        mohanPositive = positiveScores[1];
        
        total[0] = Math.round(((afinnNegative+afinnPositive)/testSetSize)*100.0);
        total[1] = Math.round(((mohanNegative+mohanPositive)/testSetSize)*100.0);
   
        return total;
    }
    
    
    public String getAfinnFrenchLibrary(){
        String output = "";
        for (String key : afinnFrenchLibrary.keySet())
        {
            String value = afinnFrenchLibrary.get(key).toString();
            output += ("\n" +key+":  "+value);
        }
        output += ("\nWords: "+ afinnFrenchLibrary.size());
        return output;        
    }
    
    public String getAfinnEnglishLibrary(){
        String output = "";
        for (String key : afinnEnglishLibrary.keySet())
        {
            String value = afinnEnglishLibrary.get(key).toString();
            output += ("\n" +key+":  "+value);
        }
        output += ("\nWords: "+ afinnEnglishLibrary.size());
        return output;        
    }
    
    public String getMohanLibrary(){
        
        String output = "";
        for (String key : mohanLibrary.keySet())
        {
            String value = mohanLibrary.get(key).toString();
            output += ("\n" +key+":  "+value);
        }
        output += ("\nWords: "+ mohanLibrary.size());
        return output;
    }
    
    public int getTestSize(){
        return testSetSize;
    }
    
    private void loadEnAfinnLibrary() throws FileNotFoundException, IOException{
        
        BufferedReader reader = new BufferedReader(new FileReader("src/language_libraries/AFINN-en-165.txt"));
        String line ;
       
        while ((line = reader.readLine()) != null) 
        {
            String[] parts = line.split("	", 2); //split each line into 2 parts separated by whitespace
            if(parts.length == 2){
               
                String key = parts[0].replaceAll("[\\p{P}\\p{S}]" ,""); // part 1 is the words
                int value = Integer.parseInt(parts[1]); // part 2 is the word score
                afinnEnglishLibrary.put(key,value);//store in hashmap
            }
        }
        reader.close();
    }
    
    private void loadFrAfinnLibrary() throws FileNotFoundException, IOException{
        
        BufferedReader reader = new BufferedReader(new FileReader("src/language_libraries/AFINN-fr-165.txt"));
        String line;
       
        while ((line = reader.readLine()) != null) 
        {
            String[] parts = line.split("	", 2); //split each line into 2 parts separated by whitespace
            
            if(parts.length == 2){
               
                String key = parts[0].replaceAll("[\\s+|\\p{P}\\p{S}]" ,""); // part 1 is the words. replace any symbols or punctuation marks ""
                int value = Integer.parseInt(parts[1]); // part 2 is the word score
                afinnFrenchLibrary.put(key,value);//store in hashmap
            }
        }
        reader.close();
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
    
    public int[] getTotalScore_Negative() throws FileNotFoundException, IOException {
    
        String target_dir = "src/testing_data/neg";
        File dir = new File(target_dir);
        File[] files = dir.listFiles();
        String[] negWordList = null;
        ArrayList<String> stopWords = new ArrayList<>();
        int totalReviewScoreAfinn = 0;
        int totalReviewScoreMohan = 0;
        int[] totalScoreNegative = new int[2];

        for (File f : files) {
            if(f.isFile()) {
                BufferedReader inputStream = null;

                try {
                    inputStream = new BufferedReader(new FileReader(f));
                    String line;

                    while ((line = inputStream.readLine()) != null) {
                        
                        int reviewScore = 0;

                        String result = line.replaceAll("[\\d+|\\p{P}\\p{S}]" ,"");
                        negWordList = result.toLowerCase().split(" ");

                        ArrayList<String> wordList = new ArrayList<>(Arrays.asList(negWordList)); 

                        for(String word : wordList){
                            for(String sWord : stopWordList){
                                if(word.equals(sWord)){
                                    stopWords.add(sWord);
                                }
                            }
                        }
                        
                        wordList.removeAll(stopWords);
                       
                        for(String word: wordList){
                            for (String key : afinnEnglishLibrary.keySet())
                            {
                                if(word.equals(key)){
                                    reviewScore += afinnEnglishLibrary.get(key);
                                }
                            }
                        }

                        if(reviewScore<0){
                            totalReviewScoreAfinn++;
                        }
                        
                        reviewScore = 0;                        
                        for(String word: wordList){
                            for (String key : mohanLibrary.keySet())
                            {
                                if(word.equals(key)){
                                    reviewScore += mohanLibrary.get(key);
                                }
                            }
                        }

                        if(reviewScore<0){
                            totalReviewScoreMohan++;
                        }
                    }
                }
                finally {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            }    
        }
        totalScoreNegative[0] = totalReviewScoreAfinn;
        totalScoreNegative[1] = totalReviewScoreMohan;
        return totalScoreNegative;
    }
    
    public int[] getTotalScore_Positive() throws FileNotFoundException, IOException {
    
        String target_dir = "src/testing_data/pos";
        File dir = new File(target_dir);
        File[] files = dir.listFiles();
        String[] posWordList = null;
        ArrayList<String> stopWords = new ArrayList<>();
        int totalReviewScoreAfinn = 0;
        int totalReviewScoreMohan = 0;
        int[] totalScorePositive = new int[2];

        for (File f : files) {
            if(f.isFile()) {
                BufferedReader inputStream = null;

                try {
                    inputStream = new BufferedReader(new FileReader(f));
                    String line;

                    while ((line = inputStream.readLine()) != null) {
                        
                        int reviewScore = 0;

                        String result = line.replaceAll("[\\d+|\\p{P}\\p{S}]" ,"");
                        posWordList = result.toLowerCase().split(" ");
                        
                        ArrayList<String> wordList = new ArrayList<>(Arrays.asList(posWordList));         

                        for(String word : wordList){
                            for(String sWord : stopWordList){
                                if(word.equals(sWord)){
                                    stopWords.add(sWord);
                                }
                            }
                        }
                        
                        wordList.removeAll(stopWords);         
                        
                        for(String word: wordList){
                            for(String key : afinnEnglishLibrary.keySet())
                            {
                                if(word.equals(key)){ 
                                    reviewScore += afinnEnglishLibrary.get(key);
                                }
                            }
                        }

                        if(reviewScore>0){ 
                            totalReviewScoreAfinn++;
                        }
                        
                        reviewScore = 0;                        
                        for(String word: wordList){
                            for (String key : mohanLibrary.keySet())
                            {
                                if(word.equals(key)){
                                    reviewScore += mohanLibrary.get(key);
                                }
                            }
                        }

                        if(reviewScore>0){
                            totalReviewScoreMohan++;
                        }
                    }
                }
                finally {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            }    
        }
        totalScorePositive[0] = totalReviewScoreAfinn;
        totalScorePositive[1] = totalReviewScoreMohan;
        return totalScorePositive;
    } 
}
