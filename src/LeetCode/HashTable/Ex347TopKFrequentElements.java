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

        for (int i = 0 ; i < k -1 ; i++) {
            if (!heap.isEmpty()) {
                result[i] =  heap.poll();
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
        if (nums.length == k) {
            return nums;
        }
        int[] result = new int[k];

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (Integer num : nums) {
            freqMap.compute(num, (key, value) -> value == null ? 1 : value + 1);
        }

        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        freqMap.forEach((key, value) -> {
            if (bucket[value] == null) {
                bucket[value] = new ArrayList<>();
            }

            bucket[value].add(key);
        });

        int index = 0;
        for (int j = bucket.length - 1; j >= 0 && index < k; j--) {
            if (bucket[j] != null) {
                for (int num : bucket[j]) {
                    result[index++] = num;
                    if (index == k) break; // đủ k phần tử
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Ex347TopKFrequentElements().topKFrequent(new int[]{1, 2,2,4,3,3}, 2)));
    }
}
