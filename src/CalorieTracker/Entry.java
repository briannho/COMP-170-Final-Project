//Brian Ho
package CalorieTracker;

/**
 * defines requirements for type of meal
 */
public interface Entry {

    /**
     * sets the name of the meal user has eaten (ex. Apple)
     * @param meal name of meal
     */
    void setMeal(String meal);

    /**
     * returns the name of the meal
     * @return name of meal
     */
    String getMeal();

    /**
     * sets the amount of calories in that particular meal
     * @param calories calories in particular meal
     */
    void setCalories(int calories);

    /**
     * returns the amount of calories in that particular meal
     * @return calories in particular meal
     */
    int getCalories();
}
