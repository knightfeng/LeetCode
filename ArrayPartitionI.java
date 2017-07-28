import java.util.Arrays;

/* 
    Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) 
    which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
*/
public class ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        
        // 1. Sort
        Arrays.sort(nums);
        int result = 0;

        // 2. Pair-up adjacent numbers sequentially.
        for (int i = 0; i < nums.length; i = i + 2) {
            
            if (i + 1 > nums.length) {
                result += nums[i];
                break;
            }

            int min = nums[i] <= nums[i + 1] ? nums[i] : nums[i + 1];

            result += min;
        }

        return result;

    }
}