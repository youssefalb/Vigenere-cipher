/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.youssef.albali.vigenere.cipher.model;

/**
 *
 * @author youssef albali
 */
/**
 * Exception class for objects thrown when the text contains a character outside of English letters 
 * @author youssef albali
 * @version 1.0
 */
public class InvalidCharacterException extends Exception {
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

