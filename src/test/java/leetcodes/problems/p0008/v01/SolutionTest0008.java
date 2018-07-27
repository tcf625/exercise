package leetcodes.problems.p0008.v01;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest0008 {
    Solution target = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(42, target.myAtoi("42"));
        Assert.assertEquals(42, target.myAtoi(" +42"));
        Assert.assertEquals(-42, target.myAtoi(" -42"));

    }

    @Test
    public void test2() {
        Assert.assertEquals(4193, target.myAtoi(" 4193 with words"));
    }

    @Test
    public void test3() {
        Assert.assertEquals(-2147483648, target.myAtoi(" -91283472332"));
    }
}