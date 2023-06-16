import java.nio.Buffer;
import java.nio.channels.FileChannel;

public class MenuAction {

    public static void getAction(int selection, FileChannel channel){
        switch (selection) {
            case 1 -> cryptFile;
            case 2 -> decyptFile;
            case 3 -> brutalDecrypt;


        }
    }
}
