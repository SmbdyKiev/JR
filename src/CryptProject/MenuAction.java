package CryptProject;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class MenuAction {

    private final String PROMT_TEXT = """
            We can do next actions with your file:
               1. Crypt yor file.
               2. Decrypt your file.
               3. Hack the file.
               0. Exit.
            type number and press Enter:
            """;
    private final String FILE_DESTINATION_REQUEST = "Input full file name (incl. location):";
    private final int CRYPT_OPTION = 1;
    private final int DECRYPT_OPTION = 2;
    private final int BRUT_FORCE_OPTION = 3;
    private  final int EXIT_OPTION = 0;
    private  final int UNDEFINED_OPTION = -1;

    private int select = UNDEFINED_OPTION;
    public void proceed() {
        System.out.println(FILE_DESTINATION_REQUEST);
        Scanner scanner = new Scanner(System.in);
        String url = scanner.nextLine();
        Path path = Paths.get(url);
        if (Files.exists(path)) {

            while (select != EXIT_OPTION) {
                System.out.println(PROMT_TEXT);
                select = scanner.nextInt();
                getAction(select, path);
                select = EXIT_OPTION;
            }
        } else System.out.println("File not found");
    }


    private void getAction(int selection, Path path){
        switch (selection) {
            case CRYPT_OPTION -> new FileEditor(path).cryptFile();
            case DECRYPT_OPTION -> new FileEditor(path).decryptFile();
            case BRUT_FORCE_OPTION -> new FileEditor(path).brutalDecrypt();
        }
    }
}
