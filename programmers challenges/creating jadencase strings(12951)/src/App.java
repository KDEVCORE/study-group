import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception {
        String s = "3people unFollowed me"; //	"3people Unfollowed Me"
        // String s = "for the last week"; //	"For The Last Week"
        System.out.println(new Solution().solution(s));
    }
}

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        StringTokenizer st = new StringTokenizer(s, " ", true);
        while(st.hasMoreTokens()) {
            String temp = st.nextToken();
            if(" ".equals(temp)) sb.append(temp);
            else sb.append(temp.substring(0, 1).toUpperCase() + temp.substring(1));
        }
        return sb.toString();
    }
}