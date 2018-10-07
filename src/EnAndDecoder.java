package connectionToSupermarket;

public interface EnAndDecoder {


    public String encrypt(String strToEncrypt, String secret);


    public String decrypt(String strToDecrypt, String secret);


}
