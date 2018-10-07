package connectionToSupermarket;

import java.io.FileNotFoundException;

public class UserToSupermarket {


    public static void main(String[] args) throws FileNotFoundException {

        UserToSupermarket userToSupermarket = new UserToSupermarket();

    }

    public UserToSupermarket() throws FileNotFoundException {

        String customerName = "Anders Andersen";
        String email = "anders@andersen.dk";
        String password = "321drowssaP";
        String creditcardNumber = "4567890123456789";
        String expireDate = "1234";
        String controlNumber = "123";

        String encryptToSupermarket = customerName + "," + email + "," + password + "," + creditcardNumber  + "," + expireDate + "," + controlNumber;

        System.out.println("Customer data before encryption: " + encryptToSupermarket);

        encryptAndSendUserData(encryptToSupermarket);

    }

    public void encryptAndSendUserData(String userDataPlain) throws FileNotFoundException {

        LocalSecretKey localSecretKey = new LocalSecretKey();

        connectionToSupermarket.EnAndDecoder enAndDecoder = new EnAndDecrypter("key");

        String encryptedString = enAndDecoder.encrypt(userDataPlain, localSecretKey.getSecretKey());

        System.out.println("Customer data after encryption:  " + encryptedString);

        new SupermarketStorage(encryptedString);

        System.out.println("Customer added");

    }
}
