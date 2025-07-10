package LeetCode.TwoPointer;

public class Ex11ContainerWithMostWater {

    public static int maxAreaBruteForce(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                max = Math.max(max, area);
            }
        }
        return max;
    }

    public static int maxAreaByMe(int[] height) {
        int max = 0;

        for (int i = 0; i < height.length - 1; i++) {

            int left = i;
            int right = height.length - 1;

            while (left < right) {
                int area = (right - left) * Math.min(height[left], height[right]);
                max = Math.max(max, area);
                left++;
            }

            left = i;
            right = height.length - 1;
            while (left < right) {
                int area = (right - left) * Math.min(height[left], height[right]);
                max = Math.max(max, area);
                right--;
            }
        }

        return max;
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, area);

            // Di chuyển con trỏ bên nào thấp hơn
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }

    public static void test(int[] height) {
        System.out.println("=========================");
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                System.out.println("----- i= " + i + ", j = " + j);
            }
            System.out.println("=========================");
        }
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxAreaBruteForce(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        test(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
    }
}
