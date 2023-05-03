import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};
        for(int item: new Solution().solution(enroll, referral, seller, amount)) {
            System.out.print(item + " ");
        }
    }
}

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        Map<String, Integer> nodeMap = new HashMap<>();
        Map<String, String> edgeMap = new HashMap<>();

        for(int i=0; i<enroll.length; i++) {
            nodeMap.put(enroll[i], i);
            edgeMap.put(enroll[i], referral[i]);
        }

        for(int i=0; i<seller.length; i++) {
            String now = seller[i];
            int profit = 100 * amount[i];
            
            while(!now.equals("-")){
                int temp = profit - (profit / 10);
                answer[nodeMap.get(now)] += temp;
                now = edgeMap.get(now);
                profit /= 10;

                if(profit < 1) break;
            }
        }

        return answer;
    }
}