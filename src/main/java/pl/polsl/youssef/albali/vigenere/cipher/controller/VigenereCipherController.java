/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.youssef.albali.vigenere.cipher.controller;
import java.util.*;
import java.util.stream.*;
import pl.polsl.youssef.albali.vigenere.cipher.view.VigenereCipherView;
import pl.polsl.youssef.albali.vigenere.cipher.model.*;





/**
 * Controller class that gets data from the Model class and updates the View
 * @author youssef albali
 * @version 1.0
 */

public class VigenereCipherController {
    /**
     * View instance used to get and output data
     */
    private VigenereCipherView vigenereCipherView;
    
    /**
     * Model instance used for encrypting and decrypting
     */
    private VigenereCipherModel vigenereCipherModel;

    /**
     * Calls a controller function to make the tutorial and also calls the function to be performed based on the user's choice
     * @param args command line parameters used to display the encryption and decryption examples
     */
    public static void main(String[] args) {
        List<String> argsList = Arrays.asList(args);
        VigenereCipherController vigenereCipherController = new VigenereCipherController();
        vigenereCipherController.vigenereCipherView = new VigenereCipherView();
        vigenereCipherController.makeExamples(argsList);

 

        while(true){
            try{
                  vigenereCipherController.getOption();
            }
            catch(InvalidOptionException | InvalidCharacterException | EmptyKey e){
                vigenereCipherController.vigenereCipherView.printError( e.getMessage());
            }  
        }
    }
    
    /**
     * Creates the examples and calls the view functions to print the tutorial to the user
     * @param args command line parameters used to display the encryption and decryption examples
     */
     private void makeExamples(List<String> args){
        try{
            this.vigenereCipherModel = new VigenereCipherModel(args.get(2));
            this.vigenereCipherView.printEncryptionTutorial(args.get(0), args.get(2),this.vigenereCipherModel.getEncryptedMessage(Stream.of(args.get(0))).get(0));
            this.vigenereCipherView.printDecryptionTutorial(args.get(1), args.get(2),this.vigenereCipherModel.getDecryptedMessage(Stream.of(args.get(1))).get(0));
        }
        
        catch(InvalidCharacterException| EmptyKey e){
                this.vigenereCipherView.printError( e.getMessage());
        }  
     }
    
    /**
     * Gets the user option (Encryption/Decryption)
     * @throws InvalidOptionException When the option is invalid or text contains letters outside of the English alphabet
     * @throws InvalidCharacterException when the text contains letters outside of the English alphabet
     */
    private void getOption()throws InvalidOptionException , InvalidCharacterException, EmptyKey{
        String choice = vigenereCipherView.getChoiceFromUser();
        switch (choice) {
            case "1" -> encryptMessage();
            case "2" -> decryptMessage();
            case "3" -> System.exit(0);
            default -> throw new InvalidOptionException("Invalid option was chosen: Please chose '1', '2' or '3' options");
        }
    }
    /**
     * Gets inputs(message and keyword) from the view and calls the encryption method of the Model
     * @throws InvalidCharacterException when the message contains letters outside of the English alphabet
     * @throws EmptyKey when the chosen key is empty
     */
    private void encryptMessage() throws InvalidCharacterException, EmptyKey{
        String keyword = vigenereCipherView.getKeyFromUser();
        String message = vigenereCipherView.getMessageFromUser();
        vigenereCipherModel = new VigenereCipherModel(keyword);
        Stream<String> messageStream = Stream.of(message.split(" "));
        vigenereCipherView.outputResult(vigenereCipherModel.getEncryptedMessage(messageStream));
    }
     
   /**
    * Gets inputs(cipher text and keyword) from the view and calls the decryption method of the Model
    * @throws InvalidCharacterException when the cipher text contains letters outside of the English alphabet
    * @throws EmptyKey when the chosen key is empty
    */
    private void decryptMessage()throws InvalidCharacterException, EmptyKey{
        String keyword = vigenereCipherView.getKeyFromUser();
        String cipher = vigenereCipherView.getCipherFromUser();
        vigenereCipherModel = new VigenereCipherModel(keyword);
        Stream<String> cipherStream = Stream.of(cipher.split(" "));
        vigenereCipherView.outputResult(vigenereCipherModel.getDecryptedMessage(cipherStream));
    }
    
}

/**
 * Exception class for objects thrown when an invalid option is chosen
 * @author youssef albali
 * @version 1.0
 */

class InvalidOptionException extends Exception {
    /**
     * Non-parameter constructor
     */
    public InvalidOptionException() {
    }

    /**
     * Exception class constructor
     *
     * @param message display message
     */
    
    public InvalidOptionException(String message)  {
        super(message);
    }
    
}
