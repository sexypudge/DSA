package LeetCode.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class Ex589 {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public static void main(String[] args) {

    }

    private List<Integer> proceedPreorderMySolution(Node node) {
        List<Integer> result = new ArrayList<>();
        List<Node> children = node.children;

        result.add(node.val);

        if (children == null) {
            return result;
        }

        for (Node child : children) {
            result.addAll(proceedPreorderMySolution(child));
        }
        return result;
    }

    private List<Integer> proceedPreorder(Node node, List<Integer> result) {
        List<Node> children = node.children;
        result.add(node.val);
        if (children == null) {
            return result;
        }

        for (Node child : children) {
            proceedPreorder(child, result);
        }

        return result;
    }

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return List.of();
        }
        return proceedPreorder(root, result);
    }
}
