package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {

    public Node root;

    static class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public boolean insert(int value) {
        if (root == null) {
            root = new Node(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = root;

        while (true) {
            if (temp.value == value) {
                return false;
            }

            if (temp.value < value) {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                } else {
                    temp = temp.right;
                }
            } else {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                } else {
                    temp = temp.left;
                }
            }
        }
    }

    public boolean contains(int value) {
        if (root == null) {
            return false;
        }

        Node temp = root;
        while (true) {
            if (temp.value == value) {
                return true;
            }

            if (value > temp.value) {
                if (temp.right == null) {
                    return false;
                }

                temp = temp.right;

            } else {
                if (temp.left == null) {
                    return false;
                }

                temp = temp.left;
            }
        }

//        if (root == null) return false;
//        Node temp = root;
//        while (temp != null) {
//            if (value < temp.value) {
//                temp = temp.left;
//            } else if (value > temp.value) {
//                temp = temp.right;
//            } else {
//                return true;
//            }
//        }
//        return false;
    }

    private boolean rContains(Node currentNode, int value) {
        if (currentNode == null) {
            return false;
        }

        if (currentNode.value == value) {
            return true;
        }

        if (currentNode.value < value) {
            return rContains(currentNode.right, value);
        } else {
            return rContains(currentNode.left, value);
        }
    }

    public boolean rContains(int value) {
        return rContains(root, value);
    }

    private Node rInsert(Node currentNode, int value) {
        if (currentNode == null) return new Node(value);

        if (value < currentNode.value) {
            currentNode.left = rInsert(currentNode.left, value);
        } else if (value > currentNode.value)  {
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode;
    }

    public void rInsert(int value) {
        if (root == null) root = new Node(value);
        rInsert(root, value);
    }

    private Node deleteNode(Node currentNode, int value) {
        if (currentNode == null) return null; // if can't find the value to delete

        //==== Start to traverse the tree
        if (value < currentNode.value) { // if value is smaller, go left
            currentNode.left = deleteNode(currentNode.left, value);
            return currentNode;
        }

        if (value > currentNode.value) { // if value is greater, go right
            currentNode.right = deleteNode(currentNode.right, value);
            return currentNode;
        }
        //=== End

        // if value is equal to currentNode.value
        if (currentNode.left == null && currentNode.right == null) { // currentNode is a leaf
            return null;
        }

        if (currentNode.left == null) {
            return currentNode.right;
        }

        if (currentNode.right == null) {
            return currentNode.left;
        }

        // if currentNode has 2 children
        int minValue = minValue(currentNode.right); // get minValue of the right subtree
        currentNode.right = deleteNode(currentNode.right, minValue);  // Delete the minimum in right subtree
        currentNode.value = minValue; // Replace with min in right subtree
        return currentNode;
    }

//    private Node deleteNode(Node currentNode, int value) {
//        // Base case, tree is empty
//        if (currentNode == null) return null;
//
//        // Recurse down the tree
//        if (value < currentNode.value) {
//            // If less, go left
//            currentNode.left = deleteNode(currentNode.left, value);
//        } else if (value > currentNode.value) {
//            // If more, go right
//            currentNode.right = deleteNode(currentNode.right, value);
//        } else {
//            // Value is same as current's value, node to delete
//            if (currentNode.left == null && currentNode.right == null) {
//                // Node is a leaf node
//                return null;
//            } else if (currentNode.left == null) {
//                // Node has only right child
//                currentNode = currentNode.right;
//            } else if (currentNode.right == null) {
//                // Node has only left child
//                currentNode = currentNode.left;
//            } else {
//                // Node has two children
//                int subTreeMin = minValue(currentNode.right);
//                // Replace with min in right subtree
//                currentNode.value = subTreeMin;
//                // Delete the minimum in right subtree
//                currentNode.right = deleteNode(currentNode.right, subTreeMin);
//            }
//        }
//        // Return the modified tree
//        return currentNode;
//    }

    public int minValue(Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    public void deleteNode(int value) {
        if (root == null) return;
        deleteNode(root, value);
    }

    //// WRITE BFS METHOD HERE ////
    public List<Integer> BFS() {
        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        queue.add(currentNode);

        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            result.add(currentNode.value);

            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }

            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }

        return result;
    }

    public List<Integer> DFSPreOrder() {
        List<Integer> results = new ArrayList<>();
        class Traverse {
            Traverse(Node currentNode) {
                results.add(currentNode.value);
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }

                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
            }
        }
        new Traverse(root);
        //-----
//        if (root == null) return results;
//        dfs(root, results);
        //------
        return results;
    }

//    public void dfs(Node currentNode, List<Integer> results) {
//        results.add(currentNode.value);
//        if (currentNode.left != null) {
//            dfs(currentNode.left, results);
//        }
//
//        if (currentNode.right != null) {
//            dfs(currentNode.right, results);
//        }
//    }

    public static void main(String[] args) {

        BinarySearchTree myBST = new BinarySearchTree();
        myBST.rInsert(48);
        myBST.rInsert(21);
        myBST.rInsert(18);
        myBST.rInsert(27);
//        myBST.insert(2);
//        myBST.insert(1);
//        myBST.insert(3);
//        myBST.insert(3);
//        myBST.insert(4);
//        myBST.insert(0);

        /*
            THE LINES ABOVE CREATE THIS TREE:
                         2
                        / \
                       1   3
        */


        // ROOT MUST BE PUBLIC FOR THESE LINES TO WORK
        System.out.println("Root: " + myBST.root.value);
        System.out.println("\nRoot->Left: " + myBST.root.left.value);
        System.out.println("\nRoot->Right: " + myBST.root.right.value);


        /*
            EXPECTED OUTPUT:
            ----------------
            Root: 2

            Root->Left: 1

            Root->Right: 3

        */

    }

}

