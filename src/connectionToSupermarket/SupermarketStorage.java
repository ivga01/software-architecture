package connectionToSupermarket;

import java.io.*;

public class SupermarketStorage {


    public SupermarketStorage(String recievedCustomerData) throws FileNotFoundException {

        PrintWriter pw = new PrintWriter(new File("lib/encryptedCustomerData.csv"));
        pw.write(recievedCustomerData);
        pw.close();

        decryptUserData();

    }


    public void decryptUserData(){

        String encryptedDataFromCSV = "lib/encryptedCustomerData.csv";
        BufferedReader br = null;
        String line = "";

        try{

            br = new BufferedReader(new FileReader(encryptedDataFromCSV));
            while ((line = br.readLine()) != null){

                connectionToSupermarket.EnAndDecoder enAndDecoder = new EnAndDecrypter("key");

                LocalSecretKey localSecretKey = new LocalSecretKey();
                String decryptedString = enAndDecoder.decrypt(line, localSecretKey.getSecretKey());

                PrintWriter pw = new PrintWriter(new File("lib/decryptedCustomerData.csv"));
                pw.write(decryptedString);
                pw.close();

            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
