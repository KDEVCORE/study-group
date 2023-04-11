import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        String expression = "100-200*300-500+20";
        System.out.println(new Solution().solution(expression));
    }
}

class Solution {
    public long solution(String expression) {
        long answer = 0;
        String[][] priority = {
            { "*", "+", "-" }, { "*", "-", "+" },
            { "+", "*", "-" }, { "+", "-", "*" },
            { "-", "*", "+" }, { "-", "+", "*" }};
        ArrayList<String> exp = new ArrayList<String>();
        int start = 0;
        for(int i=0; i<expression.length(); i++) { // 숫자, 연산자 분리
            switch (expression.charAt(i)) {
                case '*':
                case '+':
                case '-':
                    exp.add(expression.substring(start, i));
                    exp.add(String.valueOf(expression.charAt(i)));
                    start = i + 1;
                    break;
            }
        }
        exp.add(expression.substring(start));

        for(int i=0; i<priority.length; i++) {
            ArrayList<String> temp = new ArrayList<String>(exp);
            for(int j=0; j<3; j++) {
                for(int k=0; k<temp.size(); k++) {
                    if(priority[i][j].equals(temp.get(k))) {
                        Long result = calc(Long.parseLong(temp.get(k - 1)), Long.parseLong(temp.get(k + 1)), temp.get(k));
                        temp.set(k - 1, result.toString());
                        temp.remove(k);
                        temp.remove(k);
                        k--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(Long.parseLong(temp.get(0))));
        }
        return answer;
    }

    private Long calc(Long num1, Long num2, String operator) {
        switch(operator) {
            case "*":
                return num1 * num2;
            case "+":
                return num1 + num2;
            default:
                return num1 - num2;
        }
    }
}
