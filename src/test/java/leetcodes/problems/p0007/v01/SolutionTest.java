package leetcodes.problems.p0007.v01;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

    Solution target = new Solution();

    @Test
    public void test() {
        assertEquals(321, this.target.reverse(123));
        assertEquals(-321, this.target.reverse(-123));
        assertEquals(0, this.target.reverse(2147483646));
        assertEquals(811, this.target.reverse(1180));
    }

}
