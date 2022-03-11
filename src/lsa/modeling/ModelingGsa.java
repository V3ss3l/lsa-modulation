package lsa.modeling;

import lsa.model.Entity;

import java.util.*;

public class ModelingGsa {
    private Entity[] arrayEntity; // final?
    private StringBuilder txt;

    public ModelingGsa(Entity[] arrayEntity) {
        this.arrayEntity = arrayEntity;
    }

    /*public Entity getResultFromModeling() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String str = sc.nextLine();
            if (str.length() > 1) break;
            if(str == "1"){

            }
            if(str == "0"){

            }
        }
        return new Entity();
    }*/

    public void enumeration() {
        var stage = 0;
        var isFirst = true;
        var listX = new ArrayList<Integer>();
        txt = new StringBuilder();

        for (var j = 0; j < arrayEntity.length; j++) {  // возможно нужно найти последний x
            j = searchX(j);
            stage = arrayEntity[j].getStage();

            if (isFirst && !listX.contains(stage)) {
                listX.add(arrayEntity[j].getStage());
                isFirst = false;
                j = searchS(j + 1);
            } else {

            }
        }
    }

    public String getResultFromString(String str) {
        var j = 0;
        txt = new StringBuilder();
        var i = 0;
        while (i <= str.length()) {
            j = searchX(j);
            if (j == arrayEntity.length) return txt.toString();

            if (str.charAt(i) == '0' && j != arrayEntity.length) {
                i++;
                j = searchS(j + 1);
            } else if (j == arrayEntity.length) {
                return txt.toString();
            } else {
                i++;
                j++;
            }
        }

        return txt.toString();
    }

    private int searchX(int j) {
        while (arrayEntity[j].getSymbol() != 'X' && arrayEntity[j].getSymbol() != 'x'
                && arrayEntity[j].getSymbol() != 'Х' && arrayEntity[j].getSymbol() != 'х') {

            if (arrayEntity[j].getSymbol() == 'Y' || arrayEntity[j].getSymbol() == 'y'
                    || arrayEntity[j].getSymbol() == 'у' || arrayEntity[j].getSymbol() == 'У') {

                txt.append(arrayEntity[j].getSymbol());
                if (j == 0) txt.append("н ");
                else if (j == arrayEntity.length - 1) txt.append("к ");
                else txt.append(arrayEntity[j].getStage()).append(' ');
            }

            if (arrayEntity[j].getSymbol() == 'W') j = searchS(j + 1);

            j++;
            if (j == arrayEntity.length) break;
        }
        return j;
    }

    private int searchS(int j) {
        for (var k = 0; k < arrayEntity.length; k++)
            if (arrayEntity[k].getSymbol() == 'S' && arrayEntity[k].getStage() == arrayEntity[j].getStage() && arrayEntity[k].isBegin())
                return k;
        return 0;
    }
}
