package academy.learnprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
        printFile(path);
//        Path filePath = FileSystems.getDefault().getPath("files","SubdirectoryFile.txt");
        Path filePath = Paths.get(".","files","SubdirectoryFile.txt");

        printFile(filePath);
//        filePath = Paths.get("/Users/marisuzuki/Documents/Udemy_Java_Masterclass/OutThere.txt");
        // filePath can be broken into three areas
        filePath = Paths.get("/Users/marisuzuki/Documents","/Udemy_Java_Masterclass","OutThere.txt");

        printFile(filePath);

        filePath = Paths.get(".");
        System.out.println(filePath.toAbsolutePath());

    }

    private static void printFile(Path path) {
        try(BufferedReader fileReader = Files.newBufferedReader(path)) {
            String line;
            while((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch(IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}
