package lsa;

import lsa.modeling.ModelingGsa;
import lsa.streams.BeginData;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        var beginData = new BeginData();

        try {
            var dataFromFile = beginData.getFromFile("ЛСАБарановскийДА.txt");
            var MG = new ModelingGsa(dataFromFile);
            var s = MG.getResultFromString("1010");
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}