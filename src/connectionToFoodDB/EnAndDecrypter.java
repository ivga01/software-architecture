package connectionToFoodDB;


import connectionToSupermarket.EnAndDecoder;

public class EnAndDecrypter implements EnAndDecoder{


    @Override
    public String encrypt(String strToEncrypt, String secret) {

        return rot20(strToEncrypt);
    }

    @Override
    public String decrypt(String strToDecrypt, String secret) {

        return rot20(strToDecrypt);
    }

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
