package connectionToSupermarket;

import java.io.*;

/**
 * Mock-up of the setup from the supermarket.
 * This is how their setup could be
 */
public class SupermarketStorage {

    /**
     * Writes the encrypted data to a CSV file
     * @param recievedCustomerData encrypted user data
     * @throws FileNotFoundException if the system can't find the csv file to storage the user data
     */
    public SupermarketStorage(String recievedCustomerData) throws FileNotFoundException {

        PrintWriter pw = new PrintWriter(new File("lib/encryptedCustomerData.csv"));
        pw.write(recievedCustomerData);
        pw.close();

        //Decrypting the data
        decryptUserData();

    }

    /**
     * Decrypts and storage the user data in a new CSV file
     */
    public void decryptUserData(){

        String encryptedDataFromCSV = "lib/encryptedCustomerData.csv";
        BufferedReader br = null;
        String line = "";

        try{

            br = new BufferedReader(new FileReader(encryptedDataFromCSV));
            while ((line = br.readLine()) != null){

                connectionToSupermarket.EnAndDecoder enAndDecoder = new EnAndDecrypter("key");

                //Decrypting the user data
                LocalSecretKey localSecretKey = new LocalSecretKey();
                String decryptedString = enAndDecoder.decrypt(line, localSecretKey.getSecretKey());

                //Puts the decrypted user data in a new CSV file
                PrintWriter pw = new PrintWriter(new File("lib/decryptedCustomerData.csv"));
                pw.write(decryptedString);
                pw.close();

            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
