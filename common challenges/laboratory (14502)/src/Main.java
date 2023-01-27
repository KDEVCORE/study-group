import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    static int[][] labMap;
    static int row, col, maxSafeZone;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken()); // 3 <= row, col <= 8
        col = Integer.parseInt(st.nextToken());
        labMap = new int[row][col];
        for(int i=0; i<row; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<col; j++) labMap[i][j] = Integer.parseInt(st.nextToken());
        }
        dfsVirusBarrierSimulation(0);
        System.out.println(maxSafeZone);
    }
    public static void dfsVirusBarrierSimulation(int installed) {
        if(installed == 3) {
            bfsVirusSpreadSimulation();
            return;
        }
        for(int i=0; i<row; i++) for(int j=0; j<col; j++) if(labMap[i][j] == 0) {
            labMap[i][j] = 1;
            dfsVirusBarrierSimulation(installed+1);
            labMap[i][j] = 0;
        }
    }
    public static void bfsVirusSpreadSimulation() {
        int copyMap[][] = new int[row][col];
        Queue<LabInfo> queue = new LinkedList<LabInfo>();
        for(int i=0; i<row; i++) {
            copyMap[i] = labMap[i].clone();
            for(int j=0; j<col; j++) if(labMap[i][j] == 2) queue.offer(new LabInfo(i, j));
        }

        while(!queue.isEmpty()) {
            LabInfo nowNode = queue.poll();
            for(int i=0; i<4; i++) {
                int x = nowNode.x + dx[i];
                int y = nowNode.y + dy[i];
                if(x >= 0 && y >= 0 && x < row && y < col && copyMap[x][y] == 0) {
                    copyMap[x][y] = 2;
                    queue.offer(new LabInfo(x, y));
                }
            }
        }
        int safeZone = 0;
        for(int i=0; i<row; i++) for(int j=0; j<col; j++) if(copyMap[i][j] == 0) safeZone++;
        maxSafeZone = Math.max(maxSafeZone, safeZone);
    }
}
class LabInfo {
    int x, y;
    public LabInfo(int x, int y) {
        this.x = x;
        this.y = y;
    }
}