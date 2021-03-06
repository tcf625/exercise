package leetcodes.problems.p0004.v02;

/**
 * Median of Two Sorted Arrays
 */
class Solution {

    public static double findMedianSortedArrays(final int[] nums1, final int[] nums2) {
        return 0;
    }

    /**
     * <pre>
     *  
     * DATA   :      0   1   2   3   4
     * RETURN : '-1' 0 1 2 3 4 5 6 7 8 '9'
     * 
     * </pre>
     */
    public static int search(final int value, final int[] nums, final int startIndex, final int size) {

        final int lastIndex = startIndex + size - 1;
        if (value == nums[startIndex]) {
            return (startIndex * 2);
        } else if (value < nums[startIndex]) {
            return (startIndex * 2) - 1;
        }
        if (value == nums[lastIndex]) {
            return (lastIndex * 2);
        } else if (value > nums[lastIndex]) {
            return (lastIndex * 2) + 1;
        }
        // 0-0 
        // 1-0 
        // 2-1
        final int helfSize = size / 2;
        final int midIndex = startIndex + helfSize;
        final int midValue = nums[midIndex];
        if (value < midValue) {
            return search(value, nums, startIndex, helfSize);
        } else if (value > midValue) {
            return search(value, nums, midIndex + 1, size - helfSize - 1);
        } else {
            // (value == midValue) {
            return midIndex * 2;
        }
    }
}