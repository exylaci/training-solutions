package week07.d5;

import filescanner.BucketList;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveInput {

    public DataToFile writeToFile() {
        List<String> lines = new ArrayList<>();

        lines=askLines();
        String filename = askFileNamne();

        DataToFile dataToFile = new DataToFile(filename,lines);
        writeToFile(dataToFile);
        return dataToFile;
    }

    private void writeToFile(DataToFile dataToFile) {
        Path path = Paths.get(dataToFile.getFilename());
        try(
        BufferedWriter writer = Files.newBufferedWriter( path)
        ){
            for (String one : dataToFile.getLines() ) {
                writer.write(one);
                writer.newLine();
            }
        }catch (IOException e){

        }
    }

    private String askFileNamne() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Mi legyen a file nve: ");
        String filename = scanner.nextLine();
        return filename;
    }

    private List<String>  askLines() {
        List<String> lines = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kérek három sort!");
        for( int i=0;i<3;++i){
            lines.add(scanner.nextLine());
        }
        return lines;
    }
}
//Kérj be a felhasználótól három sort,
// majd a fájl nevét.
//
//
// Mentsd el a sorokat ebbe a fájlba.
// A week07d05.SaveInput osztályba dolgozz! (edited)