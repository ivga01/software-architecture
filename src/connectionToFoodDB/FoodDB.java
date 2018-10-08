package connectionToFoodDB;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class which receives the barcode from HybFridge and sends back a encrypted food item to HybFridge
 */
public class FoodDB {

    public FoodDB(){

    }

    /**
     * Class which gets the barcode from HybFridge and returns the food item which equals the barcode
     * @param encryptedBarcode the encrypted barcode from the HybFridge
     * @return the food item (encrypted)
     */
    public String getFoodItem(String encryptedBarcode){

        //Decrypts the barcode and prints out what the encryption is
        String decryptedBarcode = new EnAndDecrypter().decryptBarcode(encryptedBarcode);
        System.out.println("Decrypted barcode: " + decryptedBarcode);

        //The path for the 'database' in the future this should be a real database
        String foodDBFile = "lib/FoodDB.csv";
        String line = "";
        String CSVSplit = ",";

        //Goes through the whole CSV file
        try {

            BufferedReader br = new BufferedReader(new FileReader(foodDBFile));

            while ((line = br.readLine()) != null){

                String[] foodItem = line.split(CSVSplit);

                //If the barcode is in the CSV file, it will encrypt the item and send it back to HybFridge
                if(decryptedBarcode.equals(foodItem[0])){

                    String foodItemEncrypted = new EnAndDecrypter().encrypt(foodItem[1],"nopassword");
                    System.out.println("Food item encrypted: " + foodItemEncrypted);
                    return foodItemEncrypted;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //If the barcode is not in the CSV file, it will give the following message
        return "Item not found, please scan again";
    }
}
