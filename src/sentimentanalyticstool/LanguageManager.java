/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentimentanalyticstool;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Mohankumaar MV student-id = 17048038;
 */
public class LanguageManager {
    
    private static final String RESOURCE_PATH = "resources/MessageBundle";
    private ResourceBundle strings = null;
   
    /**
     *
     * @param language
     */
    public LanguageManager(String language){
        
        if(language.equals("english") || language.equals("anglaise")){
            strings = ResourceBundle.getBundle(RESOURCE_PATH, new Locale("en", "GB"));
        } else if(language.equals("french") || language.equals("français")){
            strings = ResourceBundle.getBundle(RESOURCE_PATH, new Locale("fr", "FR"));
        }
    }
    
    /**
     *
     * @return
     */
    public String getWelcomeMessage(){
        return strings.getString("welcome_message");
    }
    
    /**
     *
     * @param polarity
     * @return
     */
    public String getPolarityMessage(String polarity){
 
        if(polarity.equals("POSITIVE")){
            return strings.getString("positive_message");
        }else if(polarity.equals("NEGATIVE")){
            return strings.getString("negative_message");
        }
        return "";
    }
    
}
