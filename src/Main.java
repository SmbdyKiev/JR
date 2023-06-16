import java.io.BufferedReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int select=-1;
        Scanner scanner= new Scanner(System.in);
        while (select!=0){
            System.out.println("What do you want to do?");
            System.out.println("1. Crypt yor file.");
            System.out.println("2. Decrypt your file");
            System.out.println("3. Hack the file");
            System.out.println("0. Exit");
            System.out.print("type number and press Enter:");
            select = scanner.nextInt();
            System.out.println("Input full file name (incl. location):");
            String url = scanner.nextLine();
            Path path=Paths.get(url);
            if (Files.exists(path)){
                try (BufferedReader buffer = Files.newBufferedReader(path)){
                    String s="";
                    while (buffer.ready()) {s+=buffer.readLine();}
                } catch (IOException e) {
                    System.out.println("IO exception");;
                }


            }
            else System.out.println("File not found");
        }



    }

}