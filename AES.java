import javax.crypto.*;

public class AES {
    public static void main(String[] argv) throws Exception {
        System.out.println("Message Encryption Using AES Algorithm\n-------");

        Cipher cipher = Cipher.getInstance("AES");

        KeyGenerator keygenerator = KeyGenerator.getInstance("AES");
        SecretKey key = keygenerator.generateKey();

        byte[] text = "my message".getBytes();
        System.out.println("Message [Byte Format] : " + text);
        System.out.println("Message : " + new String(text));

        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] textEncrypted = cipher.doFinal(text);
        System.out.println("Encrypted Message: " + textEncrypted);

        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] textDecrypted = cipher.doFinal(textEncrypted);
        System.out.println("Decrypted Message: " + new String(textDecrypted));
    }
}