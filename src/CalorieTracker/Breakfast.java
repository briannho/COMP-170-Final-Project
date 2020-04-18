//Brian Ho
package CalorieTracker;

/**
 * creates breakfast entry
 */
public class Breakfast implements Entry {


    private String meal;
    private int calories;

    /**
     * default constructor of breakfast
     */
    public Breakfast() {
        this ("no name", 0);
    }

    /**
     * constructs the breakfast
     * @param meal name of meal (ex. Apple)
     * @param calories amount of calories in that meal
     */
    public Breakfast( String meal, int calories) {
        setMeal(meal);
        setCalories(calories);
    }

    /**
     * sets the name of the meal user has eaten (ex. Apple)
     * @param meal name of meal
     */
    public void setMeal(String meal) {
        this.meal = meal;
    }

    /**
     * returns the name of the meal
     * @return name of meal
     */
    public String getMeal() {
        return meal;
    }

    /**
     * sets the amount of calories in that particular meal
     * @param calories calories in particular meal
     */
    public void setCalories(int calories) {
       this.calories = calories;
    }

    /**
     * returns the amount of calories in that particular meal
     * @return calories in particular meal
     */
    public int getCalories() {
        return calories;
    }
}
