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

/**This class is used to read all reviews in the training dataset into ArrayLists
 *
 * @author Mohankumaar MV student-id = 17048038;
 */
public class TrainingData {
    
    private ArrayList<String> posWords = new ArrayList<>();
    private ArrayList<String> negWords = new ArrayList<>();
    
    /**
     * Executes the loadNeg and loadPos methods which loads the reviews into arraylists
     * @throws IOException
     */
    public TrainingData() throws IOException{
        loadNeg();
        loadPos();
    }
    
    /**
     * A Getter method to retrieve the words from the negative reviews 
     * @return words from the negative reviews after removing stop words and unnecessary characters
     */
    public ArrayList<String> getNegWordlist(){
        return negWords;
    }
    
    /**
     *A Getter method to retrieve the words from the positive reviews
     * @return words from the positive reviews after removing stop words and unnecessary characters
     */
    public ArrayList<String> getPosWordlist(){
        return posWords;
    }
    
    
    /**
     * Reads the words from the negative reviews into the negWords ArrayLists
     * 
     */
    private void loadNeg() throws FileNotFoundException, IOException {
    
        String target_dir = "src/training_data/neg";
        File dir = new File(target_dir);
        File[] files = dir.listFiles();
        String[] negWordList = null;

        for (File f : files) {
            if(f.isFile()) {
                BufferedReader inputStream = null;

                try {
                    inputStream = new BufferedReader(new FileReader(f));
                    String line;
                    

                    while ((line = inputStream.readLine()) != null) {
                         String result = line.replaceAll("[\\d+|\\p{P}+|\\p{S}+]" ,"");
                         negWordList = result.toLowerCase().split(" ");
                    }
                }
                finally {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            }
            negWords.addAll(Arrays.asList(negWordList));
        }
    }
    
    /**
     * Reads the words from the positive reviews into the negWords ArrayLists
     * 
     */
    private void loadPos() throws FileNotFoundException, IOException{
        
        String target_dir = "src/training_data/pos";
        File dir = new File(target_dir);
        File[] files = dir.listFiles();
        String[] posWordList = null;
        
        for (File f: files){
            if(f.isFile()){
                BufferedReader inputStream = null;
                
                try {
                    inputStream = new BufferedReader(new FileReader(f));
                    String line;

                    while ((line = inputStream.readLine()) != null) {
                        String result = line.replaceAll("[\\d+|\\p{P}\\p{S}]" ,"");
                        posWordList = result.toLowerCase().split(" ");   
                    }
                }
                finally {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            }
            posWords.addAll(Arrays.asList(posWordList));
        }
    }
    
}
