import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int cities, tourCities;
    static ArrayList<CityInfo>[] connectionInfo;
    static ArrayList<CityInfo> schedules;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cities = Integer.parseInt(br.readLine()); // cities <= 200
        tourCities = Integer.parseInt(br.readLine()); // tourCites <= 1000
        connectionInfo = new ArrayList[cities + 1];
        StringTokenizer st;
        for(int i=1; i<=cities; i++) {
            connectionInfo[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=cities; j++) connectionInfo[i].add(Integer.parseInt(st.nextToken()));
        }
        schedules = new ArrayList<ScheduleInfo>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=tourCities; i++) temp.add(Integer.parseInt(st.nextToken()));
        for(int i=0; i<temp.size(); i++) {
            if(i<(temp.size()-1)) schedules.add(new ScheduleInfo(temp.get(i), temp.get(i+1)));
        }
        System.out.println(bfsTourSimulation() ? "YES" : "NO");
    }
    public static boolean bfsTourSimulation() {
        boolean flag = false;
        Queue<ScheduleInfo> queue = new LinkedList<>();
        for(ScheduleInfo schedule: schedules) queue.offer(schedule);
        while(!queue.isEmpty()) {
            ScheduleInfo now = queue.poll();
            for(int item: connectionInfo[now.departure]) {
                if(item == now.arrival) {
                    connectionInfo[now.departure].set
                    flag = true;
                    queue.clear();
                    break;
                }
            }
        }
        return flag;
    }
}
class CityInfo {
    int arrival, connection;
    public CityInfo(int arrival, int connection) {
        this.arrival = arrival;
        this.connection = connection;
    }
}