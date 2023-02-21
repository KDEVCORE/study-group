import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

        long sum = 0;
        int stack = 0;
        ArrayList<Integer> resultB = new ArrayList<>();
        while(!tilesB.isEmpty() && size - stack > 1) {
            resultB.add(tilesB.poll());
            stack += 2;
        }
        Collections.sort(resultB);
        while(!tilesA.isEmpty() && size - stack > 0) {
            sum += tilesA.poll();
            stack += 1;
        }
        for(int item: resultB) {
            int temp = 0;
            if(tilesA.size() > 1) {
                for(int i=0; i<2; i++) temp += tilesA.poll();
                if(temp> item) item = temp;
            }
            sum += item;
        }
        System.out.println(sum);
    }
}