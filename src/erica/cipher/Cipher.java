package erica.cipher;

/**
 * A cipher interface that encodes and decodes Strings
 */
public interface Cipher {
    /**
     * Encodes a given message and returns the encoded string
     */
    public String encode(String message);

    /**
     * Decodes an encoded string and returns the original message
     */
    public String decode(String encryptedMessage);
}
