import java.util.StringTokenizer;

public class CeasarCrypt {
   public static final int MAXKEY=33;

    public static String crypt (String source, int key){
        char[] srcArray =source.toCharArray();
        String res="";

        for (int i = 0; i < srcArray.length; i++) {
            if (srcArray[i]+key> Character.MAX_VALUE) res +=(char)(srcArray[i]+key- Character.MAX_VALUE);
            else if (srcArray[i]+key< Character.MIN_VALUE) res +=(char)(srcArray[i]+key+Character.MAX_VALUE);
                else res += (char)(srcArray[i]+key);
        }
        return res;
    }
    public static String decrypt (String source, int key){
        return crypt(source,-key);
    }
}
