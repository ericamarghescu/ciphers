package erica.cipher;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VigenereCipherTest {

    String message = "attack at dawn";
    String encryptedMessage = "lxfopv ef rnhr";
    String keyword = "lemon";
    String capitalMessage = "ATTACK AT DAWN";
    String encryptedCapitalMessage = "LXFOPV EF RNHR";

    @Test
    void encodeOnNormalString() {
        Cipher cipher = new VigenereCipher(keyword);
        Assertions.assertEquals(cipher.encode(message), encryptedMessage);
    }

    @Test
    void encodeOnNullString() {
        Cipher cipher = new VigenereCipher(keyword);
        Assertions.assertThrows(NullPointerException.class, () -> {cipher.encode(null);});
    }

    @Test
    void encodeOnEmptyString() {
        Cipher cipher = new VigenereCipher(keyword);
        Assertions.assertEquals(cipher.encode(""), "");
    }

    @Test
    void encodeOnCapitalLetters() {
        Cipher cipher = new VigenereCipher(keyword);
        Assertions.assertEquals(cipher.encode(capitalMessage), encryptedCapitalMessage);
    }

    @Test
    void decodeOnNormalString() {
        Cipher cipher = new VigenereCipher(keyword);
        Assertions.assertEquals(cipher.decode(encryptedMessage), message);
    }

    @Test
    void decodeOnNullString() {
        Cipher cipher = new VigenereCipher(keyword);
        Assertions.assertThrows(NullPointerException.class, () -> {cipher.decode(null);});
    }

    @Test
    void decodeOnEmptyString() {
        Cipher cipher = new VigenereCipher(keyword);
        Assertions.assertEquals(cipher.decode(""), "");
    }

    @Test
    void decodeOnCapitalLetters() {
        Cipher cipher = new VigenereCipher(keyword);
        Assertions.assertEquals(cipher.decode(encryptedCapitalMessage), capitalMessage);
    }
}