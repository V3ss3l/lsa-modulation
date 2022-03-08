package lsa.modeling;

import lsa.model.Entity;

import java.util.HashMap;
import java.util.Scanner;

public class ModelingGsa {
    private HashMap<Integer, Entity> entityHashMap;

    public ModelingGsa(HashMap<Integer, Entity> entityHashMap) {
        this.entityHashMap = entityHashMap;
        //TODO дописать сортировку
        for(int i = 0; i < entityHashMap.size(); i++){
            entityHashMap.get(i);
        }
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
    }
}
