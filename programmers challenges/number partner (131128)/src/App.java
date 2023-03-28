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
        String[] x = {"5525"}, y = {"1255"};

        for(int i=0; i<x.length; i++) {
            System.out.println(sol.solution(x[i], y[i]));
        }
    }
}
class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        int[] countX = new int[10], countY = new int[10];
        int index = 0;
        while(index < Math.max(X.length(), Y.length())) {
            if(index < X.length()) countX[Character.getNumericValue(X.charAt(index))]++;
            if(index < Y.length()) countY[Character.getNumericValue(Y.charAt(index))]++;
            index++;
        }
        for(int i=9; i>=0; i--) {
            for(int j=0; j<Math.min(countX[i], countY[i]); j++) answer.append(i);
        }
        return answer.toString().isEmpty() ? "-1" : answer.toString().charAt(0) == '0' ? "0" : answer.toString();
    }
}