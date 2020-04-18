//Brian Ho
package CalorieTracker;

/**
 * class that builds user's profile
 */
public class Profile {

    private String name;
    protected static int age;
    protected static double weight;
    protected static double height;
    protected static int calorieGoal;
    private int calorieTotal;

    /**
     * default constructor of profile
     */
    public Profile () {
        this ("No name", 0, 0.0, 0.0);
    }

    /**
     * constructs the user's profile
     * overloads default constructor
     * @param name user's name
     * @param age user's age
     * @param weight user's weight
     * @param height user's height
     */
    public Profile(String name, int age, double weight, double height) {
        setName(name);
        setAge(age);
        setWeight(weight);
        setHeight(height);
    }

    /**
     * sets the name of the user
     * @param name user's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * returns the name of the user
     * @return user's name
     */
    public String getName() {
        return name;
    }

    /**
     * sets the age of the user
     * ensures the age is greater than 0
     * @param age user's age
     */
    public void setAge(int age) {
        if (age < 0) {
            System.out.println("You must enter an integer greater than 0");
        }
        this.age = age;
    }

    /**
     * returns the age of the user
     * @return user's age
     */
    public int getAge() {
        return age;
    }

    /**
     * sets the weight of the user
     * ensures the weight is greater than 0
     * @param weight user's weight
     */
    public void setWeight(double weight) {
        if (weight < 0) {
            System.out.println("You must enter a value greater than 0");
        }
        this.weight = weight;
    }

    /**
     * returns the weight of the user
     * @return user's weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * sets the height of the user
     * ensures the height is greater than 0
     * @param height user's height
     */
    public void setHeight(double height) {
        if (height < 0) {
            System.out.println("You must enter a value greater than 0");
        }
        this.height = height;
    }

    /**
     * returns the height of the user
     * @return user's height
     */
    public double getHeight() {
        return height;
    }

    /**
     * sets the calorie goal of user
     * informs user if he/she has consumed more calories than the calorie goal
     * @param calorieGoal calorie goal
     */
    public void setCalorieGoal(int calorieGoal) {
        this.calorieGoal = calorieGoal;
        if (calorieGoal < 0) {
            System.out.println("You have gone over your goal for today!");
        }
    }

    /**
     * returns user's calorie goal
     * @return calorieGoal
     */
    public int getCalorieGoal() {
        return calorieGoal;
    }

    /**
     * sets the total amount of calories consumed
     * @param calorieTotal total calories eaten
     */
    public void setCalorieTotal(int calorieTotal) {
       this.calorieTotal = calorieTotal;
    }

    /**
     * returns the total amount of calories consumed
     * @return calorieTotal
     */
    public int getCalorieTotal() {
        return calorieTotal;
    }

    /**
     * prints information about the user
     */
    public void printDetails() {
        System.out.println("\tage: " + getAge() + " years old");
        System.out.println("\tweight: " + getWeight() + " kg");
        System.out.println("\theight: " + getHeight() + " cm");
        System.out.println("\tcalorie goal: " + getCalorieGoal() + " calories");

    }

    public String toString() {
        return getName();
    }
}
