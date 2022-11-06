/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.youssef.albali.vigenere.cipher.view;
import java.util.*;  
import java.util.stream.Stream;


/**
 * View class responsible of interacting with the user (Gets inputs and outputs results to the console)
 * @author youssef albali
 * @version 1.0
 */
public class VigenereCipherView {
    /**
     * Used to obtain inputs from user
     */
    private Scanner sc;
    
    
    /**
     * Gets the choice from the user (Encryption or decryption)
     * @return user's choice
     */
    public String getChoiceFromUser() {
        sc= new Scanner(System.in); 
        System.out.println("Enter your choice (without spaces): ");
        System.out.println("1 : Encrypt ");
        System.out.println("2 : Decrypt ");
        System.out.println("3 : Quit ");

        String choice = sc.nextLine();
        return choice;
    }
    
    /**
     * Outputs results of the operation to console
     * @param resultList
     */
    public void outputResult(List<String> resultList){
        Stream<String> resultStream = resultList.stream(); 
        resultStream.forEach(word -> System.out.print(word + " "));
        System.out.println(); 
    }
    
    /**
     * Prints an error to the console
     * @param error display message
     */
    public void printError(String error){
        System.err.println(error);
    }
   

    
    /**
     * Gets chosen message to be encrypted from the user
     * @return message to be encrypted
     */
    public String getMessageFromUser() {
        sc= new Scanner(System.in); 
        System.out.print("Enter the string: ");
        String message = sc.nextLine();
        return message;
    }
    
     /**
     * Gets Chosen text to be decrypted from the user
     * @return cipher text to be decrypted
     */
    public  String getCipherFromUser() {
        sc= new Scanner(System.in); 
        System.out.print("Enter the cipher code: ");
        String cipher = sc.nextLine();
        return cipher;
    }    
    
    /**
     * Gets the keyword of the Encryption/Decryption
     * @return keyword chosen
     */
    public  String getKeyFromUser() {
        sc= new Scanner(System.in); 
        System.out.print("Enter the Key: ");
        String key = sc.nextLine();
        return key;
    }
    /**
     * Prints an encryption example
     * @param text message to be encrypted
     * @param key encryption key
     * @param encryptedMessage result of encryption
     */
    public void printEncryptionTutorial(String text ,String key , String encryptedMessage){
        System.out.println("Encryption example:");
        System.out.println("Message: " + text);
        System.out.println("Keyword: " + key);
        System.out.println("Result of Encryption: " + encryptedMessage);
    }
    
    /**
     * Prints a decryption example
     * @param ciphertext cipher text to be decrypted 
     * @param key decryption key
     * @param decryptedMessage result of decryption
     */
    public void printDecryptionTutorial(String ciphertext ,String key ,String decryptedMessage){
        System.out.println("------------------------------------------------");
        System.out.println("Decryption example:");
        System.out.println("Cipher text: " + ciphertext);
        System.out.println("Keyword: " + key);
        System.out.println("Result of Decryption: " + decryptedMessage);
        System.out.println("------------------------------------------------");
    }

}
