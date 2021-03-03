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
public class TextAnalysis {
    
    List<String> list = new ArrayList<String>();
            
    public TextAnalysis(String input){
        Pattern pattern = Pattern.compile("(\\w+)|(\\.{3})|[^\\s]");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            list.add(matcher.group());
        }
    }
    
    @Override
    public String toString(){
        String output = "";
        for(int i=0;i<list.size();i++){
            output += list.get(i) + "\n";
        }
        
        return output;
        
    }
}
