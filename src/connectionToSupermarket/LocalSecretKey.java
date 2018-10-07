package connectionToSupermarket;

import java.util.Scanner;

public class LocalSecretKey {

    private String secretKey;

public LocalSecretKey(){
    Scanner sc = new Scanner("lib/secretkey.txt");

    while (sc.hasNext()){
        secretKey = sc.nextLine();
    }

}

    public String getSecretKey() {
        return secretKey;
    }
}
