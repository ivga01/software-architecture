package connectionToFoodDB;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FoodDB {

    public FoodDB(){

    }

    public String getFoodItem(String encryptedBarcode){

        String decryptedBarcode = new EnAndDecrypter().decryptBarcode(encryptedBarcode);
        System.out.println("Decrypted barcode: " + decryptedBarcode);

        String foodDBFile = "lib/FoodDB.csv";
        String line = "";
        String CSVSplit = ",";

        try {

            BufferedReader br = new BufferedReader(new FileReader(foodDBFile));

            while ((line = br.readLine()) != null){

                String[] foodItem = line.split(CSVSplit);

                if(decryptedBarcode.equals(foodItem[0])){

                    return foodItem[1];
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Item not found, please scan again";
    }
}
