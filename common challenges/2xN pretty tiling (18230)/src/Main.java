import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int typeA = Integer.parseInt(st.nextToken());
        int typeB = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> tilesA = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<typeA; i++) tilesA.offer(Integer.parseInt(st.nextToken()));
        PriorityQueue<Integer> tilesB = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<typeB; i++) tilesB.offer(Integer.parseInt(st.nextToken()));

        long result = Integer.MIN_VALUE, sum = 0;
        int stack = 0;
        PriorityQueue<Integer> used = new PriorityQueue<>();
        while(!tilesB.isEmpty()) { // 사용할 수 있는 B타일 합계
            int temp = tilesB.poll();
            sum += temp;
            used.offer(temp);
            stack += 2;
            if(size - stack < 2) break;
        }
        while(!tilesA.isEmpty() && size - stack > 0) {
            sum += tilesA.poll();
            stack += 1;
        }
        result = Math.max(result, sum); // 타일 모두 채웠을 때 합계
        
        if(used.size() > 0) {
            for(int item: used) {
                if(tilesA.size() < 2) break;
                int tile1 = tilesA.poll();
                int tile2 = tilesA.poll();
                if(item < tile1 + tile2) {
                    sum = (sum - item) + (tile1 + tile2);
                    result = Math.max(result, sum);
                } else break;
            }
        }
        System.out.println(result);
    }
}