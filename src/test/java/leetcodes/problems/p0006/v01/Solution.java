package leetcodes.problems.p0006.v01;

/**
 * 6. ZigZag Conversion
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 */
class Solution {

    //  USE TIME = 2:58~3:22

    /**
     *
     * <PRE>
     * PAYPALISHIRING
     * 6     6
     *  4   2 4
     *   2 4   2
     *    6     6
     *
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     * </PRE>
     */
    public String convert(final String s, final int numRows) {
        if (numRows <= 1) {
            return s;
        }
        final int firstSkip = (numRows - 1) * 2;
        final StringBuilder tmp = new StringBuilder(s.length());
        final char[] charArray = s.toCharArray();
        for (int i = 0; i < numRows; i++) {
            int pos = i;
            final int s1 = (i < (numRows - 1)) ? firstSkip - (i * 2) : firstSkip;
            final int s2 = (i > 0 && i < (numRows - 1)) ? firstSkip - s1 : firstSkip;
            while (true) {
                if (pos < charArray.length) {
                    tmp.append(charArray[pos]);
                    pos += s1;
                } else {
                    break;
                }
                if (pos < charArray.length) {
                    tmp.append(charArray[pos]);
                    pos += s2;
                } else {
                    break;
                }
            }
        }
        return tmp.toString();
    }

}