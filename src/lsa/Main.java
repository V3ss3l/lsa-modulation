package lsa;

import lsa.streams.BeginData;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        var beginData = new BeginData();

        try {
            beginData.getFromFile("Тест.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}