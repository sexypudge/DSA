package StackNQueue;

// -----------------------------------
public class Stack {

    private Node top;
    private int height;

    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public Stack(int value) {
        top = new Node(value);
        height = 1;
    }

    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getTop() {
        if (top == null) {
            System.out.println("Top: null");
        } else {
            System.out.println("Top: " + top.value);
        }
    }

    public void getHeight() {
        System.out.println("Height: " + height);
    }

    public void push(int value) {
        Node newNode = new Node(value);
        if (height == 0) {
            top = newNode;
            height ++;
            return;
        }

        newNode.next = top;
        top = newNode;
        height ++;
    }

    public Node pop() {
        if (height == 0) {
            return null;
        }

        Node temp = top;
        top = top.next;
        temp.next = null;
        height --;
        return temp;
    }

    public static void main(String[] args) {

        Stack myStack = new Stack(4);

        myStack.getTop();
        myStack.getHeight();

        System.out.println("\nStack:");
        myStack.printStack();

        /*
            EXPECTED OUTPUT:
            ----------------
            Top: 4
            Height: 1

            Stack:
            4

        */

    }

}

