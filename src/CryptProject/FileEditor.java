package CryptProject;

import CryptProject.CryptAlg.Crypter;
import CryptProject.CryptAlg.SpacedCesarCrypter;
import CryptProject.Keys.CesarKey;
import CryptProject.Keys.CryptKey;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileEditor {
    private final String FILE_NAME_REQUEST= """
    Please, input destination file name for result. 
    It will be created in the same folder as source file.
    Attention! If file already exist, it will be replaced.
    Result file name (format: 'file.txt'): 
    """;
    private Path path;
    public FileEditor(Path path){
        this.path=path;
    }
    public void cryptFile(){
        List<String> list = readFromFile();
        CryptKey key=getKey();
        List <String> result = new ArrayList<>();
        Crypter crypter = new SpacedCesarCrypter();
        for (String s:list) {
            result.add(crypter.crypt(s,key));
        }
        createResultFile(result);
    }
    public void decryptFile(){
        List<String> list = readFromFile();
        CryptKey key = getKey();
        Crypter crypter = new SpacedCesarCrypter();
        List <String> result = new ArrayList<>();
        for (String s:list) {
            result.add(crypter.decrypt(s,key));
        }
        createResultFile(result);
    }
    public  void brutalDecrypt() {
        List<String> list = readFromFile();
        SpacedCesarCrypter crypter = new SpacedCesarCrypter();
        List <String> result = new ArrayList<>();
        for (String s:list) {
            result.add(crypter.brutalDecrypt(s));
        }
        createResultFile(result);
    }
    private CryptKey getKey(){
        System.out.println("Input key from 0 to "+ SpacedCesarCrypter.MAX_KEY_VALUE);
        Scanner scanner = new Scanner(System.in);
        CryptKey key= new CesarKey();
        int keyValue = scanner.nextInt();
        key.setValue(keyValue);
        return key;
    }
    private List<String> readFromFile(){
        List<String> list = new ArrayList<>();
        try {
            list = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("Cannot read the file");;
        }
        return list;
    }
    private void createResultFile(List<String> result){
        String resultFileName;
        System.out.println(FILE_NAME_REQUEST);
        resultFileName = new Scanner(System.in).nextLine();
        String url = path.getParent().toString()+File.separator+ resultFileName;
        try {
            Path newFile = Path.of(url);
            if (Files.deleteIfExists(newFile)) System.out.println("Trying to delete old file.");
            Files.createFile(newFile);
            Files.write(newFile,result);
            System.out.println("Created result file " + url);
        } catch (IOException e) {
            System.out.println("Cannot create file: " + url);
        }
    }
}
