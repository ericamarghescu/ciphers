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

    private String process(String message, int shift) {
        Preconditions.checkNotNull(message, "Null input");
        StringBuilder text = new StringBuilder();
        for(int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            boolean upper = Character.isUpperCase(c);
            int index = alphabet.indexOf(Character.toLowerCase(c));
            // Handle special characters and spaces
            if (index != -1) {
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
        return process(message, shift);
    }

    @Override
    public String decode(String encryptedMessage) {
        return process(encryptedMessage, (alphabet.length()-shift));
    }
}
