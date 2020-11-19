public class Fib {
    public static int count = 0;

    public static int fibonacciRec(int n) {
        if (n <= 1) {
            return n;
        }
        count++;
        return fibonacciRec(n - 1) + fibonacciRec(n - 2);
    }

    static int fibonacciIter(int n) {
        int f[] = new int[n + 2];
        int i;

        f[0] = 0;
        f[1] = 1;

        for (i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
            count++;
        }
        return f[n];
    }

    public static int getCallCount() {
        return count;
    }

    public static void resetCallCount() {
        count = 0;
    }

    public static void main(String[] args) {
        System.out.println("Fibonacci:");
        int n = 15;
        resetCallCount();
        int recursiveResult = fibonacciRec(n);
        int recursiveCalls = getCallCount();
        System.out.printf("Recursive result: %d (%d recursive calls)\n", recursiveResult, recursiveCalls);
        resetCallCount();
        int iterativeResult = fibonacciIter(n);
        int iterations = getCallCount();
        System.out.printf("Iterative result: %d (%d iterations)\n", iterativeResult, iterations);
    }
}