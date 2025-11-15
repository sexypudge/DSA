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
//         If using max-Heap
//        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> map.get(n2) - map.get(n1));
//        heap.addAll(map.keySet());

        for (int i = 0; i < k - 1; i++) {
            if (!heap.isEmpty()) {
                result[i] = heap.poll();
            }
        }

//        List<Integer>[] arrLs = new List[nums.length + 1];
//        for (Integer num : map.keySet()) {
//            int freq = map.get(num);
//            if (arrLs[freq] == null) {
//                arrLs[freq] = new ArrayList<>();
//            }
//            arrLs[freq].add(num);
//        }
//
//        int count = 0;
//        for (int i = arrLs.length - 1; i  > 0 && count < k ; i--) {
//            if (arrLs[i] != null) {
//                for (int num : arrLs[i]) {
//                    result[count] = num;
//                    count++;
//                    if (count == k) break; // đủ k phần tử thì thoát
//                }
//            }
//        }


        return result;
    }

    public int[] topKFrequentBucketSort1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1); // đếm frequency
        }

        // bucket sort
        List<Integer>[] arrLs = new List[nums.length + 1];
        for (int i = 0; i < arrLs.length; i++) { // khoi tao bucketsort list truoc de tranh nullpointer
            arrLs[i] = new ArrayList<>();
        }

        for (Integer num : map.keySet()) {
            int freq = map.get(num);
            arrLs[freq].add(num); // xu ly voi moi list của freq tìm đc
        }

        int[] result = new int[k];
        int count = 0;

        for (int i = arrLs.length - 1; i > 0 && count < k; i--) { // Result với kích thước k chỉ có index từ i = 0 đến k -1, nếu count = k → ArrayIndexOutOfBoundsException
            for (int num : arrLs[i]) {
                result[count] = num;
                count++;
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

        List<Integer>[] bucket = new List[nums.length + 1];
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

        List<List<Integer>> bucketSort = new ArrayList<>(counterByNum.size() + 1); // + 1 to cover index 0

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

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Ex347TopKFrequentElements().topKFrequentBucketSort1(new int[]{1, 2, 2, 4, 3, 3}, 2)));
    }
}
