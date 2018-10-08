package connectionToSupermarket;

import java.util.Scanner;

/**
 * This class reads the secret key to encrypt and decrypt user information to the supermarket
 */
public class LocalSecretKey {

    private String secretKey;

    /**
     * Load the secret key local from the computer
     */
public LocalSecretKey(){
    Scanner sc = new Scanner("lib/secretkey.txt");

    while (sc.hasNext()){
        secretKey = sc.nextLine();
    }

}

/**
 * Method to get the secret key
 */
    public String getSecretKey() {
        return secretKey;
    }
}
