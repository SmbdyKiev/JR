package CryptProject.CryptAlg;

import CryptProject.Keys.CryptKey;

public interface Crypter {

    String crypt (String s,CryptKey key);
    String decrypt (String s,CryptKey key);
}
