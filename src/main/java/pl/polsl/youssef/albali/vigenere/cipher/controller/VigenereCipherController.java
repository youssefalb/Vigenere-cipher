/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.youssef.albali.vigenere.cipher.controller;
import java.util.*;
import java.util.stream.Stream;
import javax.swing.JOptionPane;
import pl.polsl.youssef.albali.vigenere.cipher.view.*;
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
    private VigenereCipherFrame vigenereGui;

    
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
        vigenereCipherController.makeExamples(argsList);
        vigenereCipherController.vigenereGui = new VigenereCipherFrame();
        vigenereCipherController.initController();
        vigenereCipherController.vigenereGui.setVisible(true);
       
    }
    /**
     * 
     */
    public void initController(){
        vigenereGui.getEncryptButton().addActionListener(e->{
            try {
                encryptMessageAfterClick(vigenereGui.getEncryptionKey(),vigenereGui.getCurrentMessage());
                vigenereGui.emptyEncryptionfFields();
            } catch (InvalidCharacterException |EmptyKey ex) {
                  JOptionPane.showMessageDialog(vigenereGui, ex.getMessage(), "Erorr", JOptionPane.WARNING_MESSAGE);
            }
        });
        vigenereGui.getDecryptButton().addActionListener(e->{
            try {
                this.decryptMessageAfterClick(vigenereGui.getDecryptionKey(),vigenereGui.getCurrentCipherText());
                vigenereGui.emptyDecryptionfFields();
            } catch (InvalidCharacterException |EmptyKey ex) {
                  JOptionPane.showMessageDialog(vigenereGui, ex.getMessage(), "Erorr", JOptionPane.WARNING_MESSAGE);
            }
        });
           
    }
    /**
     * Creates the examples and calls the view functions to print the tutorial to the user
     * @param args command line parameters used to display the encryption and decryption examples
     */
     private void makeExamples(List<String> args){
        try{
            this.vigenereCipherModel = new VigenereCipherModel(args.get(2));
            //this.vigenereCipherView.printEncryptionTutorial(args.get(0), args.get(2),this.vigenereCipherModel.getEncryptedMessage(Stream.of(args.get(0))).get(0));
            //this.vigenereCipherView.printDecryptionTutorial(args.get(1), args.get(2),this.vigenereCipherModel.getDecryptedMessage(Stream.of(args.get(1))).get(0));
        }
        
        catch(InvalidCharacterException| EmptyKey e){
              //  this.vigenereCipherView.printError( e.getMessage());
        }  
     }
     


    public void encryptMessageAfterClick(String keyword, String message) throws InvalidCharacterException, EmptyKey{
        vigenereCipherModel = new VigenereCipherModel(keyword);
        Stream<String> messageStream = Stream.of(message.split(" "));
        JOptionPane.showMessageDialog(vigenereGui, "Encryption result: " + String.join(" ",vigenereCipherModel.getEncryptedMessage(messageStream)
        ), "Info", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void decryptMessageAfterClick(String keyword, String cipherText) throws InvalidCharacterException, EmptyKey{
        vigenereCipherModel = new VigenereCipherModel(keyword);
        Stream<String> cipherStream = Stream.of(cipherText.split(" "));
          JOptionPane.showMessageDialog(vigenereGui, "Decryption result: " + String.join(" ",vigenereCipherModel.getDecryptedMessage(cipherStream)
        ), "Info", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
    
