import java.io.BufferedReader;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class MenuAction {

    private final String PROMTTEXT = """
            What do you want to do?
               1. Crypt yor file.
               2. Decrypt your file.
               3. Hack the file.
               0. Exit.
            type number and press Enter:
            """;
    private final String FILEDESTINATIONREQUEST = "Input full file name (incl. location):";
    private final int CRYPTOPTION=1;
    private final int DECRYPTOPTION=2;
    private final int HACKOPTION=3;

    private int select=-1;
    public void proceed() {
        System.out.println(FILEDESTINATIONREQUEST);
        Scanner scanner = new Scanner(System.in);
        String url = scanner.nextLine();
        Path path = Paths.get(url);
        if (Files.exists(path)) {

            while (select != 0) {
                System.out.println(PROMTTEXT);
                select = scanner.nextInt();
                getAction(select, path);
                select=0;
            }
        } else System.out.println("File not found");
    }


    private void getAction(int selection, Path path){
        switch (selection) {
            case CRYPTOPTION -> new Cryptable(path).cryptFile();
            case DECRYPTOPTION -> new Cryptable(path).decyptFile();
            case HACKOPTION -> new Cryptable(path).brutalDecrypt();
        }
    }
}
