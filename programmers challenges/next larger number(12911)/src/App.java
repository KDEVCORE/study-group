public class App {
    public static void main(String[] args) throws Exception {
        // int n = 78; // 83
        // int n = 15; // 23
        int n = 999999;
        System.out.println(new Solution().solution(n));
    }
}
class Solution {
    public int solution(int n) {
        String binaryN = Integer.toBinaryString(n);
        int count1 = 0, count2 = 0, answer = n;
        for(char c: binaryN.toCharArray()) if(c == '1') count1++;
        while(count1 != count2) {
            count2 = 0;
            answer++;
            String binaryT = Integer.toBinaryString(answer);
            for(char c: binaryT.toCharArray()) if(c == '1') count2++;
        }
        return answer;
    }
}