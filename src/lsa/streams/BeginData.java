package lsa.streams;

import lsa.model.Entity;
import lsa.util.EntityParser;

import java.io.*;
import java.util.HashMap;

public class BeginData {
    public Entity[] getFromFile(String fileName) throws IOException {
        var fileReader = new FileReader(fileName);
        var bufferedReader = new BufferedReader(fileReader);

        return EntityParser.parsingOfEntity(bufferedReader.readLine());
    }

    public Entity[] getFromUser(String fileName) {
        var txt = "Здесь нужен метод для считавыния данных с консоли";

        return EntityParser.parsingOfEntity(txt);
    }
}
