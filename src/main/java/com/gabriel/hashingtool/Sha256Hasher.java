/*
 * Provides salt + hashcoding of a string field.  Also provides
 * comparison of plaintext with a salted hashcode to determine if there is a match.
 */
package com.gabriel.hashingtool;
import org.apache.commons.codec.digest.Sha2Crypt;
import java.util.regex.*;
/**
 *
 * @author Gabriel
 */
public class Sha256Hasher implements HashingTool {
    /**
     *getHash() uses SHA-256 encryption, length is 63 bytes (including salt).  Salt and encryption provided
     * based on org.apache.commons.codec.digest.Sha2Crypt.
     * @param plaintext to be hashed
     * @return String hash value (includes salt) for safe storage
     */
    @Override
    public String getHash (String plaintext) {
        return Sha2Crypt.sha256Crypt (plaintext.getBytes());
    }
    
    /**
     * isMatch validates plaintext input vs a stored hash (with Salt) String.
     * @param plaintext
     * @param hashAndSalt
     * @return true if authenticated, false if not
     */
    @Override
    public boolean isMatch (String plaintext, String hashAndSalt) {
        if (plaintext.isEmpty() || hashAndSalt.isEmpty()) return false;        
        //sha256Crypt will automatically pull out the salt from the hash argument with
        //hashing plaintext.
        return hashAndSalt.equals(Sha2Crypt.sha256Crypt(plaintext.getBytes(),hashAndSalt));
    }   
    
    
    
}
