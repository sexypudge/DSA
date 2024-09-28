package DynamicProgramming;

public class FibWithMemo {
    static int counter = 0;
    static Integer[] memo;

    public static int fib(int n) {
        counter++;
        if (memo[n] != null) {
            return memo[n];
        }

        if (n == 0 || n == 1) {
            return n;
        }

        memo[n] = fib(n - 1) + fib(n - 2);
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 20;
        memo = new Integer[n + 1];
        System.out.println(fib(n));
        System.out.println(counter);
    }
}
