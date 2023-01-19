import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    static int[][] map;
    static boolean[][] visited;
    static int length, areaNum, count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        length = Integer.parseInt(br.readLine()); // 5 <= length <= 25
        map = new int[length][length];
        visited = new boolean[length][length];
        for(int i=0; i<length; i++) {
            String info = br.readLine();
            int j=0;
            for (char item : info.toCharArray()) {
                map[i][j] = Character.getNumericValue(item);
                j++;
            }
        }
        areaNum = 0;
        ArrayList<Integer> total = new ArrayList<Integer>();
        for(int i=0; i<length; i++) {
            for(int j=0; j<length; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    areaNum++;
                    count = 1;
                    bfs(i, j);
                    total.add(count);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(areaNum + "\n");
        Collections.sort(total);
        for(Integer item: total) sb.append(item + "\n");
        System.out.print(sb);
    }
    public static void bfs(int x, int y) {
        Queue<ComplexInfo> queue = new LinkedList<ComplexInfo>();
        queue.offer(new ComplexInfo(x, y));
        visited[x][y] = true;
        while(!queue.isEmpty()) {
            ComplexInfo nowNode = queue.poll();
            for(int i=0; i<4; i++) {
                int x1 = nowNode.x + dx[i];
                int y1 = nowNode.y + dy[i];
                if(x1>=0 && y1>=0 && x1<length && y1<length && map[x1][y1]==1) {
                    if(!visited[x1][y1]) {
                        visited[x1][y1] = true;
                        count++;
                        queue.offer(new ComplexInfo(x1, y1));
                    }
                }
            }
        }
    }
}
class ComplexInfo {
    int x;
    int y;
    public ComplexInfo(int x, int y) {
        this.x = x;
        this.y = y;
    }
}