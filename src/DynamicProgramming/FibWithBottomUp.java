package DynamicProgramming;

public class FibWithBottomUp {

    static int counter = 0;

    public static int fib(int n) {
        counter++;

        int[] fibList = new int[n + 1];
        fibList[0] = 0;
        fibList[1] = 1;

        // n is index,
        for (int i = 2; i <= n; i++) { // we are finding value of index n so we use <=
            fibList[i] = fibList[i - 1] + fibList[i - 2];
        }

        return fibList[n];
    }

    public static int fibWithoutList(int n) {
        counter++;

        int first = 0;
        int second = 1;

        // n is index,
        for (int i = 2; i <= n; i++) { // we are finding value of index n so we use <=
            second = second + first;
            first = second - first;
        }

        return second;
    }

    public static void main(String[] args) {
        int n = 7;
//        System.out.println(fib(n));
        System.out.println(fibWithoutList(n));
        System.out.println(counter);
//        System.out.println(counter);
    }
}
