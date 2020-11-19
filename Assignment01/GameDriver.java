/**
 * This program is a game where Players battle there monsters. There is a CPU
 * Player and a Human Player both with one monster who fight until the other
 * player's monster is defeated. The players participate in turn based combat
 * for victory. The Human Player is controlled by the users inputs and the CPU
 * Player has randomly generated moves.
 * 
 * The monsters have stats like speed, attack, defense and levelup. Speed
 * determines which monster attacks first. Attack is a basic attack damage added
 * onto the move power every turn. Defense is the damage reduction of the
 * monster. Levelup is the chance the move the player selected activates it's buff
 * or debuff.
 * 
 * Each monster has 4 moves with a Name, type, power, accuracy and critchance.
 * The type determines what debuff or buff players get when ur ability levels up
 * that turn. Power is move damage. Accuracy is chance the move hits target.
 * Critchance is the chance the move hits critically.
 *
 * @author Andrew Murdoch
 * @version 1.0
 * @since 2019-10-20
 */

public class GameDriver {
    public static void main(String[] args) {
        Move move1 = new Move("Vine Whip", "Grass", 45, 1.0f, 0.10f);
        Move move2 = new Move("Tackle", "Normal", 50, 1.0f, 0.10f);
        Move move3 = new Move("Take Down", "Normal", 90, 0.85f, 0.10f);
        Move move4 = new Move("Razor Leaf", "Grass", 55, 0.95f, 0.20f);
        Monster monster = new Monster("Bulbasaur", "Grass", 0.5f, 750, 45, 49, 49, move1, move2, move3, move4);
        Player player = new HumanPlayer(monster);
        move1 = new Move("Scratch", "Normal", 40, 1.0f, 0.10f);
        move2 = new Move("Ember", "Fire", 40, 1.0f, 0.10f);
        move3 = new Move("Peck", "Flying", 35, 1.0f, 0.10f);
        move4 = new Move("Fire Spin", "Fire", 35, 0.85f, 0.10f);
        monster = new Monster("Torchic", "Fire", 0.5f, 750, 40, 60, 40, move1, move2, move3, move4);
        Player enemy = new CPUPlayer(monster);
        while ((!player.hasLost()) && (!enemy.hasLost())) {
            // print both monsters' HP
            System.out.println("-------------------------------------\n");
            System.out.printf("%s has %d HP\n", player.getMonster().getName(), player.getMonster().getHP());
            System.out.printf("%s has %d HP\n", enemy.getMonster().getName(), enemy.getMonster().getHP());

            // decide the next move
            int playerMove = player.chooseMove();
            int enemyMove = enemy.chooseMove();

            // Print the oppponents move
            System.out.print("Your opponent's selected move is " + enemy.getMonster().moves[enemyMove].name + ".\n");
            System.out.println("\nBattle Log:\n");

            // Apply buffs and debuffs
            player.flying();
            enemy.flying();
            player.fire();
            enemy.fire();

            /**
             * This if else statement below applies basic attack and power damage each turn.
             * It checks which monster is faster and makes sure they're not stunned.
             */
            if (player.isFasterThan(enemy)) {
                if (player.stunned() != true) {
                    player.attack(enemy, playerMove);
                }
                if (!enemy.hasLost() && enemy.stunned() != true) {
                    enemy.attack(player, enemyMove);
                }
            } else {
                if (enemy.stunned() != true) {
                    enemy.attack(player, enemyMove);
                }
                if (!player.hasLost() && player.stunned() != true) {
                    player.attack(enemy, playerMove);
                }
            }

            // Resets values for next turn
            player.Stunned = false;
            enemy.Stunned = false;
            if (player.Flying == true) {
                player.getMonster().speed = player.getMonster().speed - 20;
                player.Flying = false;
            }
            if (enemy.Flying == true) {
                enemy.getMonster().speed = enemy.getMonster().speed - 20;
                enemy.Flying = false;
            }
            // Call moveType function to check move Type
            player.moveType(playerMove, enemy);
            enemy.moveType(enemyMove, player);

        }
        System.out.println("-------------------------------------\n");

        if (player.hasLost()) {
            System.out.printf("You and %s have lost the battle.\n", player.getMonster().getName());
        } else {
            System.out.printf("You and %s are victorious!\n", player.getMonster().getName());
        }
    }
}
