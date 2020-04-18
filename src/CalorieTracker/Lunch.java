//Brian Ho
package CalorieTracker;

/**
 * creates lunch entry
 */
public class Lunch extends Breakfast {


    /**
     * default constructor of lunch
     */
    public Lunch() {
        this ("no name", 0);
    }

    /**
     * constructs the lunch
     * @param meal name of meal (ex. Apple)
     * @param calories amount of calories in that meal
     */
    public Lunch ( String meal, int calories) {
        super (meal, calories);
    }
}
