/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package pl.polsl.youssef.albali.vigenere.cipher.model;
import java.util.*;
import java.util.stream.*;


/**
 * Model class of the application responsible of encrypting and decrypting using Vigenère cipher
 * @author youssef albali
 * @version 1.0
 */
public class VigenereCipherModel {
    /**
     * Keyword that the user chooses for encryption and decryption
     */
    private String key;
    
    /**
     * Model class constructor
     * @param keyword key chosen by the user
     * @throws pl.polsl.youssef.albali.vigenere.cipher.model.InvalidCharacterException when the key contain spaces or invalid characters
     * @throws pl.polsl.youssef.albali.vigenere.cipher.model.EmptyKey When the keyword is empty
     */
    public VigenereCipherModel(String keyword) throws InvalidCharacterException, EmptyKey{
            this.CheckKey(keyword);
    }
    
    /**
     * Interface used for text conversions
     */
    interface ConvertOperation{
        /**
         * the conversion operation
         * @param letter Letter from the text
         * @param keyLetter letter from the keyword
         * @return result
         */
        char convert(char letter, char keyLetter);
    }
    /**
     * 
     * @param text text to be converted
     * @param convertForUppercase The conversion operation for uppercase letters
     * @param convertForLowercase The conversion operation for lowercase letters
     * @return result of conversion
     * @throws InvalidCharacterException When the text contains an invalid character
     */
    String convertText(String text,ConvertOperation convertForUppercase, ConvertOperation convertForLowercase) throws InvalidCharacterException{
        String result = "";
        for (int i = 0, j = 0; i < text.length(); i++){
            char x = text.charAt(i);
            if( x >= 'A' && x <= 'Z')
                result += (char) convertForUppercase.convert(text.charAt(i), key.charAt(j));
            else if( x >= 'a' && x <= 'z')
                result += (char) convertForLowercase.convert(text.charAt(i), key.charAt(j));
            else
                throw new InvalidCharacterException("Invalid charachter: Please chose letters from A-Z and a-z only");
            j = ++j % key.length();
        }
        return result;
    }
    
    /**
     * function that checks the validity of the keyword and assigns it.
     * @param keyword The keyword to verify
     * @throws InvalidCharacterException When the key contains an invalid character
     * @throws EmptyKey When the key is empty
     */
    private void CheckKey(String keyword) throws InvalidCharacterException , EmptyKey{
    keyword = keyword.toUpperCase();
    if(keyword.isEmpty()){
    throw new EmptyKey("invalid keyword: Key is Empty");
    }
    for (int i = 0; i < keyword.length(); i++){
        if( !(keyword.charAt(i) >= 'A' && keyword.charAt(i) <= 'Z')) {
            throw new InvalidCharacterException("invalid keyword: The key should contain only charcters A-Z and a-z and without spaces");            
        } 
    }
            this.key = keyword;
    }
    
    /**
     * Gets a message and encrypts it using Vigenère cipher method
     * @param messageStream Stream of text to be encrypted 
     * @return Encrypted message
     * @throws InvalidCharacterException When message contains a character outside of English letters 
     */
    public List<String> getEncryptedMessage(Stream<String> messageStream)throws InvalidCharacterException{
        ConvertOperation convertForUppercase = (a , b) -> (char) ((a + Character.toUpperCase(b) - 2 * 'A') % 26 + 'A');
        ConvertOperation convertForLowercase = (a , b) -> (char) ((a + Character.toLowerCase(b)- 2 *'a') % 26 + 'a');
        List<String> encryptedMessageList = new ArrayList<>();
        for (String word : (Iterable<String>) messageStream::iterator) {
            encryptedMessageList.add(convertText(word,convertForUppercase, convertForLowercase));
        }
        return encryptedMessageList;
    }

 /**
  * Gets a cipher text and decrypts it using Vigenère cipher method
  * @param cipherTextStream Stream of cipher text to be decrypted
  * @return Original message
  * @throws InvalidCharacterException When cipher text contains a character outside of English letters 
  */
    public List<String> getDecryptedMessage(Stream<String> cipherTextStream) throws InvalidCharacterException{
        ConvertOperation convertForUppercase = (a , b) -> (char) ((a - Character.toUpperCase(b)+ 26) % 26 + 'A');
        ConvertOperation convertForLowercase = (a , b) -> (char) ((a - Character.toLowerCase(b)+ 26) % 26 + 'a');
        List<String> decryptedMessageList = new ArrayList<>();
        for (String word : (Iterable<String>) cipherTextStream::iterator) {
            decryptedMessageList.add(convertText(word,convertForUppercase, convertForLowercase));
        }
        return decryptedMessageList;
    }
}



