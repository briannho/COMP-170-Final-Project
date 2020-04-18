//Brian Ho
package CalorieTracker;

/**
 * methods called here if user is male
 */
public class MaleUser extends FemaleUser  {

    /**
     * calculates how many calories user should consume to maintain weight
     */
    public static void maintainWeight() {
        calorieGoal = (int) ((10 * weight) + (6.25 * height) - (5 * age) + 5);
    }

    /**
     * calculates how many calories user should consume to gain weight
     */
    public static void gainWeight() {
        calorieGoal = (int) (((10 * weight) + (6.25 * height) - (5 * age) + 5) + 500);

    }

    /**
     * calculates how many calories user should consume to lose weight
     */
    public static void loseWeight() {
        calorieGoal = (int) (((10 * weight) + (6.25 * height) - (5 * age) + 5) - 500);

    }

}
