package com.company.Exe.MitkoVerson2.Mitko;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class csvReader {
    public static List<String[]> readCSVLabyrinth(){
        List<String[]> labyrinth = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("/Users/abdullahmehmed/Downloads/mitkoMap.csv"));

            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(",");
                labyrinth.add(line);
            }
            scanner.close();
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
        return labyrinth;
    }
}
