import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Cryptable {
    private Path path;
    public Cryptable(Path path){
        this.path=path;
    }
    public void cryptFile(){
        List<String> list=readFromFile();
        int key=getKey();
        List <String> result=new ArrayList<>();
        for (String s:list) {
            result.add(CeasarCrypt.crypt(s,key));
        }
        createResultFile(result);
    }
    public void decyptFile(){
        List<String> list=readFromFile();
        int key=getKey();
        List <String> result=new ArrayList<>();
        for (String s:list) {
            result.add(CeasarCrypt.decrypt(s,key));
        }
        createResultFile(result);
    }
    public  void brutalDecrypt() {
    }
    private int getKey(){
        System.out.println("Input key from 0 to "+CeasarCrypt.MAXKEY);
        Scanner scanner = new Scanner(System.in);
        int key=scanner.nextInt();
        return key;
    }
    private List<String> readFromFile(){
        List<String> list =new ArrayList<>();
        try {
            list = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("Cannot read the file");;
        }
        return list;
    }
    private void createResultFile(List<String> result){
        String url = path.getParent().toString();
        try {
            Path newFile = Files.createFile(Path.of(url+"\\result.txt"));
            Files.write(newFile,result);
            System.out.println("Створено зашифрований файл "+url+"\\result.txt");
        } catch (IOException e) {
            System.out.println("Cannot create file: "+url+"\\result.txt");
        }
    }
}
