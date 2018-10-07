package connectionToFoodDB;

public class BarcodeScanner {

    String barcode = null;

    public static void main(String[] args) {
        BarcodeScanner barcodeScanner = new BarcodeScanner("5700426101221");
        barcodeScanner.getItem();
    }

    public BarcodeScanner(String barcode){

        this.barcode = barcode;

    }


    public void getItem(){

        String encryptedBarcode = new EnAndDecrypter().encryptBarcode(barcode);

        System.out.println("Encrypted barcode: " + encryptedBarcode);
        System.out.println("Food item decrypted: " + new EnAndDecrypter().encrypt(new FoodDB().getFoodItem(encryptedBarcode),"nopassword"));

    }




}
