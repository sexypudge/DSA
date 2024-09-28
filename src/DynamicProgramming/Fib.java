package DynamicProgramming;

public class Fib {
    static int counter = 0;

    public static int fib(int n) {
        counter++;
        if (n == 0 || n == 1) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        int n = 20;
        System.out.println(fib(n));
        System.out.println(counter);
    }
}