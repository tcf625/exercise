package leetcodes.problems.p0009.v01;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest0009 {
    Solution target = new Solution();

    @Test
    public void test() {
        assertTrue(this.target.isPalindrome(8));
        assertTrue(this.target.isPalindrome(0));
        assertTrue(this.target.isPalindrome(11));
        assertTrue(this.target.isPalindrome(121));
        assertFalse(this.target.isPalindrome(-10));

        assertFalse(this.target.isPalindrome(123));
        assertTrue(this.target.isPalindrome(2147447412));
        assertFalse(this.target.isPalindrome(2147483646));
        assertFalse(this.target.isPalindrome(2147483647));

        //        
        //        System.out.println(Integer.MAX_VALUE);
        //        target.isPalindrome(2147447412);
        //        target.isPalindrome(2147483646);
        //        target.isPalindrome(2147483647);
    }
}