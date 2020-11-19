/**
 * Abstract Class Player. A Player can be a CPUPlayer and HumanPlayer.
 */

public abstract class Player {
    int turns; // Tracks number of turn burn damage is applied
    boolean Stunned; // Tracks if player is stunned
    boolean Flying; // Tracks if player has increased speed

    /**
     * Choosing Move for Player.
     */
    public abstract int chooseMove();

    /**
     * Getting monster variable
     */
    public abstract Monster getMonster();

    /**
     * This method applies the flying buff
     */
    public void flying() {
        if (this.Flying == true) {
            this.getMonster().speed = this.getMonster().speed + 20; // Adding 20 speed to monster
        }
    }

    /**
     * This method checks if the person will be stunned this turn.
     */
    public boolean stunned() {
        if (this.Stunned == true) {
            System.out.println(this.getMonster().getName() + " has been stunned!");
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method applies the burn damage to the enemy.
     */
    public void fire() {
        if (this.turns > 0) {
            this.getMonster().hp = this.getMonster().hp - 15; // Apply burn damage
            System.out.println(this.getMonster().getName() + " took 15 burn damage!");
            turns--; // Update number of remaining turns
        }
    }

    /**
     * This method checks if the player has lost the game by simply checking weather
     * hp is less then or equal to zero.
     */
    public boolean hasLost() {
        return getMonster().hp <= 0;
    }

    /**
     * This method determines which player's monster is faster by comparing speeds
     * of each monster.
     */
    public boolean isFasterThan(Player player) {
        return this.getMonster().speed > player.getMonster().speed;
    }

    /**
     * This method determines how the move selected by the players affects the game.
     * First we check wether the players ability will level up. Meaning the type of
     * the move comes into affect.
     * 
     * Flying increases the speed of the next move. Fire applies burn damage over 4
     * turns. Grass stuns the target next turn.
     */
    public void moveType(int playerMove, Player enemy) {
        Move move = this.getMonster().moves[playerMove];
        double num = Math.random();
        /**
         * Switch case to get what type of move the player choose and set the correct
         * buff or debuff.
         */
        if (num <= getMonster().levelUp) {
            switch (move.type) {
            case "Fire":
                enemy.turns = 4;
                break;
            case "Flying":
                this.Flying = true;
                System.out.println(this.getMonster().Name + " next attack will have increased speed!");
                break;
            case "Grass":
                enemy.Stunned = true;
                break;
            default:
                break;
            }
        }
    }

    /**
     * This method is used to calculate and output monster attacks. First is
     * determines which move the player has selected. It then checks weather the
     * attack is going to successfully land based uppon the accuracy of the move. If
     * the attack landed it calculates the damage the move is going to deal taking
     * into account the chance of critical hit.
     *
     * The damage is calculated using this formula: damageDealt = attacking
     * monster's attack stat + attacking monster move's power - defending monster's
     * defense stat Else it prints that the attack missed and the game proceeds.
     */
    public void attack(Player enemy, int playerMove) {
        // Getting players move from array of moves
        Move move = this.getMonster().moves[playerMove];
        // Generating Random double between 0 - 1
        double num = Math.random();

        if (num <= move.accuracy) {
            // Calculating Damage dealt
            int damageDealt = (this.getMonster().attack + move.power) - enemy.getMonster().defense;
            // checking if monster hit critically
            if (num <= move.critChance) { // critical hits double power of attack
                damageDealt = (this.getMonster().attack + (move.power * 2)) - enemy.getMonster().defense;
                System.out.println(this.getMonster().getName() + " made a critical hit!!!");
            }
            // Calculating hp value of damage
            enemy.getMonster().hp = enemy.getMonster().hp - damageDealt;
            // Outputing Damage dealt to monster
            System.out.println(this.getMonster().getName() + " did " + damageDealt + " damage to "
                    + enemy.getMonster().getName() + ".");
        } else {
            System.out.println(this.getMonster().getName() + "'s attack was missed!");
        }
    }
}
