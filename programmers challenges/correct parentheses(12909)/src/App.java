public class App {
    public static void main(String[] args) throws Exception {
        // String s = "()()"	;    // true
        // String s = "(())()";	//true
        // String s = ")()("	;    // false
        // String s = "(()("	;    // false
        String s = "())(()"; // false
        System.out.println(new Solution().solution(s));
    }
}

class Solution {
    boolean solution(String s) {
        if(s.charAt(0) == ')' || s.length() % 2 == 1) return false;

        int count = 0;
        for(char c: s.toCharArray()) {
            if(c == '(') count++;
            else {
                if(count == 0) return false;
                else count--;
            }
        }
        return count == 0 ? true : false;
    }
}