package LeetCode.DynamicProgramming.LinearDPDecisionMaking;

public class Ex416PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {

		return true;
    }

    public boolean partition(int[] nums, int index) {

        GetProMotion: for (int i = 0; i <nums.length; i++) {
        	if (i == 0) {
            	continue GetProMotion;
            } else {
                i = i + 1;
            }
        }
        return true;
    }
}
