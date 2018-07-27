package leetcodes.problems.p0007.v01;

class Solution {
    public int reverse(int x) {

        String text = String.valueOf(x);
        char[] charArray = text.toCharArray();
        char[] tmp = new char[charArray.length];

        int start = 0;
        if (x < 0) {
            tmp[0] = charArray[0];
            start = 1;
        }

        int end = charArray.length - 1;
        for (int i = start; i < tmp.length; i++) {
            tmp[i] = charArray[end--];
        }
        try {
            return Integer.parseInt(new String(tmp));
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}