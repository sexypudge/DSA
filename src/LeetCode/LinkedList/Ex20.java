package LeetCode.LinkedList;

import java.util.Stack;

public class Ex20 {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> characterStack = new Stack<>();

        for (char c : chars) {
            // If the character is an opening bracket, push it onto the stack
            if (c == '(' || c == '[' || c == '{') {
                characterStack.push(c);

            } else { // If the character is a closing bracket

                // If the stack is empty, there is no matching opening bracket, so return false
                if (characterStack.isEmpty()) {
                    return false;
                }

                // Otherwise, get the top of the stack and check if it's the matching opening bracket
                if (c == ')' && characterStack.pop() != '(') {
                    return false;
                }

                if (c == ']'  && characterStack.pop() != '[') {
                    return false;
                }

                if (c == '}'  && characterStack.pop() != '{') {
                    return false;
                }
            }
        }

        // If the stack is empty, all opening brackets have been closed, so return true
        // Otherwise, there are unmatched opening brackets, so return false
        return characterStack.isEmpty();
    }
}
