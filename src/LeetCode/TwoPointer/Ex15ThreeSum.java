package LeetCode.TwoPointer;

import java.util.*;

public class Ex15ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        System.out.println("Sorted array: " + Arrays.toString(nums));

        for (int i = 0; i < nums.length - 2; i++) {
            // Bỏ qua trùng ở i
            if (i > 0 && nums[i] == nums[i - 1]) {
                System.out.println("Skip duplicate i at index " + i + " (" + nums[i] + ")");
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                System.out.printf("Checking: i=%d (%d), left=%d (%d), right=%d (%d) → sum=%d\n",
                        i, nums[i], left, nums[left], right, nums[right], sum);

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    System.out.println("✅ Found triplet: " + Arrays.asList(nums[i], nums[left], nums[right]));

                    left++;
                    right--; // bỏ qua ở đây trước nên nums[right + 1] ko bị out of range

                    // Bỏ qua trùng ở left
                    while (left < right
                            && nums[left] == nums[left - 1]) {
                        System.out.println("Skip duplicate left at index " + left + " (" + nums[left] + ")");
                        left++;
                    }

                    // Bỏ qua trùng ở right
                    while (left < right
                            && nums[right] == nums[right + 1]) {
                        System.out.println("Skip duplicate right at index " + right + " (" + nums[right] + ")");
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                    System.out.println("Because sum < 0 --> left go next: " + left + " (" + nums[left] + " )" );
                } else {
                    right--;
                    System.out.println("Because sum < 0 --> right go next: " + right + " (" + nums[right] + " )" );
                }
            }
        }

        return result;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums); // Giúp xử lý duplicate dễ hơn

        System.out.println("Sorted input: " + Arrays.toString(nums));
        // i chạy đến num.len - 3 vì chỉ xét bắt đầu bằng i và những số j chạy qua chứ ko xét về trc i
        // chúng ta cần đủ 3 phần tử để tạo thaành set
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                System.out.println("Skipping duplicate i at index " + i + " with value " + nums[i]);
                continue;
            }

            int fixed = nums[i];
            Set<Integer> seen = new HashSet<>();
            System.out.println("\nFixing i = " + i + ", value = " + fixed);

            for (int j = i + 1; j < nums.length; j++) {
                int complement =  -fixed - nums[j];
                System.out.println("  Checking j = " + j + ", value = " + nums[j] +
                        " → Need complement = " + complement);

                if (seen.contains(complement)) {
                    List<Integer> triplet = Arrays.asList(fixed, nums[j], complement);
                    Collections.sort(triplet); // Normalize to avoid duplicate triplets in different orders
                    if (result.add(triplet)) {
                        System.out.println("    ✅ Found triplet: " + triplet);
                    } else {
                        System.out.println("    ⚠️  Duplicate triplet ignored: " + triplet);
                    }
                } else {
                    System.out.println("    Not contains complement: " + complement);
                }

                seen.add(nums[j]);
                System.out.println("    Seen updated: " + seen);
            }
        }

        return new ArrayList<>(result);
    }

//    public static List<List<Integer>> tripple(int[] nums) {
//        Set<List<Integer>> result = new HashSet<>();
//        Set<Integer> allNums = new HashSet<>(Arrays.asList(-1, 0, 1, 2));
//
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                int complement = -nums[i] - nums[j];
//                if (allNums.contains(complement)) {
//                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
//                    Collections.sort(triplet);
//                    result.add(triplet);
//                }
//            }
//        }
//
//        return new ArrayList<>(result);
//    }


    public static List<List<Integer>> threeSumTest(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) { // remove duplicates
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    right --;
                    left ++;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left ++;
                    }

                    while (left < right && nums[right] == nums[right + 1]) {
                        right --;
                    }
                } else if (sum < 0) {
                    left ++ ;
                } else {
                    right --;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Final Result: " + threeSum2(new int[]{-2, -1, 0, 1, 2}));
//        System.out.println("Final Result: " + tripple(new int[]{-1, 0, 1, 2}));
//        System.out.println("Final Result: " + threeSum2(new int[]{-1, 0, 1, 2, -4}));
//        System.out.println("Final Result: " + threeSum2(new int[]{-1, -1, 2}));
//        System.out.println(threeSum(new int[]{-1, 2, -1, -1, 2}));
//        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -4}));
    }

}
