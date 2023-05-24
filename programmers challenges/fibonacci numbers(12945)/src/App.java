public class App {
    public static void main(String[] args) throws Exception {
        // int n = 3; // 2
        // int n = 5; // 5
        int n = 100000;
        System.out.println(new Solution().solution(n));
    }
}
class Solution {
    public int solution(int n) {
        int[] fibonacci = new int[n+1];
        for(int i=0; i<=n; i++) {
            fibonacci[i] = i <= 1 ? i : (fibonacci[i-2] + fibonacci[i-1]) % 1234567;
        }
        return fibonacci[n];
    }
}