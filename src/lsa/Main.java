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
                System.out.println("\nModeling is over");
                init();
                break;
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
                System.out.println("\nModeling is over");
                init();
                break;
            }
            case "3": {
                model.iteratingLogicalConditions();
                System.out.println("\nModeling is over");
                init();
                break;
            }
            case "4": {
                typeModel();
                init();
                break;
            }
            case "5": {
                System.out.println("Program is over, shutting down...");
                break;
            }
            default: {
                System.out.println("Where is an action?");
                init();
                break;
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
            System.out.println("Type model: (like \nX1(X - is condition, 1 - is stage of condition) or \nS(S - is arrow)5(5 - is stage of arrow)1(1 - is down arrow and 0 - is up arrow) or \nY5(Y - value and 5 - is stage of value) or \nW(unconditional jump) or Yn(start of algorithm) or Yk(end pf algorithm))");
            var strOfModel = sc.nextLine();
            arr = beginData.getFromUser(strOfModel);
        } else if (str.equals("2")) {
            System.out.println("Type name of file: " + "\n1. ЛСА-БарановскийДА.txt" + "\n2. ЛСА-АнисимовГА.txt" + "\n3. ЛСА-ЗверевСИ.txt" + "\n4. ЛСА-ЩурАА.txt");
            String fileName = "";
            while (true) {
                fileName = sc.nextLine();
                if (!fileName.equals("1") && !fileName.equals("2") && !fileName.equals("3") && !fileName.equals("4") || fileName.length() < 1)
                    System.out.println("[Error]: String is empty or full of letters, try again");
                else break;
            }
            try {
                if (fileName.equals("1")) arr = beginData.getFromFile("ЛСА-БарановскийДА.txt");
                if (fileName.equals("2")) arr = beginData.getFromFile("ЛСА-АнисимовГА.txt");
                if (fileName.equals("3")) arr = beginData.getFromFile("ЛСА-ЗверевСИ.txt");
                if (fileName.equals("4")) arr = beginData.getFromFile("ЛСА-ЩурАА.txt");
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