import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    static int[][] storehouse;
    static boolean[][] visited;
    static int row, col, count, result;
    static ArrayList<StorehouseInfo> ripeTomatoes;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken()); // 2 <= row, col <= 1000
        row = Integer.parseInt(st.nextToken());
        storehouse = new int[row][col];
        ripeTomatoes = new ArrayList<StorehouseInfo>();
        int check = 0;
        for(int i=0; i<row; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<col; j++) {
                storehouse[i][j] = Integer.parseInt(st.nextToken());
                if(storehouse[i][j] == 1) ripeTomatoes.add(new StorehouseInfo(i, j));
                else if(storehouse[i][j] == 0) check++;
            }
        }
        result = 0; // 1(익은 토마토)이 최소 한 개 이상, 0(익지 않은 토마토)이 1개 미만이면 모두 익은 상태
        if(check > 0) { // 0(익지 않은 토마토)이 1개 이상인 경우
            visited = new boolean[row][col];
            bfsSpreadSimulation(); // 모두 익지 못하는 상황 체크, true인 경우 확산 계산
            if(check != count) result = -1;
        }
        System.out.println(result);
    }
    public static void bfsSpreadSimulation() {
        Queue<StorehouseInfo> queue = new LinkedList<StorehouseInfo>();
        for(StorehouseInfo item: ripeTomatoes) {
            queue.offer(new StorehouseInfo(item.x, item.y));
            visited[item.x][item.y] = true;
        }
        while(!queue.isEmpty()) {
            StorehouseInfo nowNode = queue.poll();
            for(int i=0; i<4; i++) {
                int x = nowNode.x + dx[i];
                int y = nowNode.y + dy[i];
                if(x>=0 && y>=0 && x<row && y<col && storehouse[x][y] == 0 && !visited[x][y]) {
                    storehouse[x][y] = storehouse[nowNode.x][nowNode.y] + 1;
                    result = Math.max(result, storehouse[x][y]) - 1;
                    count++;
                    visited[x][y] = true;
                    queue.offer(new StorehouseInfo(x, y));
                }
            }
        }
    }
}
class StorehouseInfo {
    int x, y;
    public StorehouseInfo(int x, int y) {
        this.x = x;
        this.y = y;
    }
}