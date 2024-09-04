package Tree;

import java.util.*;

public class BinarySearchTreeEx1 {

    private Node root;

    class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public Node getRoot() {
        return root;
    }

    public List<Integer> inorderTraversal() {
        List<Integer> result = new ArrayList<>();
        inorderHelper(this.root, result);
        return result;
    }

    private void inorderHelper(Node node, List<Integer> result) {
        if (node == null) return;
        inorderHelper(node.left, result);
        result.add(node.value);
        inorderHelper(node.right, result);
    }

    public boolean isBalanced() {
        return height(this.root) != -1;
    }

    private int height(Node node) {
        if (node == null) return 0;
        int leftHeight = height(node.left);
        if (leftHeight == -1) return -1;
        int rightHeight = height(node.right);
        if (rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return 1 + Math.max(leftHeight, rightHeight);
    }

    //   +===================================================+
    //   |             WRITE YOUR CODE HERE                  |
    //   | Description:                                      |
    //   | - Converts a sorted array into a height-balanced  |
    //   |   binary search tree (BST).                       |
    //   | - This method is private and used internally      |
    //   |   within the class.                               |
    //   | - It uses recursion to construct the BST.         |
    //   |                                                   |
    //   | Parameters:                                       |
    //   | - nums: Sorted array of integers.                 |
    //   | - left: Starting index for the current segment    |
    //   |   of the array.                                   |
    //   | - right: Ending index for the current segment of  |
    //   |   the array.                                      |
    //   |                                                   |
    //   | Return:                                           |
    //   | - The root node of the BST created from the       |
    //   |   sorted array segment.                           |
    //   |                                                   |
    //   | Tips:                                             |
    //   | - The middle element of the current segment is    |
    //   |   chosen as the root to ensure the BST is         |
    //   |   height-balanced.                                |
    //   | - The method recursively builds the left and right|
    //   |   subtrees by calling itself with adjusted left   |
    //   |   and right indices to work on sub-segments of    |
    //   |   the array.                                      |
    //   +===================================================+

    public void sortedArrayToBST(int[] nums) {
        this.root = sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private Node sortedArrayToBST(int[] nums, int left, int right) {
        if (right - left == 0) {
            return new Node(nums[left]);
        }

        /*
          when [right = 0] or [left = 2]
               [left = -1]    [right= 1]
          => stop and return null
          this case happens when the previous nums[] are only 2 numbers, ex: [11, 12] or [0, 1]
         */
        if (right - left < 0) { // or right < left
            return null;
        }

        int step = (right - left) / 2;
        int middle = left + step;

        Node middleNode = new Node(nums[middle]);
        middleNode.left = sortedArrayToBST(nums, left, middle - 1);
        middleNode.right = sortedArrayToBST(nums, middle  + 1, right);

        return middleNode;
    }

    public static void main(String[] args) {
        // Test: Convert an empty array
        System.out.println("\n----- Test: Convert Empty Array -----\n");
        checkBalancedAndCorrectTraversal(new int[]{}, Arrays.asList());

        checkBalancedAndCorrectTraversal(new int[]{1, 2}, Arrays.asList(1, 2));
        // Test: Convert an array with one element
        System.out.println("\n----- Test: Convert Single Element Array -----\n");
        checkBalancedAndCorrectTraversal(new int[]{10}, Arrays.asList(10));

        // Test: Convert a sorted array with odd number of elements
        System.out.println("\n----- Test: Convert Sorted Array with Odd Number of Elements -----\n");
        checkBalancedAndCorrectTraversal(new int[]{1, 2, 3, 4, 5}, Arrays.asList(1, 2, 3, 4, 5));

        // Test: Convert a sorted array with even number of elements
        System.out.println("\n----- Test: Convert Sorted Array with Even Number of Elements -----\n");
        checkBalancedAndCorrectTraversal(new int[]{1, 2, 3, 4, 5, 6}, Arrays.asList(1, 2, 3, 4, 5, 6));

        // Test: Convert a large sorted array
        System.out.println("\n----- Test: Convert Large Sorted Array -----\n");
        checkBalancedAndCorrectTraversal(
                Arrays.stream(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}).toArray(),
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));
    }

    private static void checkBalancedAndCorrectTraversal(int[] nums, List<Integer> expectedTraversal) {
        BinarySearchTreeEx1 bst = new BinarySearchTreeEx1();
        bst.sortedArrayToBST(nums);
        boolean isBalanced = bst.isBalanced();
        List<Integer> inorder = bst.inorderTraversal();
        System.out.println("Is balanced: " + isBalanced);
        System.out.println("Inorder traversal: " + inorder);
        System.out.println("Expected traversal: " + expectedTraversal);
        if (isBalanced && inorder.equals(expectedTraversal)) {
            System.out.println("PASS: Tree is balanced and inorder traversal is correct.\n");
        } else {
            System.out.println("FAIL: Tree is either not balanced or inorder traversal is incorrect.\n");
        }
    }
}

