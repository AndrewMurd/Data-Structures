
/**
 * CPUPlayer Class is subclass of Player. This class is a Player with randomly
 * generated moves.
 */
class CPUPlayer extends Player {
    public Monster monster;

    public CPUPlayer(Monster monster) {
        this.monster = monster;
    }

    /**
     * This method is used for accessing monster from Player Class.
     */
    public Monster getMonster() {
        return monster;
    }

    /**
     * This method determines which move the CPUPlayer makes, by randomly generating
     * an int.
     * 
     * @return random integer between 0 and 3.
     */
    public int chooseMove() {
        // Generating random int between 0 and 3
        int selection = (int) (Math.random() * ((3 - 0) + 1)) + 0;
        return selection;
    }
}