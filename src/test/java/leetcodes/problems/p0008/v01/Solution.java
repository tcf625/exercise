package leetcodes.problems.p0008.v01;

class Solution {

    static java.util.regex.Pattern p1 = java.util.regex.Pattern.compile("^ *(-\\d+)");
    static java.util.regex.Pattern p2 = java.util.regex.Pattern.compile("^ *\\+?(\\d+)");

    public int myAtoi(String str) {

        final int max_check = Integer.MAX_VALUE / 10;
        char[] charArray = str.toCharArray();

        int pos = 0;
        int signed = 1;
        while (pos < charArray.length) { // skip space        
            char c = charArray[pos];
            if (c == ' ') {
                pos++;
            } else if (c == '-') {
                signed = -1;
                pos++;
                break;
            } else if (c == '+') {
                pos++;
                break;
            } else {
                break;
            }
        }

        int tmpValue = 0;
        while (pos < charArray.length) { // skip space        

            char n = charArray[pos++];

            if (n >= '0' && n <= '9') {
                int dec = (n - '0');
                if (tmpValue > max_check) {
                    return (signed == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                } else if (tmpValue == max_check) {
                    if (signed == 1) {
                        if (dec > 7)
                            return Integer.MAX_VALUE;
                    } else if (signed == -1) {
                        if (dec > 8)
                            return Integer.MIN_VALUE;
                    }
                }
                tmpValue = tmpValue * 10 + (n - '0');
            } else {
                break;
            }
        }
        return tmpValue * signed;
    }

    public int myAtoi_regex(String str) {
        {
            java.util.regex.Matcher matcher = p1.matcher(str);
            if (matcher.find()) {
                String group = matcher.group(1);
                try {
                    return Integer.parseInt(group);
                } catch (NumberFormatException e) {
                    return Integer.MIN_VALUE;
                }
            }
        }
        {
            java.util.regex.Matcher matcher = p2.matcher(str);
            if (matcher.find()) {
                String group = matcher.group(1);
                try {
                    return Integer.parseInt(group);
                } catch (NumberFormatException e) {
                    return Integer.MAX_VALUE;
                }
            }
        }
        return 0;

    }

}