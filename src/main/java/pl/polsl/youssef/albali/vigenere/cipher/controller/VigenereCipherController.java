/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.youssef.albali.vigenere.cipher.controller;
import pl.polsl.youssef.albali.vigenere.cipher.view.VigenereCipherView;
import pl.polsl.youssef.albali.vigenere.cipher.model.*;





/**
 * Controller class that gets data from the Model class and updates the View
 * @author youssef albali
 * @version 1.0
 */

public class VigenereCipherController {
    /**
     * Model instance used to get  and output data
     */
    private VigenereCipherView vigenereCipherView;
    
    /**
     * Model instance used for encrypting and decrypting
     */
    private VigenereCipherModel vigenereCipherModel;
    /**
     * Prints the tutorial and calls the function to be performed based on the user's choice
     * @param args command line parameters used to display the encryption and decryption examples
     * @throws Exception When the option is invalid or text contains letters outside of the English alphabet
     */
    /**
     * Prints the tutorial and calls the function to be performed based on the user's choice
     * @param args command line parameters used to display the encryption and decryption examples
     * @throws InvalidOptionException When the option is invalid or text contains letters outside of the English alphabet
     * @throws InvalidCharacterException when the text contains letters outside of the English alphabet
     */
    public static void main(String[] args) throws InvalidOptionException , InvalidCharacterException{
        VigenereCipherController vigenereCipherController = new VigenereCipherController();
        vigenereCipherController.vigenereCipherView = new VigenereCipherView();
        vigenereCipherController.vigenereCipherModel = new VigenereCipherModel(args[2]);
        vigenereCipherController.vigenereCipherView.printEncryptionTutorial(args[0], args[2],vigenereCipherController.vigenereCipherModel.getEncryptedMessage(args[0]));
        vigenereCipherController.vigenereCipherView.printDecryptionTutorial(args[1], args[2],vigenereCipherController.vigenereCipherModel.getDecryptedMessage(args[1]));

        while(true){
            try{
                  vigenereCipherController.getOption();
                  break;
            }
            catch(InvalidOptionException | InvalidCharacterException e){
                vigenereCipherController.vigenereCipherView.printError( e.getMessage());
            }  
        }
    }
    /**
     * Gets the user option (Encryption/Decryption)
     * @throws InvalidOptionException When the option is invalid or text contains letters outside of the English alphabet
     * @throws InvalidCharacterException when the text contains letters outside of the English alphabet
     */
    private void getOption()throws InvalidOptionException , InvalidCharacterException{
        String choice = vigenereCipherView.getChoiceFromUser();
        switch (choice) {
            case "1" -> encryptMessage();
            case "2" -> decryptMessage();
            default -> throw new InvalidOptionException("invalid option was chosen: Please chose '1' or '2' options");
        }
    }
    /**
     * Gets inputs(message and keyword) from the view and calls the encryption method of the Model
     * @throws InvalidCharacterException when the message contains letters outside of the English alphabet
     */
    private void encryptMessage() throws InvalidCharacterException {
        String keyword = vigenereCipherView.getKeyFromUser();
        String message = vigenereCipherView.getMessageFromUser();
        vigenereCipherModel = new VigenereCipherModel(keyword);
        vigenereCipherView.outputResult(vigenereCipherModel.getEncryptedMessage(message));
    }
     
   /**
    * Gets inputs(cipher text and keyword) from the view and calls the decryption method of the Model
    * @throws InvalidCharacterException hen the cipher text contains letters outside of the English alphabet
    */
    private void decryptMessage()throws InvalidCharacterException{
        String keyword = vigenereCipherView.getKeyFromUser();
        String cipher = vigenereCipherView.getCipherFromUser();
        vigenereCipherModel = new VigenereCipherModel(keyword);
        vigenereCipherView.outputResult(vigenereCipherModel.getDecryptedMessage(cipher));
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
