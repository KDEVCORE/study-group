import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] search;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken()); // 1 <= node <= 1000
        int edge = Integer.parseInt(st.nextToken()); // 1 <= edge <= 10000
        int first = Integer.parseInt(st.nextToken());
        search = new ArrayList[node + 1];
        for(int i=1; i<=node; i++) search[i] = new ArrayList<Integer>();
        for(int i=1; i<=edge; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            search[start].add(end);
            search[end].add(start);
        }
        for(int i=1; i<=node; i++) Collections.sort(search[i]);
        visited = new boolean[node + 1];
        dfs(first);
        visited = new boolean[node + 1];
        sb.append("\n");
        bfs(first);
        System.out.print(sb);
    }
    public static void dfs(int node) {
        if(visited[node]) return;
        sb.append(node + " ");
        visited[node] = true;
        for(int item: search[node]) if(!visited[item]) dfs(item);
    }

    public static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(node);
        visited[node] = true;
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            sb.append(temp + " ");
            for(int item: search[temp]) {
                if(!visited[item]) {
                    visited[item] = true;
                    queue.offer(item);
                }
            }
        }
    }
}