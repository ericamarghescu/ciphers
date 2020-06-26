package erica.cipher;

import com.google.common.base.Preconditions;

/**
 * Cipher class that implements the Vigenère Cipher using a single alphabet string
 */
public class VigenereCipher implements Cipher {
    private String keyword;
    private String alphabet;

    public VigenereCipher(String keyword) {
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        this.keyword = keyword;
    }

    private String process(String message, String keyword, boolean flag) {
        Preconditions.checkNotNull(message, "Null input");
        StringBuilder text = new StringBuilder();
        int j = 0;
        for(int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            boolean upper = Character.isUpperCase(c);
            int index = alphabet.indexOf(Character.toLowerCase(c));
            int shift;
            // Handle special characters and spaces
            if (index != -1) {
                // Check if encoding or decoding
                if(flag) {
                    shift = alphabet.length() - alphabet.indexOf(keyword.charAt(j++ % keyword.length()));
                } else {
                    shift = alphabet.indexOf(keyword.charAt(j++ % keyword.length()));
                }
                char ch = alphabet.charAt((index + shift) % alphabet.length());
                // Handle uppercase letters
                if (upper) {
                    text.append(Character.toUpperCase(ch));
                } else {
                    text.append(ch);
                }
            } else {
                text.append(c);
            }
        }
        return text.toString();
    }

    @Override
    public String encode(String message) {
        return process(message, keyword, false);
    }

    @Override
    public String decode(String encryptedMessage) {
        return process(encryptedMessage, keyword, true);
    }
}
