/**
 * The Move class outlines the parameters for a monster's moves
 */

public class Move {
    String name;
    String type; // type of move
    int power; // damage of move
    float accuracy; // chance of hit
    float critChance; // critical hit chance

    public Move(String name, String type, int power, float accuracy, float critChance) {
        this.name = name;
        this.type = type;
        this.power = power;
        this.accuracy = accuracy;
        this.critChance = critChance;
    }
}