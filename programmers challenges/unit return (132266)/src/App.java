import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        int n = 5;
        int[][] roads = {{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}};
        int[] sources =	{1, 3, 5};
        int destination = 5;

        for(int item: new Solution().solution(n, roads, sources, destination)) {
            System.out.print(item + " ");
        }
    }
}
class Solution {
    static List<List<Integer>> edge;
    static int[] result;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        edge = new ArrayList<>();
        for(int i=0; i<=n; i++) edge.add(new ArrayList<>());

        for(int i=0; i<roads.length; i++) {
            int start = roads[i][0];
            int end = roads[i][1];
            edge.get(start).add(end);
            edge.get(end).add(start);
        }

        result = new int[n+1];
        Arrays.fill(result, -1);
        dijkstra(destination);
        int[] answer = new int[sources.length];
        for(int i=0; i<sources.length; i++) answer[i] = result[sources[i]];
        return answer;
    }

    public void dijkstra(int destination) {
        Queue<Node> queue = new ArrayDeque<>();
        result[destination] = 0;
        queue.add(new Node(destination, 0));
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            for(int i=0; i<edge.get(now.node).size(); i++) {
                int next = edge.get(now.node).get(i);
                if(result[next] < 0) {
                    result[next] = now.cost + 1;
                    queue.add(new Node(next, now.cost + 1));
                }
            }
        }
    }
}

class Node {
    int node, cost;
    public Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}