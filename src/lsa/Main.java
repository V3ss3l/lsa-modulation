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

    public static void main(String[] args){
        System.out.println("_Modulation program_" + "\nBy brigade №1\n");
        init();
    }

    //method of main user interface work
    public static void init() {
        typeModel();
        System.out.println("\nOperations:"
                + "\n1. Modeling by typing each step"
                + "\n2. Modeling by typing all X conditions"
                + "\n3. Modeling each condition of X"
                + "\n4. Change the model"
                + "\n5. Exit from program");
        var choice = sc.nextLine();
        switch (choice) {
            case "1": {
                    while (true) {
                        System.out.println("Type step: (if you want to exit, type |exit|)");
                        var step = sc.nextLine();
                        if (step == "exit") {
                            break;
                        }
                        model.writeStep();
                    }
                }
                System.out.println("Modeling is over");
                init();
            case "2": {
                System.out.println("Type conditions: (if you want to exit, type |exit|)");
                boolean flag = true;
                String conditions = "";
                while(flag) {
                    conditions = sc.nextLine();
                    if (conditions.equals("exit")) break;
                    if(conditions.length() > 0) flag = false;
                    if (conditions.length() < 1) {
                        System.out.println("[Error]: String is empty, try again");
                    }
                }
                model.getResultFromString(conditions);
                System.out.println("Modeling is over");
                init();
            }
            case "3": {

            }
            case "4": {
                typeModel();
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
    public static void typeModel(){
        System.out.println("Which way do you want to model GSA: (type |Console| or |File|)" + "\nconsole" + "\nfile");
        var str = sc.nextLine();
        if(str.length() < 1) System.out.println();
        if(str.equals("console")) {
            System.out.println("Type model: (like X10 or S1 or Y51 or W or Yn or Yk)");
            var strOfModel = sc.nextLine();
            arr = beginData.getFromUser(strOfModel);
        }
        else if(str.equals("file")){
            System.out.println("Type name of file: ");
            var fileName = sc.nextLine();
            try {
                arr = beginData.getFromFile(fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (arr.length < 1) {
            System.out.println("[Error]: array is empty, try again");
            typeModel();
        }else {
            System.out.println("Model was successfully made!");
            model = new ModelingGsa(arr);
        }
    }
}