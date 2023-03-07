import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] works = new int[Integer.parseInt(st.nextToken())];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<works.length; i++) works[i] = Integer.parseInt(st.nextToken());

        Solution solution = new Solution();
        System.out.println(solution.solution(n, works));
    }
}
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        if(Arrays.stream(works).sum() <= n) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<works.length; i++) pq.offer(works[i]);
        
        while(n > 0) {
            if(pq.peek() > 0) {
                int temp = pq.poll();
                pq.offer(temp-1);
                n--;
            }
        }
        while(!pq.isEmpty()) answer += Math.pow(pq.poll(), 2);
        return answer;
    }
}