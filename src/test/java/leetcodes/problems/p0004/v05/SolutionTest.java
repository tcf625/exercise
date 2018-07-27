package leetcodes.problems.p0004.v05;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

    //####################################################################
    //## [Method] Sub-block : find mid
    //####################################################################

    @Test
    public void test1() {
        final double findMedianSortedArrays = Solution.findMedianSortedArrays(makeArray(10, 11), makeArray(13));
        System.out.println(findMedianSortedArrays);
    }

    @Test
    public void test2() {
        final double findMedianSortedArrays = Solution.findMedianSortedArrays(makeArray(10, 11, 12), makeArray(10, 11, 12));
        System.out.println(findMedianSortedArrays);
    }

    //####################################################################
    //## [Method] Sub-block : find mid / special case
    //####################################################################

    @Test
    public void testFindMedianSortedArrays_single() {
        assertEquals(12.0, Solution.findMedianSortedArrays(makeArray(), makeArray(9, 11, 12, 13, 14)), 0.1);
        assertEquals(12.0, Solution.findMedianSortedArrays(makeArray(9, 11, 12, 13, 14), makeArray()), 0.1);

        assertEquals(12.5, Solution.findMedianSortedArrays(makeArray(), makeArray(11, 12, 13, 14)), 0.1);
        assertEquals(12.5, Solution.findMedianSortedArrays(makeArray(11, 12, 13, 14), makeArray()), 0.1);
    }

    @Test
    public void testFindMedianSortedArrays_Ordered() {
        assertEquals(12.0, Solution.findMedianSortedArrays(makeArray(10, 11, 12), makeArray(13, 14)), 0.1);
        assertEquals(12.0, Solution.findMedianSortedArrays(makeArray(10), makeArray(11, 12, 13, 14)), 0.1);
        assertEquals(12.5, Solution.findMedianSortedArrays(makeArray(11, 12), makeArray(13, 14)), 0.1);
        assertEquals(11.5, Solution.findMedianSortedArrays(makeArray(10), makeArray(11, 12, 13)), 0.1);
        assertEquals(11.5, Solution.findMedianSortedArrays(makeArray(10, 11, 12), makeArray(13)), 0.1);

    }

    //####################################################################
    //## [Method] Sub-block : search 
    //####################################################################

    private int[] makeArray(final int... array) {
        return array;
    }

    //####################################################################
    //## [Method] Sub-block : search outOfIndex
    //####################################################################

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testSearch_OutOfBounds1() {
        Solution.numOfLess(9, makeArray(10, 12), -1, 2);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testSearch_OutOfBounds2() {
        Solution.numOfLess(9, makeArray(10, 12), 0, 3);
    }

    //####################################################################
    //## [Method] Sub-block : largeSearch
    //####################################################################

    @Test
    public void testSearch_size1000() {
        final int[] makeArray = new int[1001];
        for (int i = 0; i < makeArray.length; i++) {
            makeArray[i] = i;
        }
        for (int i = 0; i < makeArray.length; i++) {
            assertEquals(i, Solution.numOfLess(i, makeArray, 0, 1001));
        }
        assertEquals(0, Solution.numOfLess(-1, makeArray, 0, 1001));
        assertEquals(0, Solution.numOfLess(-2, makeArray, 0, 1001));
        assertEquals(1000, Solution.numOfLess(1000, makeArray, 0, 1001));
        assertEquals(1001, Solution.numOfLess(1001, makeArray, 0, 1001));
        assertEquals(1001, Solution.numOfLess(1002, makeArray, 0, 1001));
    }

    //####################################################################
    //## [Method] Sub-block : search
    //####################################################################

    @Test
    public void testSearch_size1() {
        assertEquals(0, Solution.numOfLess(9, makeArray(10), 0, 1));
        assertEquals(0, Solution.numOfLess(10, makeArray(10), 0, 1));
        assertEquals(1, Solution.numOfLess(11, makeArray(10), 0, 1));
    }

    @Test
    public void testSearch_size2() {
        assertEquals(0, Solution.numOfLess(9, makeArray(10, 12), 0, 2));
        assertEquals(0, Solution.numOfLess(10, makeArray(10, 12), 0, 2));
        assertEquals(1, Solution.numOfLess(11, makeArray(10, 12), 0, 2));
        assertEquals(1, Solution.numOfLess(12, makeArray(10, 12), 0, 2));
        assertEquals(2, Solution.numOfLess(13, makeArray(10, 12), 0, 2));
    }

    @Test
    public void testSearch_size3() {
        for (int i = 9; i <= 15; i++) {
            assertEquals((i - 10 + 1) / 2, Solution.numOfLess(i, makeArray(10, 12, 14), 0, 3));
        }
    }

    //####################################################################
    //## [Method] Sub-block : search mid
    //####################################################################

    @Test
    public void testSearch_mid() {
        // 12 ~ 14
        assertEquals(1, Solution.numOfLess(11, makeArray(10, 12, 14, 16, 18), 1, 2));
        assertEquals(1, Solution.numOfLess(12, makeArray(10, 12, 14, 16, 18), 1, 2));
        assertEquals(2, Solution.numOfLess(13, makeArray(10, 12, 14, 16, 18), 1, 2));
        assertEquals(2, Solution.numOfLess(14, makeArray(10, 12, 14, 16, 18), 1, 2));
        assertEquals(3, Solution.numOfLess(15, makeArray(10, 12, 14, 16, 18), 1, 2));
        //        assertEquals("outbound", 1, Solution.numOfLess(11, makeArray(9, 12, 14, 16, 18), 1, 2));
        //        assertEquals("outbound", 5, Solution.numOfLess(16, makeArray(10, 12, 14, 16, 18), 1, 2));
        //        assertEquals("outbound", 5, Solution.numOfLess(17, makeArray(10, 12, 14, 16, 18), 1, 2));
    }

    //================================================
    //== [Enumeration Types] Block Start
    //== [Enumeration Types] Block End
    //================================================
    //== [Static Variables] Block Start
    //== [Static Variables] Block Stop
    //================================================
    //== [Instance Variables] Block Start
    //== [Instance Variables] Block Stop
    //================================================
    //== [Static Constructor] Block Start
    //== [Static Constructor] Block Stop
    //================================================
    //== [Constructors] Block Start (§tinit method)
    //== [Constructors] Block Stop
    //================================================
    //== [Static Method] Block Start
    //== [Static Method] Block Stop
    //================================================
    //== [Accessor] Block Start
    //== [Accessor] Block Stop
    //================================================
    //== [Overrided JDK Method] Block Start (Ex. toString / equals+hashCode)
    //== [Overrided JDK Method] Block Stop
    //================================================
    //== [Method] Block Start
    //####################################################################
    //## [Method] Sub-block :
    //####################################################################
    //== [Method] Block Stop
    //================================================
    //== [Inner Class] Block Start
    //== [Inner Class] Block Stop
    //================================================
}
