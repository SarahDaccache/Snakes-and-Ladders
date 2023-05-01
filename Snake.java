/**
 * The class Snake creates snake objects and holds its attributes,
 * which are its name, head and tail.
 *
 * @author Sarah Daccache 40246708
 */
public class Snake {

    int head, tail;
    String name;


    public Snake(){

    }

    /**
     *
     * @param head posiion of snake's head on the board
     * @param tail position of snake's tail on the board
     * @param name name of the snake, to differentiate them on the board
     */
    public Snake(int head, int tail, String name){
        this.head = head;
        this.tail = tail;
        this.name = name;

    }

    /**
     *
     * @param head sets position of head on board
     */
    public void setHead(int head) {
        this.head = head;
    }

    /**
     *
     * @param tale sets position of tail on board
     */
    public void setTale(int tale) {

        this.tail = tale;
    }

    /**
     *
     * @return position of head on board
     */
    public int getHead() {

        return head;
    }

    /**
     *
     * @return position of tail on board
     */
    public int getTail() {

        return tail;
    }


    /**
     *
     * @return name of snake
     */
    public String getName() {

        return name;
    }

    /**
     *
     * @param name name of snake
     */
    public void setName(String name) {
        this.name = name;
    }

}
