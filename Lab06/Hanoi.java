public class Hanoi {
    public static void main(String[] args) {
        System.out.println("Towers of Hanoi:");
        solveHanoi(1, 3, 2, 4);
    }

    public static void move1(int source, int dest) {
        System.out.printf("Move top ring from %d to %d.\n", source, dest);
    }

    public static void solveHanoi(int source, int dest, int aux, int numDisk) {
        if (numDisk == 1) {
            move1(source, dest);
        } else {
            solveHanoi(source, aux, dest, numDisk - 1);
            move1(source, dest);
            solveHanoi(aux, dest, source, numDisk - 1);
        }
    }
}