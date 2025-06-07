package Heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    private List<Integer> heap;

    public Heap() {
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }

    private int leftChild(int index) {
        return 2* index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public void insert(int value) {
        heap.add(value);

        int current = heap.size() - 1;
//        int parent = parent(current);

//        while (current > 0 && heap.get(current) > heap.get(parent)) {
//            swap(current, parent);
//            current = parent;
//            parent = parent(current);
//        }
        while (current > 0 && heap.get(current) > heap.get(parent(current))) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    private void sinkDown(int index) {
        int maxIndex = index;

        while (true) {
            int leftChild = leftChild(maxIndex);
            int rightChild = rightChild(maxIndex);

            if (leftChild < heap.size()
                    && heap.get(leftChild) > heap.get(maxIndex)) {
                maxIndex = leftChild;
            }

            if (rightChild < heap.size()
                    && heap.get(rightChild) > heap.get(maxIndex)) {
                maxIndex = rightChild;
            }

            if (maxIndex != index) {
                swap(index, maxIndex);
                index = maxIndex;
            } else {
                return;
            }
        }
    }

    public Integer remove() {
        if (heap.isEmpty()) {
            return null;
        }

        if (heap.size() == 1) {
            return heap.removeFirst();
        }

//        int maxValue = heap.get(0);
//        heap.set(0, heap.remove(heap.size() - 1));
//        sinkDown(0);

        int lastIndex =  heap.size() - 1;
        swap(0,lastIndex);
        int temp = heap.get(lastIndex);
        heap.remove(lastIndex);

        int current = 0;
        int leftChild = leftChild(current);
        int rightChild = rightChild(current);

        while ((leftChild < heap.size() && heap.get(current) < heap.get(leftChild))
                || (rightChild < heap.size() && heap.get(current) < heap.get(rightChild))) {
            // if both sides < heap.size()
            if (leftChild < heap.size() && rightChild < heap.size()) {
                if (heap.get(leftChild) <= heap.get(rightChild)) {
                    swap(current, rightChild);
                    current = rightChild;
                } else {
                    swap(current, leftChild);
                    current = leftChild;
                }

                rightChild = rightChild(current);
                leftChild = leftChild(current);
                continue;
            }

            // else only left or right < heap.size()
            if (leftChild < heap.size()) {
                swap(current, leftChild);
                current = leftChild;
            }

            if (rightChild < heap.size()) {
                swap(current, rightChild);
                current = rightChild;
            }

            rightChild = rightChild(current);
            leftChild = leftChild(current);
        }
        return temp;
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(80);
        heap.insert(75);
        heap.insert(65);
        heap.insert(55);
        heap.insert(50);
//        heap.insert(61);
//        heap.insert(58);
//        heap.insert(72);
//        heap.insert(100);
//        System.out.println(heap.remove());
    }
}
