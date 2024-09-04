package Practicing;

import Tree.BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BSTreePractice {

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
        Node temp = root;

        while (true) {
            if (temp.value == value) {
                return false;
            }

            if (temp.value < value) {
                if (temp.right != null) {
                    temp = temp.right;
                } else {
                    temp.right = new Node(value);
                    return true;
                }
            } else {
                if (temp.left != null) {
                    temp = temp.left;
                } else {
                    temp.left = new Node(value);
                    return true;
                }
            }
        }
    }

    public boolean contains(int value) {
        Node temp = root;
        while (temp != null) {
            if (temp.value == value) {
                return true;
            }

            if (temp.value < value) {
                if (temp.right != null) {
                    temp = temp.right;
                } else {
                    return false;
                }
            } else {
                if (temp.left != null) {
                    temp = temp.left;
                } else {
                    return false;
                }
            }
        }

        return false;
    }

    public boolean rContains(int value) {
        Node temp = root;
        if (temp == null) return false;

        return contain(root, value);

    }

    private boolean contain(Node currentNode, int value) {
        if (currentNode == null) {
            return false;
        }

        if (currentNode.value == value) {
            return true;
        }

        if (currentNode.value < value) {
            return contain(currentNode.right, value);
        } else {
            return contain(currentNode.left, value);
        }
    }

    public void rInsert(int value) {
        if (root == null) root = new Node(value);
        rInsert(root, value);
    }

    private Node rInsert(Node currentNode, int value) {
        if (currentNode == null) return new Node(value);

        if (currentNode.value < value) {
            currentNode.right = rInsert(currentNode.right, value);
        }

        if (value < currentNode.value)  {
            currentNode.left = rInsert(currentNode.left, value);
        }

        return currentNode;
    }

    public void deleteNode(int value) {
        if (root == null) return;
        deleteNode(root, value);
    }

    private Node deleteNode(Node currentNode, int value) {
        if (currentNode == null) {
            return null;
        }

        if (currentNode.value > value) {
            currentNode.left = deleteNode(currentNode.left, value);
        } else if (currentNode.value < value) {
            currentNode.right = deleteNode(currentNode.right, value);
        } else {

			if (currentNode.right == null && currentNode.left == null) {
                return null;
            }

            if (currentNode.right != null && currentNode.left != null) {
                int minValue = minValue(currentNode.right);
                currentNode.value = minValue;
                currentNode.right = deleteNode(currentNode.right, minValue);
            }

            if (currentNode.right != null) {
                currentNode = currentNode.right;
            }

            if (currentNode.left != null) {
                currentNode = currentNode.left;
            }
        }

		return currentNode;
    }

    public int minValue(Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }


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
            Traverse(Node current) {
                results.add(current.value);
                if (current.left != null) {
                    new Traverse(current.left);
                }

                if (current.right != null) {
                    new Traverse(current.right);
                }
            }
        }

        new Traverse(root);
        return results;
    }

    public static void main(String[] args) {
        BSTreePractice myBST = new BSTreePractice();
        myBST.insert(2);
        myBST.insert(1);
        myBST.insert(3);
        myBST.insert(4);
        myBST.insert(0);

        myBST.rInsert(1);
//        System.out.println(myBST.rContains(3));
    }
}

