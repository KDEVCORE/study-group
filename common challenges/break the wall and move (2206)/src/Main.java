import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    static int row, col;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new int[row][col];
        visited = new boolean[row][col];
        for(int i=0; i<row; i++) {
            String temp = br.readLine();
            for(int j=0; j<col; j++) map[i][j] = Integer.parseInt(temp.substring(j, j+1));
        }
        System.out.println(bfs(new MapInfo(0, 0, 1, true)));
    }
    public static int bfs(MapInfo start) {
        boolean[][] visitException = new boolean[row][col];
        Queue<MapInfo> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.x][start.y] = true;
        int result = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            MapInfo now = queue.poll();
            if(now.x == row-1 && now.y == col-1) return result = Math.min(result, now.z);
            for(int i=0; i<4; i++) {
                int x = now.x + dx[i];
                int y = now.y + dy[i];
                if(x >= 0 && y >= 0 && x < row && y < col) {
                    if(!visited[x][y]) {
                        visited[x][y] = true;
                        if(map[x][y] == 0) queue.offer(new MapInfo(x, y, now.z+1, now.chance));
                        if(map[x][y] == 1 && now.chance) queue.offer(new MapInfo(x, y, now.z+1, !now.chance));
                        if(!now.chance) visitException[x][y] = true;
                    } else {
                        if(visitException[x][y] && now.chance) {
                            visitException[x][y] = false;
                            queue.offer(new MapInfo(x, y, now.z+1, map[x][y] == 0 ? now.chance : !now.chance));
                        }
                    }
                }
            }
        }
        return -1;
    }
}
class MapInfo {
    int x, y, z;
    boolean chance;
    public MapInfo(int x, int y, int z, boolean chance) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.chance = chance;
    }
}