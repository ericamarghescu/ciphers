package erica.cipher;

import com.google.common.base.Preconditions;

/**
 * Cipher class that implements the Caesar cipher using an alphabet string
 */
public class SingleArrayCaesarCipher implements Cipher {
    private String alphabet;
    private int shift;

    public SingleArrayCaesarCipher(int shift) {
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        this.shift = shift;
    }
    @Override
    public String encode(String message) {
        Preconditions.checkNotNull(message, "Null input");
        StringBuilder cipherText = new StringBuilder();
        for(int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            boolean upper = Character.isUpperCase(c);
            int index = alphabet.indexOf(Character.toLowerCase(c));
            // Handle special characters and spaces
            if (index != -1) {
                char ch = alphabet.charAt((index + shift) % alphabet.length());
                // Handle uppercase letters
                if (upper) {
                    cipherText.append(Character.toUpperCase(ch));
                } else {
                    cipherText.append(ch);
                }
            } else {
                cipherText.append(c);
            }
        }
        return cipherText.toString();
    }

    @Override
    public String decode(String encryptedMessage) {
        return null;
    }
}
