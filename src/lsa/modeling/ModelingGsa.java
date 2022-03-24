package lsa.modeling;

import lsa.model.Entity;

import java.util.Scanner;

public class ModelingGsa {
    private final Entity[] arrayEntity;
    private StringBuilder txt;

    public ModelingGsa(Entity[] arrayEntity) {
        this.arrayEntity = arrayEntity;
    }

    public void iteratingLogicalConditions() {
        var i = 0;

        while (i < arrayEntity.length) {

            i = searchXWithoutOutput(i);
            if (i == arrayEntity.length) return;

            System.out.print("\nFor Х" + arrayEntity[i].getStage() + " :\n\t1: ");
            txt = new StringBuilder();
            searchX(i + 1);

            System.out.print(txt + "\n\t0: ");
            txt = new StringBuilder();
            searchX(searchS(i + 1));
            System.out.print(txt);

            i++;
        }
    }

    // при вводе значения писать на каком x находимся в данном моменте!!!!
    public void writeStep() {
        var j = 0;
        txt = new StringBuilder();
        var i = 0;
        while (true) {
            j = searchX(j);
            System.out.println(txt);
            if (j == arrayEntity.length) return;

            i = searchXWithoutOutput(j);
            System.out.println("Type condition for X" + arrayEntity[i].getStage() + ": "+" (if you want exit, type 2)");
            Scanner sc = new Scanner(System.in);
            var buff = sc.nextInt();
            // вводимый символ, нужно проверка на то, что это число только 0 или 1
            if(buff!=0 && buff!=1 && buff!=2){
                System.out.println("[Error]: typed symbols arent 0 or 1, please try again");
                writeStep();
            }
            if(buff == 2) return;
            if (buff == 0 && j != arrayEntity.length) j = searchS(j + 1);
            else if (j == arrayEntity.length) return;
            else j++;

            if (arrayEntity[j].getSymbol() != 'Y' && !arrayEntity[j].isBegin() && arrayEntity[j].getStage() == 0)
                break;
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

    private int searchXWithoutOutput(int i){
        while (arrayEntity[i].getSymbol() != 'X' && arrayEntity[i].getSymbol() != 'x'
                && arrayEntity[i].getSymbol() != 'х' && arrayEntity[i].getSymbol() != 'Х') {
            i++;
            if (i == arrayEntity.length) return i;
        }
        return i;
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
