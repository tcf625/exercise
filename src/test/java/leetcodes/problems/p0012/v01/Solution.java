package leetcodes.problems.p0012.v01;

class Solution {

    enum BASE {
        CDM(100), XLC(10), IVX(1),;

        final int range;
        final char base1;
        final char base5;
        final char base10;

        private BASE(int range) {
            this.range = range;
            char[] name = name().toCharArray();
            this.base1 = name[0];
            this.base5 = name[1];
            this.base10 = name[2];
        }

    }

    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        num = processM(result, num);
        num = processCD(result, num, BASE.CDM);
        num = processCD(result, num, BASE.XLC);
        num = processCD(result, num, BASE.IVX);
        return result.toString();
    }

    private int processM(StringBuilder result, int num) {
        if (num < 1000) {
            return num;
        } else if (num < 2000) {
            result.append("M");
        } else if (num < 3000) {
            result.append("MM");
        } else if (num < 4000) {
            result.append("MMM");
        }
        return num % 1000;
    }

    private int processCD(StringBuilder result, int num, BASE base) {
        if (num < base.range) {
            return num;
        }
        int x = num / base.range;
        switch (x) {
            case 1:
                result.append(base.base1);
                break;
            case 2:
                result.append(base.base1).append(base.base1);
                break;
            case 3:
                result.append(base.base1).append(base.base1).append(base.base1);
                break;
            case 4:
                result.append(base.base1).append(base.base5);
                break;
            case 5:
                result.append(base.base5);
                break;
            case 6:
                result.append(base.base5);
                result.append(base.base1);
                break;
            case 7:
                result.append(base.base5);
                result.append(base.base1).append(base.base1);
                break;
            case 8:
                result.append(base.base5);
                result.append(base.base1).append(base.base1).append(base.base1);
                break;
            case 9:
                result.append(base.base1).append(base.base10);
                break;
        }
        return num % base.range;
    }

}