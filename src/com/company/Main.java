package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) throws IOException {
        LocalDateTime start = LocalDateTime.now();
        String longAsString = new String(Files.readAllBytes(Paths.get("C:/Users/Asus/Desktop/kohonen-oct/logs.txt")));
        String[] lines = longAsString.split(System.lineSeparator());
        List<String> octList =  Arrays.stream(lines)
                .filter(line->line.contains("2019-10-20"))
                .collect(Collectors.toList());
        String out = "";

        for (int i = 0; i < octList.size(); i++) {
            out+= octList.get(i) +System.lineSeparator();

        }

        Path path = Paths.get("C:/Users/Asus/Desktop/kohonen-oct/logs.txt");
        //Files.write(path,out.getBytes(StandardCharsets.UTF_8));

        System.out.println(ChronoUnit.MILLIS.between(start,LocalDateTime.now()));


        start = LocalDateTime.now();
        System.out.println(ChronoUnit.MILLIS.between(start,LocalDateTime.now()));
        final StringBuilder sb = new StringBuilder("");
        Files.lines(Paths.get("C:/Users/Asus/Desktop/kohonen-oct/logs.txt"))
                .filter(line -> line.contains("2019-10-20"))
                .forEach(line->sb.append(line+System.lineSeparator()));
        Files.write(path,out.getBytes(StandardCharsets.UTF_8));

        System.out.println(ChronoUnit.MILLIS.between(start,LocalDateTime.now()));


        start = LocalDateTime.now();

        Scanner scanner = new Scanner(new File("C:/Users/Asus/Desktop/kohonen-oct/logs.txt"));
       // List<String> linesByScanner = new ArrayList<>();
        out = "";
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            if (line.contains("2019-10-20"))
                out+=line + System.lineSeparator();
        }

        Files.write(path,out.getBytes(StandardCharsets.UTF_8));
        System.out.println(ChronoUnit.MILLIS.between(start,LocalDateTime.now()));
        
    }
}
