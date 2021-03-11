/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentimentanalyticstool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Mohankumaar MV student-id = 17048038;
 */
public class TextManager {
    
    String text;
    String[] wordsList;
            
    public TextManager(String input){
        if(input == null || input.isEmpty()){
            throw new IllegalArgumentException("No text was provided.");
        }
        text = input;
    }
    
    private void sortText(){
        //regex removes numbers and punctuation marks 
        String result = text.replaceAll("[\\d+|\\p{P}\\p{S}]" ,"");
        wordsList = result.toLowerCase().split(" ");//split words based on spaces and changes to lowercase for afinn library
        if(wordsList == null | wordsList.length == 0){
            throw new IllegalArgumentException("Text is not descriptive enough");
        }
    }

    @Override
    public String toString(){
        sortText();
        String output = "";
        for(String word : wordsList){
            output += word + "\n";
        }
        return output;
    }
}
