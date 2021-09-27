package com.gabriel.hashingtool;

/**
 *
 * @author Gabriel
 */
public interface HashingTool {
    
    //encryptes the plaintext with a hashed version

    /**
     * Returns a String hash of plain text input for safe use in storage.
     * @param plaintext: this is the plain text field you wish to hash
     * @return String hash.
     */
    public String getHash (String plaintext);
    
    //true if plaintext and hash are a valid paired match

    /**
     * isMatch compares plain text input versus a provided hash and either
     * confirms they match (return true) or do not (return false)
     * @param plaintext
     * @param hash
     * @return true for match, false if not.
     */
    public boolean isMatch (String plaintext, String hash);
}
