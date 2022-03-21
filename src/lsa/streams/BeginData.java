package lsa.streams;

import lsa.model.Entity;
import lsa.util.EntityParser;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class BeginData {
    public Entity[] getFromFile(String fileName) throws IOException {
        var fileReader = new FileReader(fileName);
        var bufferedReader = new BufferedReader(fileReader);
        return EntityParser.parsingOfEntity(bufferedReader.readLine());
    }

    public Entity[] getFromUser(String txt){
        if(txt.length() == 0){
            System.out.println("Error: string is empty, try again");
            Scanner sc = new Scanner(System.in);
            txt = sc.nextLine();
            getFromUser(txt);
        }
        return EntityParser.parsingOfEntity(txt);
    }
}
