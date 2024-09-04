package StackNQueue;

import java.util.ArrayList;

public class Ex1Stack<T> {
    private ArrayList<T> stackList = new ArrayList<>();

    public ArrayList<T> getStackList() {
        return stackList;
    }

    public void printStack() {
        for (int i = stackList.size() - 1; i >= 0; i--) {
            System.out.println(stackList.get(i));
        }
    }

    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return stackList.get(stackList.size() - 1);
        }
    }

    public int size() {
        return stackList.size();
    }

    /**
     * The add method of ArrayList is used to add the value to the end of the ArrayList,
     * which corresponds to the top of the stack.
     *
     * @param value
     */
    public void push(T value) {
        stackList.add(value);
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }

        return stackList.remove(size() - 1);
    }

    public static String reverseString(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }

        Ex1Stack<Character> stack = new Ex1Stack<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            stack.push(c);
        }

        char[] reversedChars = new char[stack.size()];
        for (int i = 0; i <= str.length() - 1; i++) {
            reversedChars[i] = stack.pop();
        }
        return String.valueOf(reversedChars);
    }

    public static boolean isBalancedParenthesesMySolution(String testStr) {
        Ex1Stack<Character> stack = new Ex1Stack<>();
        char[] chars = testStr.toCharArray();
        for (char c : chars) {
            stack.push(c);
        }

        int numberOfOpen = 0;
        int numberOfClose = 0;
        for (int i = 0; i <= testStr.length() - 1; i++) {
            char character = stack.pop();
            if (character == ')') {
                numberOfClose++;
            }

            if (character == '(') {
                numberOfOpen++;
            }

            if (i == 0
                    && character != ')') {
                return false;
            }

            if (i == testStr.length() - 1
                    && character != '(') {
                return false;
            }
        }

        return numberOfOpen == numberOfClose;
    }

    public static boolean isBalancedParentheses(String parentheses) {
        Ex1Stack<Character> stack = new Ex1Stack<>();
        for (char p : parentheses.toCharArray()) {
            if (p == '(') {
                stack.push(p);
            } else if (p == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
//        int[] a = new int[] {1,4,5,6,7};
//        int[] b = new int[6] ;
//        b[0] = 0;
//        System.arraycopy(a, 0,  b, 1, a.length);
//        System.out.println(Arrays.toString(b));
//        Ex1Stack stack = new Ex1Stack();
//        stack.push("abc");
//        stack.push("bbb");
//        stack.push(1);
//        stack.printStack();

        String reversed = reverseString("hello");
        boolean isBalancedParentheses = isBalancedParenthesesMySolution("())(()");
    }
}
