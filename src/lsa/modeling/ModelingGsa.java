package lsa.modeling;

import lsa.model.Entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ModelingGsa {
    private HashMap<Integer, Entity> entityHashMap;
    public Map map;

    public ModelingGsa(HashMap<Integer, Entity> entityHashMap) {
        this.entityHashMap = entityHashMap;
        map = new TreeMap<>(entityHashMap); // сортировка
    }

    public Entity getResultFromModeling() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String str = sc.nextLine();
            if (str.length() > 1) break;
            if(str == "1"){

            }
            if(str == "0"){

            }
        }
        return new Entity()
    }
}
