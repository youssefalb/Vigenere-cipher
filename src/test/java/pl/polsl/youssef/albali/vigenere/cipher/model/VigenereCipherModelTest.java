/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pl.polsl.youssef.albali.vigenere.cipher.model;

import java.util.*;
import static java.util.Collections.list;
import java.util.stream.Stream;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Tests the model's methods and possible cases of arguments
 * @author youssef albali
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VigenereCipherModelTest {

    /**
     * Test of getEncryptedMessage method, of class VigenereCipherModel.
     * @param message Message to encrypt
     * @param key Keyword
     * @param expected Expected result of encryption
     */
    @ParameterizedTest
    @Order(1)
    @CsvSource({"youssef,ifG,gtaaxkn", "Java is Fun,KFC,Tfxk nu Pzp", "PoLsL,hmd,WaOzX"})
    public void testGetEncryptedMessage(String message, String key, String expected){
        System.out.println("getEncryptedMessage");
        Stream<String> messageStream = Stream.of(message.split(" "));
        try {
        VigenereCipherModel instance = new VigenereCipherModel(key);
        List<String> result = instance.getEncryptedMessage(messageStream);
        String joinedResult = String.join(" ",result );
        assertEquals(expected, joinedResult);
        fail("The expected encryption is not the same as the returned one");
        }
        catch(InvalidCharacterException | EmptyKey e){
           fail("Test parameters are invalid");     
        }
    }

    /**
     * Test of getDecryptedMessage method, of class VigenereCipherModel.
     * @param cipherText Cipher text to decrypt
     * @param key Keyword
     * @param expected Expected result of decryption
     */
    @ParameterizedTest
    @Order(2)
    @CsvSource({"gtaaxkn,ifG,youssef", "Tfxk nu Pzp,KFC,Java is Fun", "WaOzX,hmd,PoLsL", "non łatin,mykey,"})
    public void testGetDecryptedMessage(String cipherText, String key, String expected){
        System.out.println("getDecryptedMessage");
        Stream<String> cipherStream = Stream.of(cipherText.split(" "));
        try {
        VigenereCipherModel instance = new VigenereCipherModel(key);
        List<String> result = instance.getDecryptedMessage(cipherStream);
        String joinedResult = String.join(" ",result );
        assertEquals(expected, joinedResult);
        fail("The expected decryption is not the same as the returned one");
        }
        catch(InvalidCharacterException | EmptyKey e){
            fail("Test parameters are invalid");     
        }
    }
    
    
    @Test
    @Order(3)
    public void testEncryptionCases(){
        System.out.println("testEncryptionCases");

        try {
            VigenereCipherModel testModel = new VigenereCipherModel("Mykey");
            try {
                testModel.getEncryptedMessage(Stream.of("non łatin alphabet".split(" ")));
                fail("Message should be caught as the message contains non-latin symbols.");
            }
            catch(InvalidCharacterException ex){}            
            try{
                testModel.getEncryptedMessage(Stream.of("My name is Hamif123 ".split(" ")));
                fail("Message should be caught as the message contains numbers.");
            }
            catch(InvalidCharacterException ex2){}
            try {
            testModel.getEncryptedMessage(Stream.of("you &&&%$".split(" ")));
            fail("Message should be caught as the message contains foreign characters."); 
            } 
            catch(InvalidCharacterException ex3){}
            try {
            testModel.getEncryptedMessage(Stream.of("Message IS Legal".split(" ")));
            } 
            catch(InvalidCharacterException ex4){
                fail("Message should not be caught as the message is legal."); 
            }
            
            
        }
        catch (InvalidCharacterException| EmptyKey eMain){
            fail("Message should not be caught as the key is legal");
        }
        
    }
    
    @Test
    @Order(4)
    public void testDecryptionCases(){
        System.out.println("testDecryptionCases");

        try {
            VigenereCipherModel testModel = new VigenereCipherModel("Mykey");
            try {
                testModel.getDecryptedMessage(Stream.of("kaøwa jkl".split(" ")));
                fail("Message should be caught as the cipher text contains non-latin symbols.");
            }
            catch(InvalidCharacterException ex){}
            
            try{
                testModel.getDecryptedMessage(Stream.of("amif123 llabbah".split(" ")));
                fail("Message should be caught as the message contains numbers.");
            }
            catch(InvalidCharacterException ex2){}
            try {
            testModel.getDecryptedMessage(Stream.of("crp &&&%$".split(" ")));
            fail("Message should be caught as the cipher text contains foreign characters."); 
            } 
            catch(InvalidCharacterException ex3){}
            try {
            testModel.getDecryptedMessage(Stream.of("Tfxk nu Pzp".split(" ")));
            } 
            catch(InvalidCharacterException ex4){
                fail("Message should not be caught as the cipher text is legal."); 
            }
            
            
        }
        catch (InvalidCharacterException| EmptyKey eMain){
            fail("Message should not be caught as the key is legal");
        }
        
    }
    
    @Test
    @Order(5)
    public void testKeyCases(){
        System.out.println("testKeyCases");
        try {
        VigenereCipherModel testModel = new VigenereCipherModel("12key");
        fail("Message should be caught as the key contains numbers.");
        }
        catch(InvalidCharacterException | EmptyKey e){}
        try {
        VigenereCipherModel testModel = new VigenereCipherModel("");
        fail("Message should be caught as the key is empty.");
        }
        catch(InvalidCharacterException | EmptyKey e1){
            
        }
        try {
        VigenereCipherModel testModel = new VigenereCipherModel("øey");
        fail("Message should be caught as the key contains non-latin symbols.");
        }
        catch(InvalidCharacterException | EmptyKey e2){}
        try {
        VigenereCipherModel testModel = new VigenereCipherModel("øey larba");
        fail("Message should be caught as the key should not contain spaces.");
        }
        catch(InvalidCharacterException | EmptyKey e3){}
        try {
        VigenereCipherModel testModel = new VigenereCipherModel("myKejK");
        }
        catch(InvalidCharacterException | EmptyKey e4){
            fail("Message should not be caught as the key is legal");
        }
    }
    
}
