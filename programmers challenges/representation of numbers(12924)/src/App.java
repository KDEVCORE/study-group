public class App {
    public static void main(String[] args) throws Exception {
        int n = 15;
        System.out.println(new Solution().solution(n));
    }
}

class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i=1; i<n; i++) {
            if(dfs(i, n)) answer++;
        }
        return answer+1;
    }
    
    private boolean dfs(int number, int limit) {
        int sum = 0;
        while(sum < limit) {
            sum += number++;
        }
        return sum == limit ? true : false;
    }
}