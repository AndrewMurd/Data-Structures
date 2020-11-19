/**
 * The Monster constructs the players monster's. It determines there stats of
 * the monster.
 */

public class Monster {
    String Name; // monster name
    String Type; // moster type
    int hp; // remaining health
    int speed; // speed of attack
    int attack; // Base attack
    int defense; // defense stat
    float levelUp; // Chance of level up
    Move move1;
    Move move2;
    Move move3;
    Move move4;
    Move[] moves = new Move[4]; // Array of available moves

    public Monster(String Name, String Type, float levelUP, int hp, int speed, int attack, int defense, Move move1,
            Move move2, Move move3, Move move4) {
        this.Name = Name;
        this.Type = Type;
        this.levelUp = levelUP;
        this.hp = hp;
        this.speed = speed;
        this.attack = attack;
        this.defense = defense;
        this.move1 = move1;
        this.move2 = move2;
        this.move3 = move3;
        this.move4 = move4;
        moves[0] = move1;
        moves[1] = move2;
        moves[2] = move3;
        moves[3] = move4;
    }

    // Getting Name and HP values
    public String getName() {
        return Name;
    }

    public int getHP() {
        return hp;
    }
}