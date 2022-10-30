/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pl.polsl.youssef.albali.vigenere.cipher.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author youssef albali
 */
public class VigenereCipherModelTest {

    /**
     * Test of getEncryptedMessage method, of class VigenereCipherModel.
     */
    @ParameterizedTest
    @CsvSource({"youssef,ifG,gtaaxkn", "Java is Fun,KFC,Tfxk nu Pzp", "PoLsL,hmd,WaOzX"})
    public void testGetEncryptedMessage(String message, String key, String expected) throws Exception {
        System.out.println("getEncryptedMessage");
        VigenereCipherModel instance = new VigenereCipherModel(key);
        String result = instance.getEncryptedMessage(message);
        assertEquals(expected, result);
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDecryptedMessage method, of class VigenereCipherModel.
     */
    
    @ParameterizedTest
    @CsvSource({"gtaaxkn,ifG,youssef", "Tfxk nu Pzp,KFC,Java is Fun", "WaOzX,hmd,PoLsL"})
    public void testGetDecryptedMessage() throws Exception {
        System.out.println("getDecryptedMessage");
        String cipherText = "";
        VigenereCipherModel instance = null;
        String expResult = "";
        String result = instance.getDecryptedMessage(cipherText);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
