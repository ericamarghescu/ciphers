package erica.cipher;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CaesarCipherTest {

    String message = "the quick brown fox jumps over the lazy dog";
    String encryptedMessage = "ymj vznhp gwtbs ktc ozrux tajw ymj qfed itl";
    String capitalMessage = "Hi!";

    @Test
    void encodeOnNormalString() {
        Cipher cipher = new CaesarCipher(5);
        Assertions.assertEquals(cipher.encode(message), encryptedMessage);
    }

    @Test
    void encodeOnNullString() {
        Cipher cipher = new CaesarCipher(5);
        Assertions.assertThrows(NullPointerException.class, () -> {cipher.encode(null);});
    }

    @Test
    void encodeOnEmptyString() {
        Cipher cipher = new CaesarCipher(5);
        Assertions.assertEquals(cipher.encode(""), "");
    }

    @Test
    void encodeOnCapitalLetters() {
        Cipher cipher = new CaesarCipher(5);
        Assertions.assertEquals(cipher.encode(capitalMessage), "Mn!");
    }

    @Test
    void decodeOnNormalString() {
        Cipher cipher = new CaesarCipher(5);
        Assertions.assertEquals(cipher.decode(encryptedMessage), message);
    }

    @Test
    void decodeOnNullString() {
        Cipher cipher = new CaesarCipher(5);
        Assertions.assertThrows(NullPointerException.class, () -> {cipher.decode(null);});
    }

    @Test
    void decodeOnCapitalLetters() {
        Cipher cipher = new CaesarCipher(5);
        Assertions.assertEquals(cipher.decode("Mn!"), capitalMessage);
    }

    @Test
    void decodeOnEmptyString() {
        Cipher cipher = new CaesarCipher(5);
        Assertions.assertEquals(cipher.decode(""), "");
    }


}