/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentimentanalyticstool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Mohankumaar MV student-id = 17048038;
 */
public class UI {
    
    private static Scanner myIn = new Scanner(System.in);
    private LanguageManager Language;
    SentimentClassifier classifier = null;
    LibraryAnalysis libraries = null;
    BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
    int choice;
    float accuracyStats[] = new float[2];
    float afinnAccuracy;
    float mohanAccuracy;
    float noOfNegativeReviewsAfinn;
    float noOfPositiveReviewsAfinn;
    float noOfNegativeReviewsMohan;
    float noOfPositiveReviewsMohan;

    
    /**
     * @
     * @throws java.io.IOException
     */
    public void runUI() throws IOException {
        

       
       try{
           
        System.out.println("Choose English or French / Choisissez l'anglais ou le français: ");
        System.out.println("1. English / Anglaise");
        System.out.println("2. French / Français");
        System.out.println("Enter the number of your choice / Entrez le numéro de votre choix");
        
        String language = reader.readLine();
        Language = new LanguageManager(language);
        
        choice = 100;
        while(choice!=0){
            choice = getOptions();
            
            if(choice == 1){
                
                System.out.println(Language.getEnterTextMessage());
                String text = reader.readLine();
                classifier = new SentimentClassifier(text, language);
                String pol = classifier.analyzeText();
                System.out.println("\n"+Language.getPolarityMessage(pol));
                
            }
            else if(choice == 2){
                if(language.equals("1")){
                    libraries = new LibraryAnalysis(language);
                    System.out.println(libraries.getAfinnEnglishLibrary());
                }
                else if(language.equals("2")){
                    libraries = new LibraryAnalysis(language);
                    System.out.println(libraries.getAfinnFrenchLibrary());
                }
            }
            else if(choice == 3){
                
                libraries = new LibraryAnalysis("3");
                System.out.println(libraries.getMohanLibrary());
            }
            else if(choice == 4){
                libraries = new LibraryAnalysis("4");
                accuracyStats = libraries.getAccuracyStats();
                afinnAccuracy = accuracyStats[0];
                mohanAccuracy = accuracyStats[1];
                noOfNegativeReviewsAfinn = libraries.getNoOfNegativeReviewsAfinn();
                noOfPositiveReviewsAfinn = libraries.getNoOfPositiveReviewsAfinn();
                noOfNegativeReviewsMohan = libraries.getNoOfNegativeReviewsMohan();
                noOfPositiveReviewsMohan = libraries.getNoOfPositiveReviewsMohan();
                
                System.out.println("\n"+Language.getTestSizeMessage(libraries.getTestSize()));
                System.out.println(Language.getAfinnNegativeMovieReviewMessage(noOfNegativeReviewsAfinn));
                System.out.println(Language.getAfinnPositiveMovieReviewMessage(noOfPositiveReviewsAfinn));
                System.out.println(Language.getAfinnAccuracyMessage(afinnAccuracy));
                
                System.out.println("\n"+Language.getTestSizeMessage(libraries.getTestSize()));
                System.out.println(Language.getMohanNegativeMovieReviewMessage(noOfNegativeReviewsMohan));
                System.out.println(Language.getMohanPositiveMovieReviewMessage(noOfPositiveReviewsMohan));
                System.out.println(Language.getMohanAccuracyMessage(mohanAccuracy));
                    
            }
        }

       } catch(IOException e){System.out.println(e);}
       
       System.out.println(Language.getThankYouMessage());    
       
    }
    
    private int getOptions()throws IOException
    {   
        int choice = 100;  
        System.out.println("\n"+ Language.getWelcomeMessage());
        System.out.println("0. "+ Language.getOptionZeroMessage());
        System.out.println("1. "+ Language.getOptionOneMessage());
        System.out.println("2. "+ Language.getOptionTwoMessage());
        System.out.println("3. "+ Language.getOptionThreeMessage()); 
        System.out.println("4. "+ Language.getOptionFourMessage()); 
 
        while (choice < 0 || choice  > 4)
        {
            System.out.println("\n"+ Language.getInputMessage());
            choice =  myIn.nextInt();
        }
        myIn.nextLine();
        return choice;        
    }
    
}
