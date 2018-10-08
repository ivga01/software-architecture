package connectionToFoodDB;

/**
 * Main class that connects with the user database to get information of what food item the user have scanned
 */
public class BarcodeScanner {

    String barcode = null;

    /**
     * Fictive barcode from own CSV file that is acting as DB
     */
    public static void main(String[] args) {
        BarcodeScanner barcodeScanner = new BarcodeScanner("5700426101221");
        barcodeScanner.getItem();
    }

    /**
     * Constructor that define the barcode being 'scanned'
     * @param barcode from the product, which the user have scanned
     */
    public BarcodeScanner(String barcode){

        this.barcode = barcode;

    }

    /**
     * Method that encrypts the barcode before being sent to the Food DB and thereafter decrypts the data from the Food DB
     */
    public void getItem(){

        //Decrypting the barcode before sending
        String encryptedBarcode = new EnAndDecrypter().encryptBarcode(barcode);

        System.out.println("Encrypted barcode: " + encryptedBarcode);

        /*
        Getting the data from the food DB and decrypting it before printing.
        In the future this will also go to an central DB
         */
        System.out.println("Food item decrypted: " + new EnAndDecrypter().decrypt(new FoodDB().getFoodItem(encryptedBarcode),"nopassword"));

    }




}
