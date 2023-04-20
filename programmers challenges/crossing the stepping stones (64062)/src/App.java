import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        System.out.println(new Solution().solution(stones, k));
    }
}

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int min = 1, max = Arrays.stream(stones).max().getAsInt();
        while(min <= max) {
            int mid = (min + max) / 2;
            int interval = 0;
            for(int i=0; i<stones.length; i++) {
                if(stones[i] < mid) {
                    interval++;
                    if(interval >= k) break;
                } else {
                    interval = 0;
                }
            }
            if(interval < k) {
                answer = mid;
                min = mid+1;
            } else max = mid-1;
        }
        
        return answer;
    }
}