package LeetCode.HashTable;

public class Ex1143LongestCommonSubsequence {
    static int[] memo;

    public static int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()];
        int longest = 0;


        return longest;
    }


    public static void main(String[] args) {
//        System.out.println(longestCommonSubsequence("abcd", "dbca"));
        System.out.println(longestCommonSubsequence("abcdef", "dbcaf"));
//        System.out.println(longestCommonSubsequence("abcd", "dcba"));
//        System.out.println(longestCommonSubsequence("a", "abc"));
    }
}
