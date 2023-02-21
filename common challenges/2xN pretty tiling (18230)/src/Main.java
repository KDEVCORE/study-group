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
        int flag = size > 2*typeB ? typeB : size / 2;
        PriorityQueue<Integer> used = new PriorityQueue<>();
        for(int i=1; i<=flag; i++) { // 사용할 수 있는 B타일 합계
            int temp = tilesB.poll();
            used.offer(temp);
            sum += temp;
        }
        for(int i=1; i<=size-2*flag; i++) {
            sum += tilesA.poll(); // A타일 합계
        }
        result = Math.max(result, sum); // 타일 모두 채웠을 때 합계
        
        if(tilesA.size() > 1) { // 잔여 A타일이 2개 이상일 경우, 기존 B타일 1개와 비교 로직
            for(int item: used) { // 사용했던 B타일
                while(!tilesA.isEmpty()) { // 최댓값 검증
                    int tile1 = tilesA.poll();
                    int tile2 = tilesA.poll();
                    if(tile1+tile2 > item) {
                        sum = (sum - item) + (tile1 + tile2);
                        result = Math.max(result, sum); // 타일 모두 채웠을 때 합계
                    } else { // A타일 2개(큰 값)와 B타일 1개(작은 값) 비교 성립이 안 되는 경우, 종료
                        System.out.println(result);
                        return;
                    }
                }
                if(tilesA.isEmpty()) break; // A타일이 없을 경우, 사용했던 타일 비교 종료
            }
        }
        System.out.println(result);
    }
}