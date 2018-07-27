package leetcodes.problems.p0009.v01;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        }
        int origin = x;
        int b = 0;
        while (x > 0) {
            int n = x % 10;
            x = x / 10;
            b = b * 10 + n;
        }
        return origin == b;
    }
}