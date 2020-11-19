import java.util.Scanner;

/**
 * HumanPlayer Class is subclass of Player. This class is a Player user input
 * for selected moves.
 */
class HumanPlayer extends Player {
    public Monster monster;

    public HumanPlayer(Monster monster) {
        this.monster = monster;
    }

    /**
     * This method is used for accessing monster from Player Class.
     */
    public Monster getMonster() {
        return monster;
    }

    /**
     * This method allows user to selected a move. A input Scanner is used to
     * revceive input.
     */
    public int chooseMove() {
        // Creating a Scanner to read user input
        Scanner in = new Scanner(System.in);
        // Outputing available moves
        System.out.println("\nYour Monsters Moves:");
        for (int i = 1; i < 5; i++) {
            System.out.println(
                    "Move " + i + ": " + this.monster.moves[i - 1].name + " - " + this.monster.moves[i - 1].type);
            System.out.println("Power - " + this.monster.moves[i - 1].power + " Critical hit chance - "
                    + (this.monster.moves[i - 1].critChance * 100) + "% Accuracy - " + (this.monster.moves[i - 1].accuracy * 100) + "%\n");
        }
        System.out.println("Select a move (1-4): ");
        int selection = in.nextInt();
        // Returning selected move
        return selection - 1;
    }
}
