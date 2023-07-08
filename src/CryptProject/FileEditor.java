package CryptProject;

import CryptProject.CryptAlg.Crypter;
import CryptProject.CryptAlg.SpacedCesarCrypter;
import CryptProject.Keys.CesarKey;
import CryptProject.Keys.CryptKey;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileEditor {
    private Path path;
    private String resName="result.txt";
    public FileEditor(Path path){
        this.path=path;
    }
    public void cryptFile(){
        List<String> list=readFromFile();
        CryptKey key=getKey();
        List <String> result=new ArrayList<>();
        Crypter crypter = new SpacedCesarCrypter();
        for (String s:list) {
            result.add(crypter.crypt(s,key));
        }
        resName="crypted.txt";
        createResultFile(result);
    }
    public void decyptFile(){
        List<String> list=readFromFile();
        CryptKey key=getKey();
        Crypter crypter = new SpacedCesarCrypter();
        List <String> result=new ArrayList<>();
        for (String s:list) {
            result.add(crypter.decrypt(s,key));
        }
        resName="decrypted.txt";
        createResultFile(result);
    }
    public  void brutalDecrypt() {
        List<String> list=readFromFile();
        SpacedCesarCrypter crypter = new SpacedCesarCrypter();
        List <String> result=new ArrayList<>();
        for (String s:list) {
            result.add(crypter. brutalDecrypt(s));
        }
        resName="decrypted.txt";
        createResultFile(result);
    }
    private CryptKey getKey(){
        System.out.println("Input key from 0 to "+ SpacedCesarCrypter.MAXKEY);
        Scanner scanner = new Scanner(System.in);
        CryptKey key= new CesarKey();
        int keyValue = scanner.nextInt();
        key.setValue(keyValue);
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
        String url = path.getParent().toString()+"\\"+resName;


        try {
            Path newFile = Path.of(url);
            if (Files.deleteIfExists(newFile)) System.out.println("Trying to delete old file.");
            Files.createFile(newFile);
            Files.write(newFile,result);
            System.out.println("Created result file "+url);
        } catch (IOException e) {
            System.out.println("Cannot create file: "+url);
            System.out.println(e.toString());
        }
    }
}
