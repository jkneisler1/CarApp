import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Author: John Kneisler
 * Date: 09/18/19
 */
public class CarApp {

    private Scanner keybd = new Scanner(System.in);
    private String input;

    public static void main(String[] args) {
        // Car car = new Car();
        CarApp carApp = new CarApp();
        carApp.carSetUp();
    }

    /**
     * Set up the car:
     * make: Chevy, Ford, Porsche
     * model:
     * color
     * engine size
     * mpg
     * gas tank size
     */
    public void carSetUp() {
        String make = "";
        String model = "";
        String engine = "";
        String models = "";

        ArrayList<String> carColors = new ArrayList<>();
        carColors.add("White");
        carColors.add("Blue");
        carColors.add("Red");
        carColors.add("Grey");
        carColors.add("Black");

        HashMap<String, String> autoChoice = new HashMap<>();
        autoChoice.put("g", "GT3 Turbo");
        autoChoice.put("m", "Mustang");
        autoChoice.put("u", "Focus");
        autoChoice.put("v", "Corvette");
        autoChoice.put("x", "Boxster");
        autoChoice.put("z", "Cruze");

        HashMap<String, Pair> engineChoice = new HashMap<>();       // the numbers are in horse power
        engineChoice.put("Chevy_Corvette", new Pair("400", "600"));
        engineChoice.put("Chevy_Cruze", new Pair("200", "400"));
        engineChoice.put("Ford_Focus", new Pair("200", "400"));
        engineChoice.put("Ford_Mustang", new Pair("400", "600"));
        engineChoice.put("Porsche_Boxster", new Pair("400", "600"));
        engineChoice.put("Porsche_911GT3", new Pair("600", "800"));

        String makes = "\t(C)hevy, (F)ord, (P)orsche";
        String chevyModels = "\tCor(v)ette or Cru(z)e";
        String fordModels = "\t(M)ustang or Foc(u)s";
        String PorscheModels = "\t(G)T3 Turbo or Bo(x)ster";
        HashMap<String, Pair> modelSelect = new HashMap<>();

        boolean choice1 = true;
        boolean choice2 = true;
        boolean choice3 = true;

        // Choose the make of the car
        while (choice1) {
            System.out.println("Please choose your car make: ");
            System.out.println("\tYour make choices are: ");
            System.out.println(makes);
            input = keybd.nextLine();
            if (input.equalsIgnoreCase("c")) {
                System.out.println("You choose a Chevy");
                make = "Chevy";
                models = chevyModels;
                choice1 = false;
                Pair chevyPair = new Pair("c", "v");
                modelSelect.put(make, chevyPair);
            } else if (input.equalsIgnoreCase("f")) {
                System.out.println("You choose a Ford");
                make = "Ford";
                models = fordModels;
                choice1 = false;
                Pair fordPair = new Pair("m", "u");
                modelSelect.put(make, fordPair);
            } else if (input.equalsIgnoreCase("p")) {
                System.out.println("You choose a Porsche");
                make = "Porsche";
                models = PorscheModels;
                choice1 = false;
                Pair PorschePair = new Pair("g", "x");
                modelSelect.put(make, PorschePair);
            } else {
                System.out.println("\nYou made an invalid choice, please choose again\n");
            }
        }

        // Choose the model of the car
        while (choice2) {
            System.out.println("Please choose your model: ");
            System.out.println("\tYour make choices are: ");
            System.out.println(models);
            input = keybd.nextLine();
            if (modelSelect.get(make).check(input)) {
                choice2 = false;
                model = autoChoice.get(input);
            } else {
                System.out.println("\nYou made an invalid choice, please choose again\n");
            }
        }

        // Choose the engine size for the car
        String engineType = make + "_" + model;
        String engineSize;
        while (choice3) {
            System.out.println("Please choose your engine (in hp)");
            System.out.println("\tYour engine choices for " + make + " " + model + " are: ");
            engineSize = engineChoice.get(engineType).printEach("Engine 1 is ", "Engine 2 is ");
            System.out.println(engineSize);
            input = keybd.nextLine();
            if (engineChoice.get(engineType).check(input)) {
                choice3 = false;
                engine = input;
            } else {
                System.out.println("\nYou made an invalid choice, please choose again\n");
            }
        }

        // Choose car color
        System.out.println("Please choose you car color.");
        System.out.println("\tYour color choices are:");
        int index = 1;
        int colorChoice;
        for(String color : carColors) {
            System.out.println("\t\tChoice number " + index + " is " + color);
            index += 1;
        }
        System.out.println("Please enter the number that corresponds to the color to make your choice.");
        colorChoice = keybd.nextInt();
        String carColor = carColors.get(colorChoice - 1);

        System.out.println("Congratulations your car has been selected.  You choose:");
        System.out.println("The make of the car is: " + make);
        System.out.println("The model of the car is: " + model);
        System.out.println("The engine of the car is: " + engine + " hp.");
        System.out.println("The color of your car is: " + carColor);

        Car yourCar = new Car(make, model, carColor, Integer.parseInt(engine));

        /**Time to start driving your new car
         * Print the functions on how to operate the car
         *      f - go forward
         *      b - go in reverse
         *      r - turn right
         *      l - turn left
         *      s - go straight ahead
         */
        StringBuilder sbDrive = new StringBuilder();
        sbDrive.append("Enter the following characters to drive your car:\n");
        sbDrive.append("\n\tType \"f\" to move forward and \"b\" to move backward.");
        sbDrive.append("\n\tType \"s\" to move straight, \"r\" to turn right, and \"l\" to turn left.");
        sbDrive.append("\n\tType \"+\" to accelerate and \"-\" to slow down.");
        sbDrive.append("\n\tType \"q\" to quit the simulation.");
        String driveInstructions = sbDrive.toString();
        boolean drive = true;
        String driveChoice;
        int magnitude = 0;
        while(drive) {
            System.out.println(driveInstructions);
            driveChoice = keybd.nextLine();
            if (driveChoice.startsWith("+")) {
                magnitude = driveChoice.length();
                driveChoice = "+";
            }
            else if (driveChoice.startsWith("-")) {
                magnitude = driveChoice.length();
                driveChoice = "-";
            }
            switch (driveChoice.toLowerCase()) {
                case "f":
                    System.out.println("You are moving forward.");
                    break;
                case "b":
                    System.out.println("You are moving backward.");
                    break;
                case "s":
                    System.out.println("You are traveling straight.");
                    break;
                case "r":
                    System.out.println("You just turned right.");
                    break;
                case "l":
                    System.out.println("You just turned left.");
                    //yourCar.turnLeft;
                    break;
                case "+":
                    System.out.println("You are speeding up...");
                    yourCar.accelerate(magnitude);
                    break;
                case "-":
                    System.out.println("You are slowing down...");
                    yourCar.decelerate(magnitude);
                    break;
                case "q":
                    drive = false;
                    System.out.println("I hope you enjoyed your drive.");
                    break;
                default:
                    System.out.println("Not a valid entry please try again");
                    break;
            }
        }

    }

}