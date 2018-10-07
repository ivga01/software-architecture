package connectionToFoodDB;

//A Java Program to illustrate Caesar Cipher Technique
class CaesarCipher
{

    // Driver code
    public static void main(String[] args)
    {
        int rot = 20;
        String text = "milk";


        StringBuffer result = new StringBuffer();

        for (int i=0; i<text.length(); i++)
        {
            if (Character.isUpperCase(text.charAt(i)))
            {
                char ch = (char)(((int)text.charAt(i) +
                        rot - 65) % 26 + 65);
                result.append(ch);
            }
            else
            {
                char ch = (char)(((int)text.charAt(i) +
                        rot - 97) % 26 + 97);
                result.append(ch);
            }
        }


        System.out.println(result);
    }
}