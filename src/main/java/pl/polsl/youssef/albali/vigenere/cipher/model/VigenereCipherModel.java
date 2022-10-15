/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package pl.polsl.youssef.albali.vigenere.cipher.model;

/**
 * Model class of the application responsible of encrypting and decrypting using Vigenère cipher
 * @author youssef albali
 * @version 1.0
 */
public class VigenereCipherModel {
    /**
     * Keyword that the user chooses for encryption and decryption
     */
    private final String key;
    
    /**
     * Model class constructor
     * @param keyword key chosen by the user
     * @throws InvalidCharacterException when the key contain spaces or invalid characters
     */
    public VigenereCipherModel(String keyword) throws InvalidCharacterException{
        keyword = keyword.toUpperCase();
        for (int i = 0; i < keyword.length(); i++){
            if( !(keyword.charAt(i) >= 'A' && keyword.charAt(i) <= 'Z')) {
                throw new InvalidCharacterException("invalid keyword: The key should contain only charcters A-Z and a-z and without spaces");            
            } 
        }
        this.key = keyword;
    }
    
    /**
     * Gets a message and encrypts it using Vigenère cipher method
     * @param message Text to be encrypted 
     * @return Encrypted message
     * @throws InvalidCharacterException When message contains a character outside of English letters 
     */
    
    public String getEncryptedMessage(String message)throws InvalidCharacterException{
    String encryptedMessage = "";
    for (int i = 0, j = 0; i < message.length(); i++)
        {
            char x = message.charAt(i);
            
            if (x == ' '){
               encryptedMessage += ' '; 
               continue;
               
            }
            else if( x >= 'A' && x <= 'Z')
                encryptedMessage += (char) ((x + Character.toUpperCase(key.charAt(j)) - 2 * 'A') % 26 + 'A');
            else if( x >= 'a' && x <= 'z')
                encryptedMessage += (char) ((x + Character.toLowerCase(key.charAt(j)) - 2 * 'a') % 26 + 'a');
            else
                throw new InvalidCharacterException("Invalid charachter: Please chose letters from A-Z and a-z only");

            j = ++j % key.length();
        }
    return encryptedMessage;        
    }
    
 /**
  * Gets a cipher text and decrypts it using Vigenère cipher method
  * @param cipherText Text to be decrypted 
  * @return Original message
  * @throws InvalidCharacterException When cipher text contains a character outside of English letters 
  */
    public String getDecryptedMessage(String cipherText) throws InvalidCharacterException{
        String decryptedMessage = "";
        for (int i = 0, j = 0; i < cipherText.length(); i++)
        {
            char x = cipherText.charAt(i);
            if (x == ' '){
               decryptedMessage += ' '; 
            }
            else if( x >= 'A' && x <= 'Z')
                decryptedMessage += (char) ((x - Character.toUpperCase(key.charAt(j))+ 26) % 26 + 'A');
            else if( x >= 'a' && x <= 'z')
                decryptedMessage += (char) ((x - Character.toLowerCase(key.charAt(j)) + 26) % 26 + 'a');
            else
                throw new InvalidCharacterException("Invalid charachter: Please chose letters from A-Z and a-z only");
            j = ++j % key.length();
        }
        return decryptedMessage;
    }
 
}
/**
 * Exception class for objects thrown when the text contains a character outside of English letters 
 * @author youssef albali
 * @version 1.0
 */
class InvalidCharacterException extends Exception {
    /**
     * Non-parameter constructor
     */
    public InvalidCharacterException() {
    }

    /**
     * Exception class constructor
     *
     * @param message display message
     */
    
    public InvalidCharacterException(String message) {
        super(message);
    }
    
}



