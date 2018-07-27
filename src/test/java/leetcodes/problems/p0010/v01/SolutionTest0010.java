package leetcodes.problems.p0010.v01;

import static org.junit.Assert.*;
import org.junit.Test;

public class SolutionTest0010 {
    Solution target = new Solution();

    @Test
    public void test() {
        assertFalse(this.target.isMatch("aa", "aaa"));
    }
}