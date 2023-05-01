import java.util.Scanner;

public class PlayLadderAndSnake {

    public static void main(String[] args) {

        Scanner key = new Scanner(System.in);

        LadderAndSnake ladderAndSnake = new LadderAndSnake();

        Player player1 = new Player();
        Player player2 = new Player();
        int numOfPlayers;
        String name, in;
        int dice1 = 0, dice2 = 0;


        do {

            System.out.println();
            System.out.println(ConsoleColors.YELLOW_BOLD
                    + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
                    + "~~~~~~~~~~~~~~~~~\n" + ConsoleColors.RESET + ConsoleColors.ORANGE + "                    Welcome to the ULTI"
                    + "MATE" + " Ladder And Snake game!" + ConsoleColors.RESET + ConsoleColors.YELLOW_BOLD +
                    "\n~~~~~~~~~~~~~~~~~~~~~" + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" +
                    "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" + ConsoleColors.RESET);
            System.out.println("Ready to see how far your luck can get you? Climb your way up the LONG ladders and avoid at\n"
                    + "ALL COST the SNAKES that will drag you down. Let's see how FAST you can get to the top!");

            do {
                System.out.println("\t\t\t\t\t\t\t\t(ENTER \"GO\" TO BEGIN)");
                in = key.next();

            } while (!in.toUpperCase().equals("GO"));


            System.out.println();
            System.out.print("Let's get started! This game is played by 2 players at a time. Enter number of players: ");

            numOfPlayers = key.nextInt();

            ladderAndSnake.setNumOfPlayers(numOfPlayers);


            // Game starts
            ladderAndSnake.play();

        } while (in.toUpperCase().equals("GO"));


        System.exit(0);

        key.close();


    }

}
