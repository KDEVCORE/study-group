import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        System.out.println(sol.solution(15, 3, 2));
    }
}
class Solution {
    public int solution(int number, int limit, int power) {
        ArrayList<Integer> divisor = new ArrayList<>();
        int count = 1;
        while(count <= number) {
            int temp = calcPower(count);
            divisor.add(temp > limit ? power : temp);
            count++;
        }
        return divisor.stream().mapToInt(Integer::intValue).sum();
    }
    private int calcPower(int number) {
        if(number == 1) return 1;
        int divisor = 2, result = 2;
        while(divisor <= number/2) {
            if(number % divisor == 0) result++;
            divisor++;
        }
        return result;
    }
}