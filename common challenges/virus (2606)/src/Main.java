import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] connections;
    static boolean[] visited;
    static int infected;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeComputer = Integer.parseInt(br.readLine()); // 1 <= nodeComputer <= 100
        int edgeNetwork = Integer.parseInt(br.readLine());
        connections = new ArrayList[nodeComputer + 1];
        visited = new boolean[nodeComputer+1];
        for (int i=0; i<connections.length; i++) connections[i] = new ArrayList<Integer>();
        for(int i=0; i<edgeNetwork; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            connections[s].add(e);
            connections[e].add(s);
        }
        infected = 0;
        bfs(1);
        System.out.println(infected);
    }
    public static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;
        while(!queue.isEmpty()) {
            int nowNode = queue.poll();
            for (Integer item : connections[nowNode]) {
                if(!visited[item]) {
                    visited[item] = true;
                    infected++;
                    queue.offer(item);
                }
            }
        }
    }
}
