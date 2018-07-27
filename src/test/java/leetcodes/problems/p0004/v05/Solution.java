package leetcodes.problems.p0004.v05;

import java.util.Arrays;

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

        if (length1 + length2 < 10) {
            final int totalArray[] = new int[length1 + length2];
            System.arraycopy(nums1, 0, totalArray, 0, nums1.length);
            System.arraycopy(nums2, 0, totalArray, nums1.length, nums2.length);
            Arrays.sort(totalArray);
            return midOfArray(totalArray);
        }

        final int total = length1 + length2;
        if (length1 <= length2) {
            return innerFindMedian(total, nums2, 0, length2, nums1, 0, length1);
        } else {
            return innerFindMedian(total, nums1, 0, length1, nums2, 0, length2);
        }
    }

    private static double innerFindMedian(final int total, //
            final int[] nums1, final int start1, final int end1, //
            final int[] nums2, final int start2, final int end2) {

        final int length1 = end1 - start1;
        final int length2 = end2 - start2;
        final int midIndex1 = (start1 + end1) / 2;
        final int mid1 = nums1[midIndex1];

        final int midIndex2 = numOfLess(mid1, nums2, start2, length2);

        final int lessSize = (total - 1) / 2;

        if (midIndex1 + midIndex2 < lessSize) {
            return innerFindMedian(total, nums1, midIndex1, end1, nums2, midIndex2, end2);
        } else if (midIndex1 + midIndex2 > lessSize) {
            if ((midIndex2 - start2) > (midIndex1 + 1 - start1)) {
                return innerFindMedian(total, nums2, start2, midIndex2, nums1, start1, midIndex1 + 1);
            } else {
                return innerFindMedian(total, nums1, start1, midIndex1 + 1, nums2, start2, midIndex2);
            }
        } else {

            final int mid2 = nums2[midIndex2];
            final int result = Math.min(mid1, mid2);
            if (total % 2 == 0) {
                int tmp = Math.max(mid1, mid2);
                tmp = Math.min(tmp, nums1[midIndex1 + 1]);
                tmp = Math.min(tmp, nums2[midIndex2 + 1]);
                return (result + tmp) / 2.0;

            } else {
                return result;
            }
        }

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
     *             0 0 1 1 2 2 3 3 4 4 5 5 5 5 ......
     * </pre>
     */
    public static int numOfLess(final int value, final int[] nums, final int startIndex, final int size) {
        final int lastIndex = startIndex + size - 1;
        final int min = nums[startIndex];
        final int max = nums[lastIndex];
        if (value == min) {
            return (startIndex);
        } else if (value < min) {
            return (startIndex);
        } else if (value == max) {
            return lastIndex;
        } else if (value > max) {
            return lastIndex + 1;
        }
        final int helfSize = size / 2;
        final int midIndex = startIndex + helfSize;
        final int midValue = nums[midIndex];
        if (value < midValue) {
            return numOfLess(value, nums, startIndex, helfSize);
        } else if (value > midValue) {
            return numOfLess(value, nums, midIndex + 1, size - helfSize - 1);
        } else {
            // (value == midValue)
            return midIndex;
        }
    }
}