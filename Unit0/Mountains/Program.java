package Unit0.Mountains;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Program {
    public static void main(String[] args) throws IOException {
        // input mountains database
        Path dbPath = Paths.get("Unit0/Mountains/Files/mountains_db.tsv");
        BufferedReader br = Files.newBufferedReader(dbPath, StandardCharsets.UTF_8);
        // System.out.println(dbPath.toAbsolutePath().toString());
        // output mountains database(clean and err)
        Path cleanPath = Paths.get("Unit0/Mountains/Files/mountains_clean.tsv");
        BufferedWriter cbw = Files.newBufferedWriter(cleanPath, StandardCharsets.UTF_8);
        Path errPath = Paths.get("Unit0/Mountains/Files/mountains_err.tsv");
        BufferedWriter ebw = Files.newBufferedWriter(errPath, StandardCharsets.UTF_8);
        // Sample code
        String header = br.readLine();
        cbw.write(header + "\n");
        ebw.write(header + "\n");
        Mountains mountains = new Mountains();
        while(br.ready()) {
            String line = br.readLine();
            if(mountains.isValid(line)) {
                cbw.write(line + "\n");
            }
            else {
                ebw.write(line + "\n");
            }
        }
        System.out.println("Size of original database: " + mountains.getNumRecords());
        System.out.println("Size of cleaned database: " + mountains.getCleanRecords());
        System.out.println("Number of valid records: " + mountains.getCleanRecords());
        System.out.println("Number of corrupt records: " + mountains.getCorruptRecords());
        System.out.println("Shortest mountain: " + mountains.getShortestMountain().getName());
        System.out.println("Tallest mountain: " + mountains.getTallestMountain().getName());
        br.close();
        cbw.close();
        ebw.close();
    };
}