/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pl.polsl.youssef.albali.vigenere.cipher.model;

import java.util.*;
import static java.util.Collections.list;
import java.util.stream.Stream;
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
        Stream<String> messageStream = Stream.of(message.split(" "));
        VigenereCipherModel instance = new VigenereCipherModel(key);
        List<String> result = instance.getEncryptedMessage(messageStream);
        String joinedResult = String.join(" ",result );
        assertEquals(expected, joinedResult);
        fail("Encryption Failed");
    }

    /**
     * Test of getDecryptedMessage method, of class VigenereCipherModel.
     */
    
    @ParameterizedTest
    @CsvSource({"gtaaxkn,ifG,youssef", "Tfxk nu Pzp,KFC,Java is Fun", "WaOzX,hmd,PoLsL"})
    public void testGetDecryptedMessage(String cipherText, String key, String expected) throws Exception {
        System.out.println("getDecryptedMessage");
        Stream<String> cipherStream = Stream.of(cipherText.split(" "));
        VigenereCipherModel instance = new VigenereCipherModel(key);
        List<String> result = instance.getDecryptedMessage(cipherStream);
        String joinedResult = String.join(" ",result );
        assertEquals(expected, joinedResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("Decryption Failed");
    }
    
}
