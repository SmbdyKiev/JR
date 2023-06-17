import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cryptable {
    private Path path;
    public Cryptable(Path path){
        this.path=path;
    }
    public void cryptFile(){
        List<String> list=new ArrayList<>();
        int key=0;
        System.out.println("Input key from 0 to "+CeasarCrypt.MAXKEY);
        Scanner scanner = new Scanner(System.in);
        key=scanner.nextInt();
        try {
            list = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("Cannot read the file");;
        }
        List <String> result=new ArrayList<>();
        for (String s:list) {
            result.add(CeasarCrypt.crypt(s,key));
        }
        String url = path.getParent().toString();
        try {
            Path newFile = Files.createFile(Path.of(url+"\\crypted.txt"));
            Files.write(newFile,result);
            System.out.println("Створено зашифрований файл "+url+"\\crypted.txt");
        } catch (IOException e) {
            System.out.println("Cannot create file: "+url+"\\crypted.txt");
        }

    }
    public void decyptFile(){
    }
    public  void brutalDecrypt() {
    }
}
