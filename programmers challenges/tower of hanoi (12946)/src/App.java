import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        int n = 3;
        for (int[] items: sol.solution(n)) {
            for(int item: items) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}
class Solution {
    ArrayList<Route> route = new ArrayList<>();
    public int[][] solution(int n) {
        shift(1, 3, n);
        int[][] answer = new int[route.size()][2];
        int i = 0;
        for(Route item: route) {
            answer[i][0] = item.start;
            answer[i][1] = item.end;
            i++;
        }
        return answer;
    }
    private void shift(int start, int end, int count) {
        if(count == 1){
            route.add(new Route(start, end));
            return;
        }
        int empty = 6-start-end;
        shift(start, empty, count-1);
        route.add(new Route(start, end));
        shift(empty, end, count-1);
    }
}
class MySolution {
    Queue<Integer>[] queue = new Queue[3];
    ArrayList<Route> route = new ArrayList<>();
    public int[][] solution(int n) {
        for(int i=0; i<queue.length; i++) queue[i] = new LinkedList<>();
        int count = 1;
        while(count <= n) queue[0].offer(count++);
        while(queue[2].size() < n) {
            for(int i=0; i<queue.length; i++) {
                if(n % 2 == 0) {
                    if(shift(i, false)) break;
                } else {
                    if(shift(i, true)) break;
                }
            }
        }
        int[][] answer = new int[route.size()][2];
        int i = 0;
        for(Route item: route) {
            answer[i][0] = item.start;
            answer[i][1] = item.end;
            i++;
        }
        return answer;
    }
    private boolean shift(int start, boolean direction) {
        int end = 0;
        if(queue[start].peek() != null) {
            boolean temp = queue[start].peek() % 2 == 0 ? true : false;
            if(!direction) {
                if(temp) end = start-1 < 0 ? 2 : start-1;
                else end = start+1 > 2 ? 0 : start+1;
            } else {
                if(temp) end = start+1 > 2 ? 0 : start+1;
                else end = start-1 < 0 ? 2 : start-1;
            }
            if(queue[end].isEmpty()){
                queue[end].offer(queue[start].poll());
                route.add(new Route(start+1, end+1));
                return true;
            } else {
                if(queue[end].peek() > queue[start].peek()) {
                    queue[end].offer(queue[start].poll());
                    route.add(new Route(start+1, end+1));
                    return true;
                }
            }
        }
        return false;
    }
}
class Route {
    int start, end;
    
    public Route(int start, int end) {
        this.start = start;
        this.end = end;
    }
}