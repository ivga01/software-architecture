package connectionToFoodDB;


import connectionToSupermarket.EnAndDecoder;

/**
 * Class that handles the en and decryptions for the connection of the Food DB
 */
public class EnAndDecrypter implements EnAndDecoder{

    /**
     * Encrypter that encrypts the food item
     * @param strToEncrypt the food item that needs to be encrypted
     * @param secret is if the customer wishes a password in the future
     * @return encrypted food item
     */
    @Override
    public String encrypt(String strToEncrypt, String secret) {

        return rot20(strToEncrypt);
    }

    /**
     * Decrypter that encrypts the food item
     * @param strToDecrypt the food item that needs to be decrypted
     * @param secret is if the customer wishes a password in the future
     * @return decrypted food item
     */
    @Override
    public String decrypt(String strToDecrypt, String secret) {

        return rot20(strToDecrypt);
    }

    /**
     * A rot20 method, that rotate the letters to make a soft en- decryption
     * @param rotText the food item that needs a rotation of the letters
     * @return the rotated text
     */
    public String rot20(String rotText){

        StringBuffer result = new StringBuffer();

        for (int i=0; i<rotText.length(); i++)
        {
            if (Character.isUpperCase(rotText.charAt(i)))
            {
                char ch = (char)(((int)rotText.charAt(i) +
                        13 - 65) % 26 + 65);
                result.append(ch);
            }
            else
            {
                char ch = (char)(((int)rotText.charAt(i) +
                        13 - 97) % 26 + 97);
                result.append(ch);
            }
        }

        return result.toString();
    }

    /**
     * This method encrypts the barcode
     * @param barcode barcode that needs to be encrypted
     * @return encrypted barcode
     */
    public String encryptBarcode(String barcode){

        barcode = barcode.replace("0","e");
        barcode = barcode.replace("1","m");
        barcode = barcode.replace("2","c");
        barcode = barcode.replace("3","a");
        barcode = barcode.replace("4","r");
        barcode = barcode.replace("5","t");
        barcode = barcode.replace("6","b");
        barcode = barcode.replace("7","n");
        barcode = barcode.replace("8","d");
        barcode = barcode.replace("9","q");

        return barcode;
    }

    /**
     * This method decrypts the barcode
     * @param barcode barcode that needs to be decrypted
     * @return decrypted barcode
     */
    public String decryptBarcode(String barcode){

        barcode = barcode.replace("e","0");
        barcode = barcode.replace("m","1");
        barcode = barcode.replace("c","2");
        barcode = barcode.replace("a","3");
        barcode = barcode.replace("r","4");
        barcode = barcode.replace("t","5");
        barcode = barcode.replace("b","6");
        barcode = barcode.replace("n","7");
        barcode = barcode.replace("d","8");
        barcode = barcode.replace("q","9");

        return barcode;
    }


}
