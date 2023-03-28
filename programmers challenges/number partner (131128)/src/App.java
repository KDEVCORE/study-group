import java.util.Arrays;
import java.util.Collections;

public class App {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        /*
        "100"	"2345"	"-1"
        "100"	"203045"	"0"
        "100"	"123450"	"10"
        "12321"	"42531"	"321"
        "5525"	"1255"	"552"
        */
        String[] x = {"100"}, y = {"2345"};

        for(int i=0; i<x.length; i++) {
            System.out.println(sol.solution(x[i], y[i]));
        }
    }
}
class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        int[] count = new int[10];
        for(int i=9; i>=0; i--) {
            String temp = String.valueOf(i);
            int cx = (int) X.chars().filter(x -> temp.equals(Character.toString(x))).count();
            int cy = (int) Y.chars().filter(y -> temp.equals(Character.toString(y))).count();
            count[i] = Math.min(cx, cy);
            while(count[i] > 0) {
                answer += i;
                count[i]--;
            }
        }
        return answer.isEmpty() ? "-1" : answer.charAt(0) == '0' ? "0" : answer;
    }
}