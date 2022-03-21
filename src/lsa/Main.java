package lsa;

import lsa.model.Entity;
import lsa.modeling.ModelingGsa;
import lsa.streams.BeginData;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        var beginData = new BeginData();
        Scanner sc = new Scanner(System.in);
        System.out.println("_Modulation program_" + "\nBy brigade №1");
        init(beginData, sc);
    }

    public static void init(BeginData beginData, Scanner sc){
        System.out.println("\nOperations:"
                + "\n1. Modeling by typing each step"
                + "\n2. Modeling by typing all X conditions"
                + "\n3. Modeling each condition of X"
                + "\n4. Exit from program");
        var str = sc.nextLine();
        switch (str) {
            case "1": {
                System.out.println("Which way do you want to model GSA:" + "\nConsole" + "\nFile");
                if (sc.nextLine() == "Console") {
                    while (true) {
                        System.out.println("Type step: (if you want to exit, type |exit|)");
                        var step = sc.nextLine();
                        if (step == "exit") {
                            break;
                        }
                        Entity[] arr = beginData.getFromUser(step);
                        if(arr.length < 1){
                            break;
                        }
                        var model = new ModelingGsa(arr);
                        model.writeStep();
                    }
                } else {
                    //написать считывание каждого шага с файла
                }
                System.out.println("Modeling is over");
                init(beginData, sc);
            }
            /*case "2": {
                System.out.println("Which way do you want to model GSA:" + "\nConsole" + "\nFile");
                if (sc.nextLine() == "Console") {
                    while (true) {
                        System.out.println("Type step: (if you want to exit, type |exit|)");
                        var step = sc.nextLine();
                        if (step == "exit") {
                            break;
                        }
                        Entity[] arr = beginData.getFromUser(step);
                        var model = new ModelingGsa(arr);
                        model.writeStep();
                    }
                    System.out.println("Modeling is over");
                    init(beginData, sc);
                }
            }*/
            case"4": {
                System.out.println("Program is over, shutting down...");
                break;
            }
            default: {
                System.out.println("Where is an action?");
                init(beginData, sc);
            }
        }
    }
}