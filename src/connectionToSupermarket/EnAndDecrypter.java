package connectionToSupermarket;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * En- and decrypter class that's handling all en- and decryption
 */
public class EnAndDecrypter implements connectionToSupermarket.EnAndDecoder {

    private SecretKeySpec secretKey;
    private byte[] key;

    public EnAndDecrypter(String key){
        setKey(key);
    }

    /**
     * This method encrypts the user data
     * @param strToEncrypt the userdata before encryption
     * @param secret the secret key being used for the encryption
     * @return either an encrypted string or null
     */
    public String encrypt(String strToEncrypt, String secret)
    {
        try
        {
            setKey(secret);
            //Cipher being used
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    /**
     * This method decrypts the user data
     * @param strToDecrypt the userdata before decryption
     * @param secret the secret key being used for the encryption
     * @return either a decrypted string or null
     */
    public String decrypt(String strToDecrypt, String secret)
    {
        try
        {
            setKey(secret);
            //cipher being used
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        }
        catch (Exception e)
        {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }

    /**
     * Making a key to being used for en-and decryption
     * @param myKey key being used for en-and decryption
     */
    public void setKey(String myKey)
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}