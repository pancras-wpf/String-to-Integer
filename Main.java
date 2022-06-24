package 字符串转整型;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int a = solution.myAtoi("  -42");
        System.out.println(a);
    }
}
class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;

        int res = 0;
        int i = 0;

        while (i < s.length() && s.charAt(i) == ' ') i++;
        if (i >= s.length()) return 0;

        boolean neg = true;
        if (s.charAt(i) == '-') {
            neg = false;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int pre = res;
            res = res * 10 + (s.charAt(i) - '0');
            if (pre != res / 10) return neg ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            i++;
        }

        return neg ? res : -res;
    }
}