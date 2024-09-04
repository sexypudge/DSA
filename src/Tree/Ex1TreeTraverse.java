package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class Ex1TreeTraverse {

    public Node root;

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        private Node(int value) {
            this.value = value;
        }
    }

    public Node getRoot() {
        return root;
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) return false;
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public ArrayList<Integer> DFSInOrder() {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(Node currentNode) {
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                results.add(currentNode.value);
                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
            }
        }

        new Traverse(root);
        return results;
    }

    //   +===================================================+
    //   |                  WRITE YOUR CODE HERE             |
    //   | Description:                                      |
    //   | - Checks if the binary tree is a valid Binary     |
    //   |   Search Tree (BST).                              |
    //   | - A BST is valid if all nodes follow the left <   |
    //   |   parent < right rule across the entire tree.     |
    //   | - Utilizes in-order traversal to collect node     |
    //   |   values and then checks if the list of values    |
    //   |   is in ascending order without duplicates.       |
    //   |                                                   |
    //   | Return:                                           |
    //   | - Returns true if the tree is a valid BST.        |
    //   | - Returns false otherwise.                        |
    //   |                                                   |
    //   | Tips:                                             |
    //   | - DFSInOrder() is assumed to be a method that     |
    //   |   performs an in-order traversal of the tree and  |
    //   |   returns an ArrayList of node values.            |
    //   | - A valid BST should have its in-order traversal  |
    //   |   result in a strictly ascending order list.      |
    //   +===================================================+

    public boolean isValidBSTMySolution() {
        List<Integer> integerList = DFSInOrder();
        if (integerList.size() == 1) {
            return true;
        }

        for (int i = 1; i < integerList.size() - 1; i ++) {
            if (integerList.get(i) <= integerList.get(i - 1)) {
                return false;
            }

            if (integerList.get(i) > integerList.get(i + 1)) {
                return false;
            }
        }

        return true;
    }

    public boolean isValidBST() {
        ArrayList<Integer> nodeValues = DFSInOrder();
        for (int i = 1; i < nodeValues.size(); i++) {
            if (nodeValues.get(i) <= nodeValues.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public Integer kthSmallest(int k) {
        Stack<Node> stack = new Stack<>();
        Node currentNode = root;
        while (!stack.isEmpty() || currentNode != null) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            k -= 1;
             if (k == 0) {
                return currentNode.value;
            }
            currentNode = currentNode.right;
        }

        return null;
    }

    public Integer kthSmallestMySolution(int k) {
        List<Integer> integerList = DFSInOrder();
        if (k <= 0 || k > integerList.size()) {
            return null;
        }

        return integerList.get(k-1);
    }

    public static void main(String[] args) {
        Ex1TreeTraverse traverse = new Ex1TreeTraverse();
        traverse.insert(21);
        traverse.insert(47);
        traverse.insert(27);
        traverse.insert(82);
        traverse.insert(52);
        traverse.insert(76);
        traverse.insert(18);
//        System.out.println(traverse.isValidBSTMySolution());
//        System.out.println(traverse.isValidBST());
        System.out.println(traverse.kthSmallest(3));
    }



}