/**
 * The class Ladders creates ladder objects and holds its attributes,
 * which are its name, top position and bottom position.
 *
 * @author Sarah Daccache 40246708
 */
public class Ladders {

    int top, bottom;
    String name;


    public Ladders(){

    }

    /**
     *
     * @param top position of top of ladder on board
     * @param bottom position of bottom of ladder on board
     * @param name name of ladder
     */
    public Ladders(int top, int bottom, String name){
        this.top = top;
        this.bottom = bottom;
        this.name = name;
    }

    /**
     *
     * @return position of top of ladder on board
     */
    public int getTop() {

        return top;
    }

    /**
     *
     * @param top sets position of top of ladder on board
     */
    public void setTop(int top)
    {
        this.top = top;
    }

    /**
     *
     * @return position of bottom of ladder on board
     */
    public int getBottom() {

        return bottom;
    }

    /**
     *
     * @param bottom sets position of bottom of adder on board
     */
    public void setBottom(int bottom) {

        this.bottom = bottom;
    }

    /**
     *
     * @return name of ladder
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name Sets name of ladder
     */
    public void setName(String name) {


        this.name = name;
    }
}
