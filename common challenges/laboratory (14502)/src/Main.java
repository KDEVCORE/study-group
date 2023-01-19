import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    static int[][] labMap, labMapClone;
    static boolean[][] visited;
    static int row, col, countSafeArea, maxSafeArea;
    static ArrayList<LabInfo> virus;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        labMap = new int[row][col];
        visited = new boolean[row][col];
        for(int i=0; i<row; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<col; j++) {
                labMap[i][j] = Integer.parseInt(st.nextToken());
                if(labMap[i][j] == 2) virus.add(new LabInfo(i, j, labMap[i][j]));
            }
        }
        labMapClone = labMap;
        // 벽 3개 세우는 로직 필요
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(!visited[i][j] && labMapClone[i][j] == 1) {

                }
            }
        }
        for(LabInfo item : virus) {
            if(!visited[item.x][item.y] && labMap[item.x][item.y] == 2) bfsVirusSpreadSimulation(item.x, item.y, labMap[item.x][item.y]);
        };
    }
    public static void bfsVirusSpreadSimulation(int x, int y, int level) {
        Queue<LabInfo> queue = new LinkedList<>();
        queue.offer(new LabInfo(x, y, level));
        visited[x][y] = true;
        while(!queue.isEmpty()) {
            LabInfo nowNode = queue.poll();
            for(int i=0; i<4; i++) {
                int x1 = nowNode.x + dx[i];
                int y1 = nowNode.y + dy[i];
                if(x1>=0 && y1>=0 && x1<row && y1<col && labMapClone[x1][y1] == 0) {
                    labMapClone[x1][y1] = 2;
                    visited[x1][y1] = true;
                    queue.offer(new LabInfo(x1, y1, labMapClone[x1][y1]));
                }
            }
        }
    }
}
class LabInfo {
    int x, y, weight;
    public LabInfo(int x, int y, int weight) {
        this.x = x;
        this.y = y;
        this.weight = weight;
    }
}