import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        String[] timetable = { "23:59" };
        int n = 1, t = 1, m = 1;
        System.out.println(sol.solution(n, t, m, timetable));
    }
}

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(String data : timetable) {
            StringTokenizer st = new StringTokenizer(data, ":");
            pq.offer(Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken())); // 탑승 시간 분 단위 데이터 환산, 오름차순 정렬
        }
     
        int std_time = 9 * 60; // 기준 시간 분 단위 환산
        int last_time = 0; // 최대한 늦게 타는 시간
        int count = 0; // 탑승 인원 계산
        for(int i = 0; i < n; i++) { // 운행 횟수 반복문
            count = 0;    
            while(!pq.isEmpty()) {
                int deadline = pq.peek(); // 현재 선두 탑승자의 시간
                if(deadline <= std_time && count < m) { // 선두 사람의 탑승 시간이 기준 시간보다 작고 탑승 가능 인원이 1보다 클 때
                    pq.poll();
                    count++;
                } else break;  // 선두 사람의 탑승 시간이 첫차
                last_time = deadline - 1; // 늦게 타는 시간 중간 집계
            }
            std_time += t; // 기준 시간 변경, 운행 간격 반영 (운행 횟수 기준 동안 반복)
        }
        if(count < m) last_time = std_time - t; // 탑승 인원이 남았을 경우, 타는 시간 변경. 기준 시간에서 앞 차의 운행 시간으로
        
        String hour = String.format("%02d", last_time / 60); // last_time / 60 < 10 ? "0" + last_time / 60 : last_time / 60
        String minute = String.format("%02d", last_time % 60); // last_time % 60 < 10 ? "0" + last_time % 60 : last_time % 60
        return hour + ":" + minute;
    }
}