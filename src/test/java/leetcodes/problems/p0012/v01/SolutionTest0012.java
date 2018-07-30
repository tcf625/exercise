package leetcodes.problems.p0012.v01;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest0012 {
    Solution target = new Solution();

    @Test
    public void test_1000() {
        assertEquals("M", this.target.intToRoman(1000));
        assertEquals("MM", this.target.intToRoman(2000));
        assertEquals("MMM", this.target.intToRoman(3000));
    }

    @Test
    public void test_100() {
        assertEquals("C", this.target.intToRoman(100));
        assertEquals("CC", this.target.intToRoman(200));
        assertEquals("CCC", this.target.intToRoman(300));
        assertEquals("CD", this.target.intToRoman(400));
        assertEquals("DCCC", this.target.intToRoman(800));
        assertEquals("CM", this.target.intToRoman(900));
    }

    @Test
    public void test_10() {
        assertEquals("X", this.target.intToRoman(10));
        assertEquals("XX", this.target.intToRoman(20));
        assertEquals("XXX", this.target.intToRoman(30));
        assertEquals("XL", this.target.intToRoman(40));
        assertEquals("LXXX", this.target.intToRoman(80));
        assertEquals("XC", this.target.intToRoman(90));
    }

    @Test
    public void testCase() {
        assertEquals("IV", this.target.intToRoman(4));
        assertEquals("III", this.target.intToRoman(3));
        assertEquals("IX", this.target.intToRoman(9));
        assertEquals("LVIII", this.target.intToRoman(58));
        assertEquals("MCMXCIV", this.target.intToRoman(1994));
    }
}