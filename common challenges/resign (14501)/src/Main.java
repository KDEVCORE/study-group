import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] schedules;
    static ArrayList<Integer> possible;
    static int dday;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dday = Integer.parseInt(br.readLine()); // 1 <= dday <= 15
        schedules = new int[dday + 1][2]; // 상담 일정
        possible = new ArrayList<>();
        for(int i=1; i<=dday; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            schedules[i][0] = Integer.parseInt(st.nextToken()); // 상담 기간, 1 <= schedules[i][0] <= 5
            schedules[i][1] = Integer.parseInt(st.nextToken()); // 상담 보수, 1 <= schedules[i][2] <= 1000
            if(dday - i + 1 >= schedules[i][0]) possible.add(i);
        }
        int result = Integer.MIN_VALUE;
        if(possible.size() > 0) { // 상담 업무를 할 수 있는 날의 개수
            for(int i: possible) {
                if(dday - i + 1 >= schedules[i][0]) {
                    result = Math.max(result, bfs(i));
                }
            }
        } else { // 상담 업무를 한 번도 할 수 없는 경우
            result = 0;
        }
        System.out.println(result);
    }
    public static int bfs(int uptime) {
        Queue<ConsultingInfo> queue = new LinkedList<>();
        queue.offer(new ConsultingInfo(schedules[uptime][0]+uptime, schedules[uptime][1]));
        int result = Integer.MIN_VALUE;
        while(!queue.isEmpty()) {
            ConsultingInfo now = queue.poll();
            result = Math.max(result, now.sum);
            for(int i=now.stack; i<=dday; i++) {
                if(possible.contains(i)) {
                    int stack = i + schedules[i][0];
                    int sum = now.sum + schedules[i][1];
                    queue.offer(new ConsultingInfo(stack, sum));
                }
            }
        }
        return result;
    }
}
class ConsultingInfo {
    int stack, sum;
    public ConsultingInfo(int time, int sum) {
        this.stack = time;
        this.sum = sum;
    }
}