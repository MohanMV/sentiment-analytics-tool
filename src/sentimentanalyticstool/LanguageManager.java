/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentimentanalyticstool;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/** Handles Internationalisation 
 *
 * @author Mohankumaar MV student-id = 17048038;
 */
public class LanguageManager {
    
    private static final String RESOURCE_PATH = "resources/MessageBundle";
    private ResourceBundle strings = null;

    /**
     * Colour red in ANSI escape code
     */
    public static final String ANSI_RED = "\u001B[31m";

    /**
     * Reset text colour
     */
    public static final String ANSI_RESET = "\u001B[0m";

    /**
     * Colour green in ANSI escape code
     */
    public static final String ANSI_GREEN = "\u001B[32m";
   
    /**
     * Loads the locale setting based on the language chosen by the user
     * @param language
     */
    public LanguageManager(String language){
        
        if(language.equals("1")){
            strings = ResourceBundle.getBundle(RESOURCE_PATH, new Locale("en", "GB"));
        } else if(language.equals("2")){
            strings = ResourceBundle.getBundle(RESOURCE_PATH, new Locale("fr", "FR"));
        }
    }
    
    /**
     * Retrieve welcome message from resource bundle 
     * @return welcome status message 
     */
    public String getWelcomeMessage(){
        return strings.getString("welcome_message");
    }
    
    /**
     *Retrieve Enter Text message from resource bundle 
     * @return Enter Text message
     */
    public String getEnterTextMessage(){
        return strings.getString("enter_text");
    }
    
    /**
     * Retrieve option zero message from resource bundle 
     * @return option zero message
     */
    public String getOptionZeroMessage(){
        return strings.getString("option_0");
    }
    
    /**
     * Retrieve option one message from resource bundle 
     * @return option one message
     */
    public String getOptionOneMessage(){
        return strings.getString("option_1");
    }
    
    /**
     * Retrieve option two message from resource bundle 
     * @return option two message
     */
    public String getOptionTwoMessage(){
        return strings.getString("option_2");
    }
    
    /**
     * Retrieve option three message from resource bundle 
     * @return  option three message
     */
    public String getOptionThreeMessage(){
        return strings.getString("option_3");
    }
    
    /**
     * Retrieve option four message from resource bundle 
     * @return option four message
     */
    public String getOptionFourMessage(){
        return strings.getString("option_4");
    }
    
    /**
     * Retrieve input message from resource bundle 
     * @return input message
     */
    public String getInputMessage(){
        return strings.getString("input_message");
    }
    
    /**
     * Retrieve test size message from resource bundle
     * @param testSize number of reviews in the testing dataset
     * @return number of reviews in testing dataset
     */
    public String getTestSizeMessage(int testSize){
        return println(strings.getString("test_size"), testSize);
    }
    
    /**
     * Retrieve accuracy message for Afinn's Library
     * @param accuracy percentage of correctly classified reviews 
     * @return accuracy message for Afinn's Library
     */
    public String getAfinnAccuracyMessage(float accuracy){
        return println(strings.getString("afinn_accuracy"),accuracy);
    }
    
    /**
     * Retrieve accuracy message for Mohan's Library
     * @param accuracy percentage of correctly classified reviews 
     * @return accuracy message for Mohan's Library
     */
    public String getMohanAccuracyMessage(float accuracy){
        return println(strings.getString("mohan_accuracy"),accuracy);
    }
    
    /**
     *  Retrieve message for number of correctly classified negative movie reviews for the Afinn English Library 
     * @param noOfReviews number of correctly classified negative movie reviews
     * @return message for number of correctly classified negative movie reviews for the Afinn English Library
     */
    public String getAfinnNegativeMovieReviewMessage(float noOfReviews){
        return println(strings.getString("afinn_negative_reviews"),noOfReviews);
    }
    
    /**
     * Retrieve message for number of correctly classified Positive movie reviews for the Afinn English Library
     * @param noOfReviews number of correctly classified positive movie reviews
     * @return message for number of correctly classified Positive movie reviews for the Afinn English Library
     */
    public String getAfinnPositiveMovieReviewMessage(float noOfReviews){
        return println(strings.getString("afinn_positive_reviews"),noOfReviews);
    }
    
    /**
     * Retrieve message for number of correctly classified negative movie reviews for the Mohan's Library
     * @param noOfReviews number of correctly classified negative movie reviews
     * @return message for number of correctly classified negative movie reviews for the Mohan's Library
     */
    public String getMohanNegativeMovieReviewMessage(float noOfReviews){
        return println(strings.getString("mohan_negative_reviews"),noOfReviews);
    }

    /**
     * Retrieve message for number of correctly classified positive movie reviews for the Mohan's Library
     * @param noOfReviews  number of correctly classified positive movie reviews
     * @return message for number of correctly classified positive movie reviews for the Mohan's Library
     */
    public String getMohanPositiveMovieReviewMessage(float noOfReviews){
        return println(strings.getString("mohan_positive_reviews"),noOfReviews);
    }
    
    /**
     * Retrieve thank you message
     * @return thank you
     */
    public String getThankYouMessage(){
        return strings.getString("thank_you");
    }
    
    /**
     * Retrieve the polarity 
     * @param polarity Positive or negative or 0
     * @return Positive or negative or no sentiment
     */
    public String getPolarityMessage(String polarity){
 
        if(polarity.equals("POSITIVE")){
            return println(strings.getString("positive_message"),ANSI_GREEN, ANSI_RESET);
        }else if(polarity.equals("NEGATIVE")){
            return println(strings.getString("negative_message"),ANSI_RED, ANSI_RESET);
        }else{
            return strings.getString("no_sentiment_message");
        }
        
    }
    
    private String println(String message, Object...params){
        return (MessageFormat.format(message,params));
    }   
}
