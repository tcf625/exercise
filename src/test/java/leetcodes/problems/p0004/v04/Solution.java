package leetcodes.problems.p0004.v04;

/**
 * Median of Two Sorted Arrays
 */
class Solution {

    public static double findMedianSortedArrays(final int[] nums1, final int[] nums2) {

        // # special case
        final int length1 = nums1.length;
        final int length2 = nums2.length;

        if (length1 == 0) {
            return midOfArray(nums2);
        } else if (length2 == 0) {
            return midOfArray(nums1);
        }

        // # 
        if (nums1[length1 - 1] <= nums2[0]) {
            return medianOfOrdededArray(nums1, nums2);
        } else if (nums2[length2 - 1] <= nums1[0]) {
            return medianOfOrdededArray(nums2, nums1);
        }

        return 0;
    }

    private static double medianOfOrdededArray(final int[] nums1, final int[] nums2) {
        final int length1 = nums1.length;
        final int length2 = nums2.length;
        final int len = length1 + length2;
        if (len % 2 == 0) {
            final int index1 = len / 2;
            final double a = nthOfTwoArrays(index1, nums1, nums2);
            final double b = nthOfTwoArrays(index1 - 1, nums1, nums2);
            return (a + b) / 2.0;
        } else {
            final int index = (len - 1) / 2;
            return nthOfTwoArrays(index, nums1, nums2);
        }
    }

    private static double midOfArray(final int[] nums) {
        final int len = nums.length;
        if (len % 2 == 0) {
            final double a = nums[len / 2];
            final double b = nums[(len / 2) - 1];
            return (a + b) / 2.0;
        } else {
            return nums[(len - 1) / 2];
        }
    }

    private static double nthOfTwoArrays(final int index, final int[] nums1, final int[] nums2) {
        final int length1 = nums1.length;
        if (index < length1) {
            return nums1[index];
        } else {
            return nums2[index - length1];
        }
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
        final int min = nums[startIndex];
        final int max = nums[lastIndex];
        if (value == min) {
            return (startIndex * 2);
        } else if (value < min) {
            return (startIndex * 2) - 1;
        } else if (value == max) {
            return (lastIndex * 2);
        } else if (value > max) {
            return (lastIndex * 2) + 1;
        }
        final int helfSize = size / 2;
        final int midIndex = startIndex + helfSize;
        final int midValue = nums[midIndex];
        if (value < midValue) {
            return search(value, nums, startIndex, helfSize);
        } else if (value > midValue) {
            return search(value, nums, midIndex + 1, size - helfSize - 1);
        } else {
            // (value == midValue)
            return midIndex * 2;
        }
    }
}