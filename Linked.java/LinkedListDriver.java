public class LinkedListDriver {
    public static void main(String[] args) {
        LinkedList list = new SortedDoublyLinkedList();

        System.out.println(list);
        Warrior krogg = new Warrior("Krogg", 30, 50, 200);
        list.insert(krogg);

        System.out.println(list);
        Warrior gurkh = new Warrior("Gurkh", 40, 45, 180);
        list.insert(gurkh);

        System.out.println(list);
        Warrior brynn = new Warrior("Brynn", 45, 40, 190);
        list.insert(brynn);

        System.out.println(list);
        Warrior dolf = new Warrior("Dolf", 20, 65, 210);
        list.insert(dolf);

        System.out.println(list);
        Warrior zuni = new Warrior("Zuni", 50, 35, 170);
        list.insert(zuni);

        System.out.println(list);
    }
}

class Warrior {
    private String name;
    private int speed;
    private int strength;
    private int hp; 

    public Warrior(String name, int speed, int str, int hp) {
        this.name = name;
        this.speed = speed;
        this.strength = str;
        this.hp = hp;
    }

    public String getName() {
        return this.name;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getStrength() {
        return this.strength;
    }

    public int getHp() {
        return this.hp;
    }

    public String toString() {
        return this.name + "(" + this.speed + ")";
    }
}
