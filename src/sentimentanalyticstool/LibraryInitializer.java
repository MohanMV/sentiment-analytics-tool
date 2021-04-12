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

/**
 *
 * @author Mohankumaar MV student-id = 17048038;
 */
public class LibraryInitializer {
    
    private String[] negWordList;
    private String[] posWordList;

    
    public LibraryInitializer() throws IOException{

        
    }
    
    public String[] loadNeg() throws FileNotFoundException, IOException {
    
        String target_dir = "src/training_data/mix20_rand700_tokens_cleaned/tokens/neg";
        File dir = new File(target_dir);
        File[] files = dir.listFiles();


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

        }
        return negWordList;
    }
    
    public String[] loadPos() throws FileNotFoundException, IOException{
        
        String target_dir = "src/training_data/mix20_rand700_tokens_cleaned/tokens/pos";
        File dir = new File(target_dir);
        File[] files = dir.listFiles();
        
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
        }
        return posWordList;
    }
    

    
}
