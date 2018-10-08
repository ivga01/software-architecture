package connectionToSupermarket;

import java.io.FileNotFoundException;

/**
 * This class is the main class for the system.
 * The class sends the users information from HybFridge to our cooperated supermarket
 */
public class UserToSupermarket {

    /**
     * Main method that creates a new userToSupermarket object
     * @throws FileNotFoundException if objects are not created in the following methods
     */
    public static void main(String[] args) throws FileNotFoundException {

        UserToSupermarket userToSupermarket = new UserToSupermarket();

    }

    /**
     * Constructor where user will be constructed before encrypted
     * This is part of the prototype. In the future the customer informations will be send from the user interface
     * @throws FileNotFoundException if encryptToSupermarket is not created and unable to be sent to the encryptAndSendUserdata method
     */
    public UserToSupermarket() throws FileNotFoundException {

        //Test customer
        String customerName = "Anders Andersen";
        String email = "anders@andersen.dk";
        String password = "321drowssaP";
        String creditcardNumber = "4567890123456789";
        String expireDate = "1234";
        String controlNumber = "123";

        //Build a collected string before being sent to encryption
        String encryptToSupermarket = customerName + "," + email + "," + password + "," + creditcardNumber  + "," + expireDate + "," + controlNumber;

        //Shows the full string before encryption
        System.out.println("Customer data before encryption: " + encryptToSupermarket);

        //Customer data being sent to encryption
        encryptAndSendUserData(encryptToSupermarket);

    }

    /**
     * Encryption method of user data
     * @param userDataPlain plain text of user data that needs to be encrypted
     * @throws FileNotFoundException if encryptionString is not uable to be used in creating nre SuperMarketStorage
     */
    public void encryptAndSendUserData(String userDataPlain) throws FileNotFoundException {

        //Secret key to being used to encryption
        LocalSecretKey localSecretKey = new LocalSecretKey();
        connectionToSupermarket.EnAndDecoder enAndDecoder = new EnAndDecrypter("key");

        String encryptedString = enAndDecoder.encrypt(userDataPlain, localSecretKey.getSecretKey());

        //Showing the encrypted customer data
        System.out.println("Customer data after encryption:  " + encryptedString);

        //Sending the customer data to the supermarket
        new SupermarketStorage(encryptedString);

        System.out.println("Customer added");

    }
}
