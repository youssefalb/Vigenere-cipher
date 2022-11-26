
package pl.polsl.youssef.albali.vigenere.cipher.model;

/**
 * Exception class for objects thrown when the the key is empty
 * @author youssef albali
 * @version 1.0
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
