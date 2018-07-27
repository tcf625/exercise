package leetcodes.problems.p0001.v01;

import static org.junit.Assert.*;
import org.junit.Test;

import leetcodes.problems.TestKit;

public class SolutionTest {
    Solution target = new Solution();

    @Test
    public void test() {
        //        Given nums = [2, 7, 11, 15], target = 9,
        //                Because nums[0] + nums[1] = 2 + 7 = 9,
        //                return [0, 1].
        int[] nums = TestKit.ints(2, 7, 11, 15);
        assertArrayEquals(TestKit.ints(0, 1), this.target.twoSum(nums, 9));
    }
}