package erica.cipher;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleArrayCaesarCipherTest {

    String message = "the quick brown fox jumps over the lazy dog";
    String capitalMessage = "Hi!";

    @Test
    void encodeOnNormalString() {
        Cipher cipher = new SingleArrayCaesarCipher(5);
        Assertions.assertEquals(cipher.encode(message), "ymj vznhp gwtbs ktc ozrux tajw ymj qfed itl");
    }

    @Test
    void encodeOnNullString() {
        Cipher cipher = new SingleArrayCaesarCipher(5);
        Assertions.assertThrows(NullPointerException.class, () -> {cipher.encode(null);});
    }

    @Test
    void encodeOnEmptyString() {
        Cipher cipher = new SingleArrayCaesarCipher(5);
        Assertions.assertEquals(cipher.encode(""), "");
    }

    @Test
    void encodeOnCapitalLetters() {
        Cipher cipher = new SingleArrayCaesarCipher(5);
        Assertions.assertEquals(cipher.encode(capitalMessage), "Mn!");
    }


}