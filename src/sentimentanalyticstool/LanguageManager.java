/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentimentanalyticstool;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Mohankumaar MV student-id = 17048038;
 */
public class LanguageManager {
    
    private static final String RESOURCE_PATH = "resources/MessageBundle";
    private ResourceBundle strings = null;
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
   
    /**
     *
     * @param language
     */
    public LanguageManager(String language){
        
        if(language.equals("1")){
            strings = ResourceBundle.getBundle(RESOURCE_PATH, new Locale("en", "GB"));
        } else if(language.equals("2")){
            strings = ResourceBundle.getBundle(RESOURCE_PATH, new Locale("fr", "FR"));
        }
    }
    
    
    public String getWelcomeMessage(){
        return strings.getString("welcome_message");
    }
    
    /**
     *
     * @return
     */
    public String getEnterTextMessage(){
        return strings.getString("enter_text");
    }
    
    
    public String getOptionZeroMessage(){
        return strings.getString("option_0");
    }
    
    public String getOptionOneMessage(){
        return strings.getString("option_1");
    }
    
    public String getOptionTwoMessage(){
        return strings.getString("option_2");
    }
    
    public String getOptionThreeMessage(){
        return strings.getString("option_3");
    }
    
    public String getOptionFourMessage(){
        return strings.getString("option_4");
    }
    
    public String getInputMessage(){
        return strings.getString("input_message");
    }
    
    public String getTestSizeMessage(int testSize){
        return println(strings.getString("test_size"), testSize);
    }
    
    public String getAfinnAccuracyMessage(float accuracy){
        return println(strings.getString("afinn_accuracy"),accuracy);
    }
    
    public String getMohanAccuracyMessage(float accuracy){
        return println(strings.getString("mohan_accuracy"),accuracy);
    }
    
    public String getThankYouMessage(){
        return strings.getString("thank_you");
    }
    
    /**
     *
     * @param polarity
     * @return
     */
    public String getPolarityMessage(String polarity){
 
        if(polarity.equals("POSITIVE")){
            return println(strings.getString("positive_message"),ANSI_GREEN, ANSI_RESET);
        }else if(polarity.equals("NEGATIVE")){
            return println(strings.getString("negative_message"),ANSI_RED, ANSI_RESET);
        }
        return "";
    }
    
    public String println(String message, Object...params){
        return (MessageFormat.format(message,params));
    }   
}
