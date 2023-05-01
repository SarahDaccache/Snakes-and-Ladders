/**
 * The class LadderAndSnake groups all methods needed for the Ladder And Snakes game to
 * function properly, such as the flipDice() method, which allows the user to flip a dice
 * in order to play the game. The method Play() is also present, and it is in this method
 * that all the rules and functioning of the game are. Snake, ladder and player objects are
 * created in this class. It is also in this class that the board of the game is created.
 *
 * @author Sarah daccache 40246708
 * @course Comp 249
 */

import java.util.Scanner;
public class LadderAndSnake {


    int numOfPlayers;

    //Create two players for the game
    Player player1 = new Player();
    Player player2 = new Player();


    //Create snake objects and set their position and name to differentiate them
    Snake s1 = new Snake(16, 6, "S1");
    Snake s2 = new Snake(79, 19, "S2");
    Snake s3 = new Snake(95, 24, "S3");
    Snake s4 = new Snake(48, 30, "S4");
    Snake s5 = new Snake(64, 60, "S5");
    Snake s6 = new Snake(93, 68, "S6");
    Snake s7 = new Snake(97, 76, "S7");
    Snake s8 = new Snake(98, 78, "S8");

    //create ladder objects and set their position and name to differentiate them
    Ladders l1 = new Ladders(38, 1, "L1");
    Ladders l2 = new Ladders(14, 4, "L2");
    Ladders l3 = new Ladders(31, 9, "L3");
    Ladders l4 = new Ladders(42, 21, "L4");
    Ladders l5 = new Ladders(84, 28, "L5");
    Ladders l6 = new Ladders(44, 36, "L6");
    Ladders l7 = new Ladders(67, 51, "L7");
    Ladders l8 = new Ladders(91, 71, "L8");
    Ladders l9 = new Ladders(100, 80, "L9");


    //Create 2D array board
    static String[][] board = new String[10][10];


    public LadderAndSnake() {

    }

    /**
     *
     * @param numOfPlayers number of players for the game
     */
    public LadderAndSnake(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }

    /**
     *
     * @return random odd numbers between 1 and 6
     */
    public int flipDice() {
        return ((int) (1 + Math.random() * (6)));
    }

    /**
     *
     * @param s input of the user
     * @return boolean to determine if to start the game or not
     */
    public static boolean start(String s) {

        if (s.equals("GO")) {
            return true;
        } else
            return false;

    }

    /**
     *
     * @param s adds snake objects to the board according to their position
     */
    public void addSnakes(Snake s) {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) { //iterating throughout the board
                //checking for board numbers that correspond to snake head
                // positions and adding them
                if ((board[i][j].trim()).equals(Integer.toString(s.getHead()))) {
                    s.setHead(Integer.parseInt(board[i][j].trim()));
                    if (!((board[i][j].trim()).equals(Integer.toString(player1.getPosition()))) &&
                            !((board[i][j].trim()).equals(Integer.toString(player2.getPosition())))) {
                        board[i][j] = ConsoleColors.BLACK + ConsoleColors.GREEN_BACKGROUND + "\t" + s.getName()
                                + "\t" + ConsoleColors.RESET;
                    }
                }
                //checking for board numbers that correspond to snake tail
                // positions and adding them
                if ((board[i][j].trim()).equals(Integer.toString(s.getTail()))) {
                    s.setTale(Integer.parseInt(board[i][j].trim()));
                    if (!((board[i][j].trim()).equals(Integer.toString(player1.getPosition()))) &&
                            !((board[i][j].trim()).equals(Integer.toString(player2.getPosition())))) {
                        board[i][j] = ConsoleColors.BLACK + ConsoleColors.GREEN_BACKGROUND + "\t" + s.getName()
                                + "\t" + ConsoleColors.RESET;

                    }
                }
            }


        }
    }

    /**
     *
     * @param l adds ladder objects according to their position on the board
     */
    public static void addLadders(Ladders l) {

        for (int i = 0; i < 10; i++) { //row
            for (int j = 0; j < 10; j++) {
                //checking for board numbers that correspond to ladder top
                // positions and adding them
                if ((board[i][j].trim()).equals(Integer.toString(l.getTop()))) {
                    l.setTop(Integer.parseInt(board[i][j].trim()));
                    board[i][j] = ConsoleColors.BLACK + ConsoleColors.PURPLE_BACKGROUND + "\t" + l.getName()
                            + "\t" + ConsoleColors.RESET;

                }
                //checking for board numbers that correspond to ladder bottom
                // positions and adding them
                if ((board[i][j].trim()).equals(Integer.toString(l.getBottom()))) {
                    l.setBottom(Integer.parseInt(board[i][j].trim()));
                    board[i][j] = ConsoleColors.BLACK + ConsoleColors.PURPLE_BACKGROUND + "\t" + l.getName()
                            + "\t" + ConsoleColors.RESET;

                }
            }
        }
    }

    /**
     *
     * @param s Snake object. Drags down the player to the tail of the snake
     *          if player steps on his head
     */
    public void down(Snake s) {
        //If the player's position is on a snake's head, set his position to the
        // tail of that same snake
        if (player1.getPosition() == s.getHead()) {
            player1.setPosition(s.getTail());
            System.out.println(ConsoleColors.RED_BOLD + "Oh no! " + player1.getName() +
                    " stepped on a snake! Sliding down to the end " +
                    "of its tail." + ConsoleColors.RESET);
        }
        if (player2.getPosition() == s.getHead()) {
            player2.setPosition(s.getTail());
            System.out.println(ConsoleColors.RED_BOLD +"Oh no! " + player2.getName() +
                    " stepped on a snake! Sliding down to the end " +
                    "of its tail." + ConsoleColors.RESET);
        }
    }

    /**
     *
     * @param l Ladder object. Brings up the player to the top of the ladder
     *             if player steps on the bottom.
     */
    public void up(Ladders l) {
        //If the player's position is on a ladder's bottom, set his position to the
        // top of that same ladder
        if (player1.getPosition() == l.getBottom()) {
            player1.setPosition(l.getTop());
            System.out.println(ConsoleColors.GREEN_BOLD + "Lucky! " + player1.getName() +
                    " found a ladder! Climbing up to the top of the ladder." + ConsoleColors.RESET);
        }
        if (player2.getPosition() == l.getBottom()) {
            player2.setPosition(l.getTop());
            System.out.println("Lucky! " + player2.getName() +
                    " found a ladder! Climbing up to the top of the ladder." + ConsoleColors.RESET);
        }
    }

    /**
     * Created the board where snake, ladders and players will be.
     */
    public void Board() {

        // Numerate the board
        int counter = 100;
        for (int i = 0; i < 10; i++) { //row

            for (int j = 0; j < 10; j++) {

                if (i % 2 == 0) {

                    board[i][j] = "\t" + counter-- + "\t";

                } else {
                    for (int k = 9; k >= 0; k--) {
                        board[i][k] = "\t" + counter-- + "\t";

                    }
                    break;
                }
            }
        }

        //Display player's name on the board according to his position
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                //trim() to take only the numbers of the board. Convert the player's position to
                //a string value to compare it to the string value of the board. If values are the same,
                //print the player's name instead of the square number on the board
                if ((board[i][j].trim()).equals(Integer.toString(player2.getPosition()))) {
                    board[i][j] = ConsoleColors.BLACK_BOLD + ConsoleColors.BLUE_BACKGROUND + player2.getName() + "\t"
                            + ConsoleColors.RESET;
                }
                if ((board[i][j].trim()).equals(Integer.toString(player1.getPosition()))) {
                    board[i][j] = ConsoleColors.BLACK_BOLD + ConsoleColors.RED_BACKGROUND + player1.getName() + "\t"
                            + ConsoleColors.RESET;
                }

            }
        }
        //Add snakes and ladders to board
        addSnakes(s1);
        addSnakes(s2);
        addSnakes(s3);
        addSnakes(s4);
        addSnakes(s5);
        addSnakes(s6);
        addSnakes(s7);
        addSnakes(s8);

        addLadders(l1);
        addLadders(l2);
        addLadders(l3);
        addLadders(l4);
        addLadders(l5);
        addLadders(l6);
        addLadders(l7);
        addLadders(l8);
        addLadders(l9);


        //print board

        System.out.print(ConsoleColors.BLACK + ConsoleColors.ORANGE_BACKGROUND + "_____________________________"
                + "___________________________________________________" + ConsoleColors.RESET);
        for (int i = 0; i < 10; i++) { //row
            System.out.println("");

            for (int j = 0; j < 10; j++) {

                System.out.print(ConsoleColors.BLACK + ConsoleColors.ORANGE_BACKGROUND + "| " + board[i][j]
                        + ConsoleColors.RESET);
            }
            System.out.println();
            for (int j = 0; j < 10; j++) {
                System.out.print(ConsoleColors.BLACK + ConsoleColors.ORANGE_BACKGROUND + "|_______" + ConsoleColors.RESET);
            }
        }


    }

    /**
     * This is where the game interacts with the players and covers all
     * the rules and functions.
     */
    public void play() {
        Scanner key = new Scanner(System.in);
        Player temp = new Player();
        String in, name;
        int dice1 = 0, dice2 = 0;

        // Assigning names to players and restricting the length between 2 and 5
        // in order to fit in the board

        do {
            System.out.print("\nPlayer 1, enter your chosen nickname (must be between 2 and 5 letters): ");
            name = key.next();
        } while (!(name.length() > 1 && name.length() < 6));
        player1.setName(name); //setting player1's name

        do {
            System.out.print("\nPlayer 2, enter your chosen name (must be between 2 and 5 letters): ");
            name = key.next();
        } while (!(name.length() > 1 && name.length() < 6));
        player2.setName(name); //setting player2's name

        System.out.println(
                "\n\n------------------------------------------------------------------------------------------"
                        + "\n\nWelcome, " + player1.getName() + " and " + player2.getName() + "!");
        System.out.println("\nIt is time to determine who will start playing.");
        System.out.println(
                ConsoleColors.YELLOW + "\nIn order to flip the dice throughout the game, you will simply\nneed"
                        + " to enter \"f\".\n" + ConsoleColors.RESET);


        // deciding who will start

        do {
            do {
                System.out.print("Flip the dice!");
                in = key.next();
            } while (!in.equals("f"));

            dice1 = flipDice();
            System.out.println("\n" + player1.getName() + " got a dice value of " + player1.getDice(dice1));

            dice2 = flipDice();
            System.out.println(player2.getName() + " got a dice value of " + player2.getDice(dice2));

            if (dice1 > dice2) {
                System.out.println(player1.getName() + " goes first.\n ");
            } else if (dice2 > dice1) {
                System.out.println(player2.getName() + " goes first.\n ");
            } else {
                System.out.println("Tie! Attempting to break the tie");
            }

        }while(dice1 == dice2);

        // if player 2 gets to start, switch roles
        if (dice2 > dice1) {
            for (int j = 0; j < 10; j++)
                temp = player1;
            player1 = player2;
            player2 = temp;
        }

        do {
            do {
                //first player's turn
                System.out.print("\n" + player1.getName() + " flip the dice!");
                in = key.next();
            } while (!in.equals("f")) ;

            dice1 = flipDice();
            System.out.println("\n" + player1.getName() + " got a dice value of " + dice1); //dice value
            player1.setPosition(player1.getPosition() + dice1); //adding dice value to previous position

            //Checking for snakes and ladders
            down(s1);
            down(s2);
            down(s3);
            down(s4);
            down(s5);
            down(s6);
            down(s7);
            down(s8);

            up(l1);
            up(l2);
            up(l3);
            up(l4);
            up(l5);
            up(l6);
            up(l7);
            up(l8);
            up(l9);


            //if both players are on same square, switch position to player that was there
            //      //first to position 0
            if (player1.getPosition() == player2.getPosition()) {
                player2.setPosition(0);
                System.out.println("Both players are at the same square. " + player1.getName() + " kicks "
                        + player2.getName() + " out!\n" + player2.getName() + ", you're back to square 0");
            }
            //if player exceeds square 100, stop at 100 and bring it down by the number of movements left
            if (player1.getPosition() > 100) {
                System.out.println("Tile 100 was exceeded by " + (player1.getPosition() - 100) + ". ");
                System.out.println(player1.getName() + " moves back by " + (player1.getPosition() - 100) + "" +
                        " squares from the 100th tile.");
                player1.setPosition(100 - (player1.getPosition() - 100));

            }
            //if player reaches square 100, end the game
            if (player1.getPosition() == 100) {
                System.out.println(ConsoleColors.RED_BOLD + "\n\n\t\t\t\t\t\t GAME OVER!\n\n "
                        + ConsoleColors.RESET +
                        player1.getName() + " has reached the 100th tile!" +
                        " Congratulations," +
                        " you are\nthe official winner of the game! Do you wish to play again?\n\t\t\t\t\t(ENTER" +
                        " GO OR NO)\"");
                in = key.next();
                if (in.toUpperCase().equals("NO")) {
                    System.exit(0);
                } else continue;
            }

            //display position of the player
            if (player1.getPosition() != 100) {
                System.out.println(player1.getName() + " now located at square " + player1.getPosition()); //new position
                System.out.println();
                Board(); //display board


            }


            //second player's turn
            do {
                System.out.print("\n" + player2.getName() + " flip the dice!");
                in = key.next();
            } while(!in.equals("f"));

            dice1 = flipDice();
            System.out.println("\n" + player2.getName() + " got a dice value of " + dice1); //dice value
            player2.setPosition(player2.getPosition() + dice1); //adding dice value to previous position
            down(s1);
            down(s2);
            down(s3);
            down(s4);
            down(s5);
            down(s6);
            down(s7);
            down(s8);

            up(l1);
            up(l2);
            up(l3);
            up(l4);
            up(l5);
            up(l6);
            up(l7);
            up(l8);
            up(l9);

            if (player2.getPosition() == player1.getPosition()) { //if both players are on the same square
                player1.setPosition(0);
                System.out.println("Both players are at the same square. " + player2.getName() + " kicks "
                        + player1.getName() + " out!\n" + player1.getName() + ", you're back to square 0");
            }

            if (player2.getPosition() > 100) {
                System.out.println("Tile 100 was exceeded by " + (player2.getPosition() - 100) + ". ");
                System.out.println(player2.getName() + " moves back by " + (player2.getPosition() - 100) + "" +
                        " squares from the 100th stile.");
                player2.setPosition(100 - (player2.getPosition() - 100));

            }
            if (player2.getPosition() == 100) {
                System.out.println(ConsoleColors.RED_BOLD + "\n\n\t\t\t\t\t\t GAME OVER!\n\n" +
                        ConsoleColors.RESET + player2.getName() + " has reached the 100th tile! Congratulations," +
                        " you are\nthe official winner of the game! Do you wish to play again?\n\t\t\t\t\t(ENTER GO OR NO)");
                in = key.next();
                if (in.toUpperCase().equals("NO")) {
                    System.exit(0);
                } else continue;


            }

            if (player2.getPosition() != 100) {
                System.out.println(player2.getName() + " now located at square " + player2.getPosition()); //new position

                System.out.println();
                Board();

            }


        }
        while (player1.getPosition() < 100 && player2.getPosition() < 100);
    }


    /**
     *
     * @return number of players
     */
    public int getNumOfPlayers() {
        return numOfPlayers;
    }

    /**
     *
     * @param numOfPlayers number of players
     */
    public void setNumOfPlayers(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
        if (numOfPlayers > 2) {
            System.out.println("\nOups! " + numOfPlayers + " players is only available for an extended version of"
                    + " the game. The number will be set to 2.");
            numOfPlayers = 2; // setting number of players to 2 if it is 2 or more
        } else if (numOfPlayers < 2) {
            System.out.println("\nError: Cannot execute the game with less than 2 players! Will exit.");
            System.exit(0); //exiting the program if less than 2 players

        }
    }
}
