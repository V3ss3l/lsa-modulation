package lsa;

import lsa.model.Entity;
import lsa.modeling.ModelingGsa;
import lsa.streams.BeginData;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static ModelingGsa model;
    private static Entity[] arr;
    private final static Scanner sc = new Scanner(System.in);
    private final static BeginData beginData = new BeginData();

    public static void main(String[] args) {
        System.out.println("_Modulation program_" + "\nBy brigade №1\n");
        typeModel();
        init();
    }

    //method of main user interface work
    public static void init() {
        System.out.println("\nOperations:" + "\n1. Modeling by typing each step" + "\n2. Modeling by typing all X conditions" + "\n3. Modeling each condition of X" + "\n4. Change the model" + "\n5. Exit from program");
        var choice = sc.nextLine();
        switch (choice) {
            case "1": {
                model.writeStep();
                System.out.println("Modeling is over");
                init();
            }
            case "2": {
                System.out.println("Type conditions: (if you want to exit, type |exit|)");
                boolean flag = true;
                String conditions = "";
                while (flag) {
                    conditions = sc.nextLine();
                    if (conditions.equals("exit")) break;
                    if (conditions.length() > 0) flag = false;
                    if (conditions.length() < 1) {
                        System.out.println("[Error]: String is empty, try again");
                    }
                }
                model.getResultFromString(conditions);
                System.out.println("Modeling is over");
                init();
            }
            case "3": {
                model.iteratingLogicalConditions();
                System.out.println("Modeling is over");
                init();
            }
            case "4": {
                typeModel();
                init();
            }
            case "5": {
                System.out.println("Program is over, shutting down...");
                break;
            }
            default: {
                System.out.println("Where is an action?");
                init();
            }
        }
    }

    //method which make an array of entities and model
    public static void typeModel() {
        System.out.println("Which way do you want to model GSA: (type 1 for console or 2 for file)" + "\n1. Console" + "\n2. File");
        String str = "";
        while (true) {
            str = sc.nextLine();
            if (!str.equals("1") && !str.equals("2") || str.length() < 1) {
                System.out.println("[Error]: String is empty or full of letters, try again");
            } else break;
        }
        if (str.equals("1")) {
            System.out.println("Type model: (like X10 or S1 or Y51 or W or Yn or Yk)");
            var strOfModel = sc.nextLine();
            arr = beginData.getFromUser(strOfModel);
        } else if (str.equals("2")) {
            System.out.println("Type name of file: " + "\n1. ЛСАБарановскийДА.txt" + "\n2. ЛСАБарановскийДВ.txt");
            String fileName = "";
            while (true) {
                fileName = sc.nextLine();
                if (!fileName.equals("1") && !fileName.equals("2") || fileName.length() < 1)
                    System.out.println("[Error]: String is empty or full of letters, try again");
                else break;
            }
            try {
                if (fileName.equals("1")) arr = beginData.getFromFile("ЛСАБарановскийДА.txt");
                if (fileName.equals("2")) arr = beginData.getFromFile("ЛСАБарановскийДВ.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (arr.length < 1) {
            System.out.println("[Error]: array is empty, try again");
            typeModel();
        } else {
            System.out.println("Model was successfully made!");
            model = new ModelingGsa(arr);
        }
    }
}