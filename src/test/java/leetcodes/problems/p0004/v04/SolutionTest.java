package leetcodes.problems.p0004.v04;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

    //####################################################################
    //## [Method] Sub-block : find mid
    //####################################################################

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
        Solution.search(9, makeArray(10, 12), -1, 2);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testSearch_OutOfBounds2() {
        Solution.search(9, makeArray(10, 12), 0, 3);
    }

    //####################################################################
    //## [Method] Sub-block : largeSearch
    //####################################################################

    @Test
    public void testSearch_size1000() {
        final int[] makeArray = new int[1001];
        for (int i = 0; i < makeArray.length; i++) {
            makeArray[i] = i * 2;
        }
        for (int i = 0; i < makeArray.length; i++) {
            assertEquals(i, Solution.search(i, makeArray, 0, 1001));
        }
        assertEquals(-1, Solution.search(-1, makeArray, 0, 1001));
        assertEquals(-1, Solution.search(-2, makeArray, 0, 1001));
        assertEquals(2000, Solution.search(2000, makeArray, 0, 1001));
        assertEquals(2001, Solution.search(2001, makeArray, 0, 1001));
        assertEquals(2001, Solution.search(2002, makeArray, 0, 1001));
    }

    //####################################################################
    //## [Method] Sub-block : search
    //####################################################################

    @Test
    public void testSearch_size1() {
        assertEquals(-1, Solution.search(9, makeArray(10), 0, 1));
        assertEquals(0, Solution.search(10, makeArray(10), 0, 1));
        assertEquals(1, Solution.search(11, makeArray(10), 0, 1));
    }

    @Test
    public void testSearch_size2() {
        assertEquals(-1, Solution.search(9, makeArray(10, 12), 0, 2));
        assertEquals(0, Solution.search(10, makeArray(10, 12), 0, 2));
        assertEquals(1, Solution.search(11, makeArray(10, 12), 0, 2));
        assertEquals(2, Solution.search(12, makeArray(10, 12), 0, 2));
        assertEquals(3, Solution.search(13, makeArray(10, 12), 0, 2));
    }

    @Test
    public void testSearch_size3() {
        for (int i = 9; i <= 15; i++) {
            assertEquals(i - 10, Solution.search(i, makeArray(10, 12, 14), 0, 3));
        }
    }

    //####################################################################
    //## [Method] Sub-block : search mid
    //####################################################################

    @Test
    public void testSearch_mid() {
        // 12 ~ 14
        assertEquals(1, Solution.search(11, makeArray(10, 12, 14, 16, 18), 1, 2));
        assertEquals(2, Solution.search(12, makeArray(10, 12, 14, 16, 18), 1, 2));
        assertEquals(3, Solution.search(13, makeArray(10, 12, 14, 16, 18), 1, 2));
        assertEquals(4, Solution.search(14, makeArray(10, 12, 14, 16, 18), 1, 2));
        assertEquals(5, Solution.search(15, makeArray(10, 12, 14, 16, 18), 1, 2));
        assertEquals("outbound", 1, Solution.search(11, makeArray(9, 12, 14, 16, 18), 1, 2));
        assertEquals("outbound", 5, Solution.search(16, makeArray(10, 12, 14, 16, 18), 1, 2));
        assertEquals("outbound", 5, Solution.search(17, makeArray(10, 12, 14, 16, 18), 1, 2));
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
