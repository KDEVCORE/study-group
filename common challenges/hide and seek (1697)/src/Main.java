import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {2, -1, 1};
    static ArrayList<Integer>[] path;
    static boolean[] visited;
    static int first, target, timer, maximum = 100000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        first = Integer.parseInt(st.nextToken()); // 0 <= start <= 100000
        target = Integer.parseInt(st.nextToken()); // 0 <= target <= 100000
        if(first == target) System.out.println(0);
        else {
            path = new ArrayList[maximum + 1];
            for(int i=0; i<=maximum; i++) path[i] = new ArrayList<Integer>();
            visited = new boolean[maximum + 1];
            bfs(first);
            System.out.println(timer);
        }
    }
    public static void bfs(int point) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(point);
        visited[point] = true;
        timer = 0;
        int size = 0;
        while(!queue.isEmpty()) {
            timer++;
            size = queue.size();
            for(int j=0; j<size; j++) {
                int now = queue.poll();
                for(int i=0; i<3; i++) {
                    int x = (i == 0) ? now * dx[i] : now + dx[i];
                    if(x == target) {
                        visited[x] = true;
                        return;
                    }
                    if(x >= 0 && x <= maximum && !visited[x]) {
                        visited[x] = true;
                        queue.offer(x);
                    }
                }
            }
        }
    }
}
