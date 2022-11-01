/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.youssef.albali.vigenere.cipher.model;

/**
 *
 * @author youssef albali
 */
public class EmptyKey extends Exception{
    /**
     * Non-parameter constructor
     */
    public EmptyKey() {
    }

    /**
     * Exception class constructor
     *
     * @param message display message
     */
    
    public EmptyKey(String message) {
        super(message);
    }
}
