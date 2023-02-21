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
        int temp = size > 2*typeB ? typeB : size / 2, flag = 0;
        PriorityQueue<Integer> used = new PriorityQueue<>();
        while(!tilesB.isEmpty() && flag < temp) { // B타일 합계
            int pretty = tilesB.poll();
            used.offer(pretty);
            sum += pretty;
            flag++;
        }
        flag = 0;
        while(!tilesA.isEmpty() && flag < size-2*temp) {
            sum += tilesA.poll(); // A타일 합계
            flag++;
        }
        result = Math.max(result, sum); // 타일 모두 채웠을 때 합계
        
        if(tilesA.size() < 2) {
            System.out.println(result);
        } else {
            for(int item: used) { // 사용했던 B타일
                while(!tilesA.isEmpty()) { // 최댓값 검증
                    int tile1 = tilesA.poll();
                    int tile2 = tilesA.poll();
                    if(tile1+tile2 > item) {
                        sum = (sum - item) + (tile1 + tile2);
                        result = Math.max(result, sum); // 타일 모두 채웠을 때 합계
                    } else {
                        System.out.println(result);
                        return;
                    }
                }
            }
        }
    }
}