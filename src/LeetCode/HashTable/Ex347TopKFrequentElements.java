package LeetCode.HashTable;

import java.util.*;

public class Ex347TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }

        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();

        for (Integer num : nums) {
            map.compute(num, (key, value) -> value == null ? 1 : value + 1);
        }

        Queue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(map::get));

        for (Integer num : map.keySet()) {
            heap.add(num);
            if (heap.size() > k) heap.poll();
        }

        for (int i = 0; i < k - 1; i++) {
            if (!heap.isEmpty()) {
                result[i] = heap.poll();
            }
        }

        return result;
    }

    public int[] topKFrequentBucketSort(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List[] bucket = new List[nums.length + 1];
        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        // Duyệt từ bucket lớn về nhỏ
        List<Integer> result = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && result.size() < k; i--) {
            if (bucket[i] != null) {
                result.addAll(bucket[i]); // ⛔ Có thể thêm quá số lượng k cần thiết
            }
        }

        // Convert sang array
        return result.stream().mapToInt(i -> i).toArray();
    }


    public int[] topKFrequentBucketSortTest(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> counterByNum = new HashMap<>();
        for (int num : nums) {
            counterByNum.compute(num, (key, value) -> value == null ? 1 : value + 1);
        }

        List<List<Integer>> bucketSort = new ArrayList<>(counterByNum.size() + 1); // cover index 0

        for (int i = 0; i <= nums.length; i++) {
            bucketSort.add(new ArrayList<>());
        }

        counterByNum.forEach((key, value) -> {
            bucketSort.get(value).add(key);
        });

        int temp = 0;
        for (int i = bucketSort.size() - 1; i > 0 && temp < k; i--) {
            List<Integer> list = bucketSort.get(i);
            for (Integer item : list) {
                if (temp == k) break; // Mảng result có kích thước k, nên chỉ được phép gán result[0] đến result[k-1]

                result[temp] = item;
                temp++;
            }

        }

        return result;
    }

    public int[] topKFrequentPriorityQueueTest(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> counterByNum = new HashMap<>();
        for (int num : nums) {
            counterByNum.compute(num, (key, value) -> value == null ? 1 : value + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((n, m) -> counterByNum.get(n) - counterByNum.get(m));

        for (Integer num : counterByNum.keySet()) {
            heap.add(num); // add trước để có đủ các phần tử sắp xếp trong heap
            if (heap.size() > k) { // sau đó nếu thừa thì remove bớt ra
                heap.poll();
            }
        }

        for (int i = k - 1; i >= 0 ; i--) {
            if (!heap.isEmpty()) {
                result[i] = heap.poll();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Ex347TopKFrequentElements().topKFrequent(new int[]{1, 2, 2, 4, 3, 3}, 2)));
    }
}
