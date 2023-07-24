package CryptProject.CryptAlg;

import CryptProject.Keys.CesarKey;
import CryptProject.Keys.CryptKey;

public class CeasarCrypter implements Crypter{
   public static final int MAX_KEY_VALUE = 33;

    public String crypt(String source, CryptKey key){
        char[] srcArray =source.toCharArray();
        String resultString = "";

        for (int i = 0; i < srcArray.length; i++) {
            if (srcArray[i]+key.getIntKey()> Character.MAX_VALUE) resultString += (char)(srcArray[i]+key.getIntKey()- Character.MAX_VALUE);
            else if (srcArray[i]+key.getIntKey()< Character.MIN_VALUE) resultString += (char)(srcArray[i]+key.getIntKey()+Character.MAX_VALUE);
                else resultString += (char)(srcArray[i]+key.getIntKey());
        }
        return resultString;
    }
    public String decrypt(String source, CryptKey key){
        CryptKey decryptKey = new CesarKey();
        decryptKey.setValue(-key.getIntKey()); //decrypt is crypting with minus key value
        return crypt(source, decryptKey);
    }
}
