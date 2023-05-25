import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception {
        String s = "1 2 3 4"; // "1 4"
        // String s = "-1 -2 -3 -4"; // "-4 -1"
        // String s = "-1 -1"; // "-1 -1"
        System.out.println(new Solution().solution(s));
    }
}

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        while(st.hasMoreTokens()) {
            int temp = Integer.parseInt(st.nextToken());
            min = Math.min(min, temp);
            max = Math.max(max, temp);
        }
        return min + " " + max;
    }
}