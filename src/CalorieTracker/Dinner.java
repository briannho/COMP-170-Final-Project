//Brian Ho
package CalorieTracker;

/**
 * creates dinner entry
 */
public class Dinner extends Breakfast {


    /**
     * default constructor of breakfast
     */
    public Dinner() {
        this ("no name", 0);
    }

    /**
     * constructs the dinner
     * @param meal name of meal (ex. Apple)
     * @param calories amount of calories in that meal
     */
    public Dinner ( String meal, int calories) {
        super (meal, calories);
    }
}
