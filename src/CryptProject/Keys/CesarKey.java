package CryptProject.Keys;

public class CesarKey implements CryptKey{
    private int keyValue;
    @Override
    public int getIntKey() {
        return keyValue;
    }

    @Override
    public void setValue(int value) {
        this.keyValue=value;

    }
}
