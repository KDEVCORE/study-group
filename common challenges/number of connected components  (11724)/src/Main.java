import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] component;
    static boolean[] visited;
    static int node, edge, count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken()); // 1 ≤ node ≤ 1000
        edge = Integer.parseInt(st.nextToken()); // 0 ≤ edge ≤ node×(node-1)/2
        component = new ArrayList[node + 1];
        for(int i=1; i<=node; i++) component[i] = new ArrayList<Integer>();
        for(int j=0; j<edge; j++) {
            st = new StringTokenizer(br.readLine()); // 1 <= start, end <= node, start != end
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            component[start].add(end);
            component[end].add(start);
        }
        visited = new boolean[node + 1];
        for(int i=1; i<=node; i++) {
            if(!visited[i]) {
                count++;
                bfs(i);
            }
        }
        System.out.println(count);
    }
    public static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(node);
        visited[node] = true;
        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(Integer item: component[now]) {
                if(!visited[item]) {
                    visited[item] = true;
                    queue.offer(item);
                }
            }
        }
    }
}
