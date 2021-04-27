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

/**
 *
 * @author Mohankumaar MV student-id = 17048038;
 */
public class MyLibrary {
    
    private ArrayList<String> posWords = new ArrayList<>();
    private ArrayList<String> negWords = new ArrayList<>();
    
    public MyLibrary() throws IOException{
        loadNeg();
        loadPos();
    }
    
    public ArrayList<String> getNegWordlist(){
        return negWords;
    }
    
    public ArrayList<String> getPosWordlist(){
        return posWords;
    }
    
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
                         String result = line.replaceAll("[\\d+|\\p{P}\\p{S}]" ,"");
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
