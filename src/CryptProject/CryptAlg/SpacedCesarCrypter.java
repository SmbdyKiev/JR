package CryptProject.CryptAlg;

import CryptProject.Keys.CesarKey;
import CryptProject.Keys.CryptKey;

public class SpacedCesarCrypter extends CeasarCrypter{
    private final String KEY_NOT_FOUND="Unable to find correct key, sorry, brutal decryption failed";
    private final String KEY_IS_FOUND="Key was found: ";
    @Override
    public String crypt(String source, CryptKey key) {
        return super.crypt(" "+source, key);
    }

    @Override
    public String decrypt(String source, CryptKey key) {
        return new CeasarCrypter().decrypt(source.substring(1), key);
    }

    public String brutalDecrypt(String source){
        var key = new CesarKey();
        key.setValue(0);
        String checkSymbol = source.substring(0,1);
        CeasarCrypter checkDecrypter = new CeasarCrypter();
        while (!checkDecrypter.decrypt(checkSymbol,key).equals(" ")&&key.getIntKey() <= checkDecrypter.MAX_KEY_VALUE) {
            key.setValue(key.getIntKey()+1);
        }
        if (key.getIntKey() == 0){
            System.out.println(KEY_NOT_FOUND);
            return source;
        }
        else {
            System.out.println(KEY_IS_FOUND + key.getIntKey());
            return new CeasarCrypter().decrypt(source.substring(1,source.length()),key);
        }

    }
}
