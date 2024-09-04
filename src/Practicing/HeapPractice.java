package Practicing;

import Heap.Heap;

import java.util.ArrayList;
import java.util.List;

public class HeapPractice {

    private List<Integer> heap;

    public HeapPractice() {
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
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
        int index = heap.size() - 1;

        while (index >= 0
                && heap.get(index) >  heap.get(parent(index))) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public Integer remove() {
        if (heap.isEmpty()) {
            return null;
        }

        if (heap.size() == 1) {
            return heap.remove(0);
        }

        Integer remove = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);

        int temp = 0;
        int max = 0;

        while (true) {
            int right = rightChild(temp);
            int left = leftChild(temp);

            if (right < heap.size()
                    && heap.get(right) > heap.get(max)) {
                max = right;
            }

            if (left < heap.size()
                    && heap.get(left) > heap.get(max)) {
                max = left;
            }

            if (max != temp) {
                swap(max, temp);
                temp = max;
            } else {
                return remove;
            }
        }
    }

    public Integer removeMySolution() {
        if (heap.isEmpty()) {
            return null;
        }

        if (heap.size() == 1) {
            return heap.remove(0);
        }

        Integer remove = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);

        int temp = 0;
        while (true) {
            int right = rightChild(temp);
            int left = leftChild(temp);

            if (right <= heap.size() - 1
                    && left <= heap.size() - 1) {
                if (heap.get(right) > heap.get(left)) {
                    if (heap.get(right) > heap.get(temp)) {
                        swap(right, temp);
                        temp = right;
                    }

                } else {
                    if (heap.get(left) > heap.get(temp)) {
                        swap(left, temp);
                        temp = left;
                    }
                }
            }

            if (right <= heap.size() - 1
                    && heap.get(right) > heap.get(temp)) {
                swap(right, temp);
                temp = right;
            }

            if (left <= heap.size() - 1
                    && heap.get(left) > heap.get(temp)) {
                swap(left, temp);
                temp = left;
            }

            if (left > heap.size() - 1
                    && right > heap.size() - 1) {
                return remove;
            }
        }
    }

    public static void main(String[] args) {
        Heap myHeap = new Heap();
        myHeap.insert(95);
        myHeap.insert(75);
        myHeap.insert(80);
        myHeap.insert(55);
        myHeap.insert(60);
        myHeap.insert(50);
        myHeap.insert(65);

        System.out.println(myHeap.getHeap());


        myHeap.remove();

        System.out.println(myHeap.getHeap());


        myHeap.remove();

        System.out.println(myHeap.getHeap());
    }
}
