import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] cities;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cityNumber = Integer.parseInt(br.readLine()); // 도시 번호, cityNumber <= 200
        cities = new int[cityNumber + 1];
        for(int i=1; i<=cityNumber; i++) cities[i] = i; // 도시 번호 초기화
        int schedule = Integer.parseInt(br.readLine()); // 여행할 도시 수, tourCities <= 1000
        StringTokenizer st;
        for(int i=1; i<=cityNumber; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=cityNumber; j++) {
                if(st.nextToken().equals("1")) union(i, j); // 1(연결 도시)인 경우, union 연산
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<schedule; i++) {
            int x = find(Integer.parseInt(st.nextToken())); // 여행 계획 도시
            if(!result.contains(x)) result.add(x); // 같은 그룹이 아니면 추가
        }
        System.out.println(result.size() == 1 ? "YES" : "NO");
    }
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) cities[b] = a;
    }
    public static int find(int x) {
        if(x == cities[x]) return x;
        else return cities[x] = find(cities[x]);
    }
}