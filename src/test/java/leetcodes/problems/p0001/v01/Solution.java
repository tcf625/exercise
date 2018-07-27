package leetcodes.problems.p0001.v01;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            return new int[] { 0, 0 };
        }
        final int[] result = { 0, 1 };
        if (nums.length == 2) {
            final int testValue = nums[result[0]] + nums[result[1]];
            if (testValue == target) {
                return result;
            }
        }
        while (result[0] < nums.length) {
            while (result[1] < nums.length) {
                final int testValue = nums[result[0]] + nums[result[1]];
                if (testValue == target) {
                    return result;
                }
                result[1]++;
            }
            result[0]++;
            result[1] = result[0] + 1;
        }
        return new int[] { 0, 0 };
    }
}