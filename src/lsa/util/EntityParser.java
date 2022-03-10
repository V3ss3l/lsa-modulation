package lsa.util;

import lsa.model.Entity;

import java.util.ArrayList;
import java.util.HashMap;

public class EntityParser {

    public static Entity[] parsingOfEntity(String str) {
        var strArr = str.split(" ");
        var list = new ArrayList<Entity>();
        var buff = '-';
        var isNumber = false;
        var number = 0;
        var begin = false;

        for (var s : strArr) {
            if (s.contains("S")) {
                for (int i = 0; i < s.length(); i++) {
                    if (!isNumber && s.charAt(i) != 'S') {
                        isNumber = true;
                        number = Character.getNumericValue(s.charAt(i));
                    } else if (s.charAt(i) == '1' || s.charAt(i) == '0') begin = s.charAt(i) != '0';
                    else buff = s.charAt(i);
                }
            } else if (s.contains("Y") || s.contains("У")) {
                for (var i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == 'у' || s.charAt(i) == 'У' || s.charAt(i) == 'Y') buff = s.charAt(i);
                    else if (s.charAt(i) == 'Н' || s.charAt(i) == 'н') begin = true;
                    else if (s.charAt(i) == 'К' || s.charAt(i) == 'к') begin = false;
                    else number = Character.getNumericValue(s.charAt(i));
                }
            } else if (s.contains("X") || s.contains("Х")) {
                for (var q = 0; q < s.length(); q++) {
                    if (s.charAt(q) == 'X' || s.charAt(q) == 'x' || s.charAt(q) == 'Х' || s.charAt(q) == 'х')
                        buff = s.charAt(q);
                    else
                        number = Character.getNumericValue(s.charAt(q));
                }
            } else {
                list.add(new Entity(s.charAt(0), false, 0));
                continue;
            }

            list.add(new Entity(buff, begin, number));
            number = 0;
            begin = false;
            isNumber = false;
        }

        return toArray(list);
    }

    public static Entity[] toArray(ArrayList<Entity> list) {
        var ar = new Entity[list.size()];
        var i = 0;
        for (var element : list) {
            ar[i] = element;
            i++;
        }
        return ar;
    }
}
