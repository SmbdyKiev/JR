package CryptProject.CryptAlg;

import CryptProject.Keys.CesarKey;
import CryptProject.Keys.CryptKey;

public class CeasarCrypter implements Crypter{
   public static final int MAXKEY=33;

    public String crypt (String source, CryptKey key){
        char[] srcArray =source.toCharArray();
        String res="";

        for (int i = 0; i < srcArray.length; i++) {
            if (srcArray[i]+key.getIntKey()> Character.MAX_VALUE) res +=(char)(srcArray[i]+key.getIntKey()- Character.MAX_VALUE);
            else if (srcArray[i]+key.getIntKey()< Character.MIN_VALUE) res +=(char)(srcArray[i]+key.getIntKey()+Character.MAX_VALUE);
                else res += (char)(srcArray[i]+key.getIntKey());
        }
        return res;
    }
    public String decrypt (String source, CryptKey key){
        CryptKey decryptKey = new CesarKey();
        decryptKey.setValue(-key.getIntKey());
        return crypt(source, decryptKey);
    }
}
