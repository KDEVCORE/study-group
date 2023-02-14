import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cardNumber = Integer.parseInt(st.nextToken());
        int combinationCount = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 1; i <= cardNumber; i++) {
            pq.offer(Long.parseLong(st.nextToken()));
        }
        if(combinationCount == 0) {
            System.out.println(pq.stream().mapToLong(e -> e).sum());
            return;
        }
        while (combinationCount > 0) {
            long now1 = pq.poll();
            long now2 = pq.poll();
            long sum = now1 + now2;
            pq.offer(sum);
            pq.offer(sum);
            combinationCount--;
        }
        System.out.println(pq.stream().mapToLong(e -> e).sum());
    }
}