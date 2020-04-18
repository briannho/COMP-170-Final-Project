//Brian Ho
package CalorieTracker;

import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * primary application
 */
public class MainApp {

    private static Scanner sc = new Scanner(System.in);
    private static Profile user;
    private static Entry b;
    private static Entry l;
    private static Entry d;

    public static void main(String[] args) {
        
        /**
         * runs the app
         * will catch any exception produced by user input
         */
         try {
             run();
             end();
         } catch (Exception e) {
             System.out.println("There has been an error.");
         }
    }

    /**
     * runs all the methods that write the app to file
     */
    public static void run() {
        String[] data = new String[1];
        data = populateData(data);

        saveDataToFile(data);
    }

    /**
     * builds the dataset from the app's methods below
     * @param lines represents the dataset
     * @return the dataset
     */
    public static String[] populateData(String[] lines) {
        for (int i = 0; i < lines.length; i++) {
            start();
            user = createNewProfile();
            sex();
            printProfile();
            entryPrompt();
            summary();
        }
        return lines;
    }

    /**
     * types the dataset into the designated filename
     * @param data the dataset that is being typed
     * @param filename name of the file
     */
    public static void saveDataToFile(String[] data, String filename) {
        System.out.print("Now saving to " + filename);
        try {
            PrintWriter pw = new PrintWriter(filename);

            for (String line : data) {
                pw.println(line);
                System.out.print(".");
            }
            pw.close();
            System.out.println("Done writing to file");
        } catch (IOException e) {
            System.out.println("Could not write to file: " + e.getMessage());
        }
    }

    /**
     * saves the data to the file
     * @param data the dataset
     */
    public static void saveDataToFile(String[] data) {
        saveDataToFile(data, "/HO_B/CalorieTracker/CalorieTrackerLog.txt");
    }

    /**
     * introduction of app
     */
    private static void start() {
        System.out.println("Welcome to Brian's Calorie Tracker!");
        System.out.println("Create a new profile.\n");
    }

    /**
     * prompts user to enter profile information
     * @return new profile
     */
    private static Profile createNewProfile() {
        System.out.print("Please enter your name: ");
        String name = sc.next();
        System.out.print("age: ");
        int age = sc.nextInt();
        System.out.print("weight in kilograms: ");
        double weight = sc.nextDouble();
        System.out.print("height in centimeters: ");
        double height  = sc.nextDouble();

        return new Profile(name, age, weight, height);
    }

    /**
     * prompts user to enter his/her sex
     */
    private static void sex() {
        System.out.println("sex: ");
        System.out.println("\t(1) male");
        System.out.println("\t(2) female");
        System.out.print("Enter answer as an integer: ");
        int sex = sc.nextInt();

        if (sex == 1) {
            maleCalGoal();
        }
        else if (sex == 2) {
            femaleCalGoal();
        }
    }

    /**
     * if female, prompts user to determine their weight goal
     */
    private static void femaleCalGoal() {
        System.out.println("Are you trying to:");
        System.out.println("\t(1) maintain weight?");
        System.out.println("\t(2) gain weight?");
        System.out.println("\t(3) lose weight?");
        System.out.print("Enter choice as an integer: ");
        int weightGoal = sc.nextInt();

        if (weightGoal == 1) {
            FemaleUser.maintainWeight();
        }
        else if (weightGoal == 2) {
            FemaleUser.gainWeight();
        }
        else if (weightGoal == 3){
            FemaleUser.loseWeight();
        }
        System.out.println("Your goal is " + user.getCalorieGoal() + " calories per day!");
    }

    /**
     * if male, prompts user to determine their weight goal
     */
    private static void maleCalGoal() {
        System.out.println("Are you trying to:");
        System.out.println("\t(1) maintain weight?");
        System.out.println("\t(2) gain weight?");
        System.out.println("\t(3) lose weight?");
        System.out.print("Enter choice as an integer: ");
        int weightGoal = sc.nextInt();

        if (weightGoal == 1) {
            MaleUser.maintainWeight();
        }
        else if (weightGoal == 2) {
            MaleUser.gainWeight();
        }
        else if (weightGoal == 3){
            MaleUser.loseWeight();
        }
        System.out.println("Your goal is " + user.getCalorieGoal() + " calories per day!");
    }

    /**
     * prints user's information
     * allows user to view information just entered
     */
    private static void printProfile() {
        System.out.println("\nThanks for creating a new profile, " + user + "!");
        user.printDetails();
        b = new Breakfast();
        l = new Lunch();
        d = new Dinner();
    }

    /**
     * starts the entry method
     * prompts user if he/she would like to enter an entry
     */
    private static void entryPrompt() {
        System.out.println("\nWould you like to enter an entry?");
        System.out.println("(1) yes   (2) no");
        System.out.print("Enter choice as an integer: ");
        int choice = sc.nextInt();

        if (choice == 1) {
            enterEntry();
        }
        if (choice == 2) {
            System.out.println("Printing out summary...\n");
        }
    }

    /**
     * if user wants to enter an entry, user can decide which type of meal he/she would like to enter
     * calculates and prints how many calories remain
     * brings user back to entryPrompt() and allow user to enter another entry or exit
     */
    private static void enterEntry() {
        System.out.println("\nWhat have you eaten today?");
        System.out.println("(1) breakfast");
        System.out.println("(2) lunch");
        System.out.println("(3) dinner");
        System.out.print("Enter choice as an integer: ");
        int food = sc.nextInt();
            if (food == 1) {
                b = enterBreakfast();
                int newCalorieGoal =  user.getCalorieGoal() - b.getCalories();
                user.setCalorieGoal(newCalorieGoal);
                int breakfastTotal = user.getCalorieTotal() + b.getCalories();
                user.setCalorieTotal(breakfastTotal);
                System.out.println("You have " + user.getCalorieGoal() + " calories left.");
                entryPrompt();

            } else if (food == 2) {
                l = enterLunch();
                int newCalorieGoal =  user.getCalorieGoal() - l.getCalories();
                user.setCalorieGoal(newCalorieGoal);
                int lunchTotal = user.getCalorieTotal() + l.getCalories();
                user.setCalorieTotal(lunchTotal);
                System.out.println("You have " + user.getCalorieGoal() + " calories left.");
                entryPrompt();

            } else if (food == 3) {
                d = enterDinner();
                int newCalorieGoal =  user.getCalorieGoal() - d.getCalories();
                user.setCalorieGoal(newCalorieGoal);
                int dinnerTotal = user.getCalorieTotal() + d.getCalories();
                user.setCalorieTotal(dinnerTotal);
                System.out.println("You have " + user.getCalorieGoal() + " calories left.");
                entryPrompt();
            }
    }

    /**
     * prompts user to enter information about the breakfast he/she ate
     * @return new Breakfast
     */
    private static Entry enterBreakfast() {
        System.out.println("\nBreakfast");
        System.out.print("Name: ");
        String meal = sc.next();
        System.out.print("Calories: ");
        int calories = sc.nextInt();
        return b = new Breakfast (meal, calories);
    }

    /**
     * prompts user to enter information about the lunch he/she ate
     * @return new Lunch
     */
    private static Entry enterLunch() {
        System.out.println("\nLunch");
        System.out.print("Name: ");
        String meal = sc.next();
        System.out.print("Calories: ");
        int calories = sc.nextInt();
        return new Lunch(meal, calories);
    }

    /**
     * prompts user to enter information about the dinner he/she ate
     * @return new Dinner
     */
    private static Entry enterDinner() {
        int calories;
        System.out.println("\nDinner");
        System.out.print("Name: ");
        String meal = sc.next();
        System.out.print("Calories: ");
        calories = sc.nextInt();
        return new Dinner(meal, calories);
    }

    /**
     * calculates and prints out how many calories were eaten in total
     * prints out how many calories are left over
     */

    public static void summary() {
        System.out.println("Your goal today was " + (user.getCalorieTotal() + user.getCalorieGoal()) + " calories.");
        System.out.println("You have eaten " + user.getCalorieTotal() + " calories today!");
        System.out.println("You have " + user.getCalorieGoal() + " calories left.");
    }

    /**
     *concludes app
     */
    public static void end() {
       System.out.println("Thank you " + user + " for using Brian's Calorie Tracker!");
       System.exit(0);
    }
}
