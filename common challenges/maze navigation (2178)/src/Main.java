import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    static int[][] maze;
    static boolean[][] visited;
    static int row, col;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        maze = new int[row][col];
        visited = new boolean[row][col];
        for(int i=0; i<row; i++) {
            String info = br.readLine();
            for(int j=0; j<col; j++) maze[i][j] = Integer.parseInt(info.substring(j, j+1));
        }
        bfs(0, 0);
        System.out.println(maze[row-1][col-1]);
    }
    public static void bfs(int x, int y) {
        Queue<MazeInfo> queue = new LinkedList<MazeInfo>();
        queue.offer(new MazeInfo(x, y));
        visited[x][y] = true;
        while(!queue.isEmpty()) {
            MazeInfo now = queue.poll();
            for(int i=0; i<4; i++) {
                int x1 = now.x + dx[i];
                int y1 = now.y + dy[i];
                if(x1>=0 && y1>=0 && x1<row && y1<col && maze[x1][y1]!=0 && !visited[x1][y1]) {
                    visited[x1][y1] = true;
                    maze[x1][y1] = maze[now.x][now.y] + 1;
                    queue.offer(new MazeInfo(x1, y1));
                }
            }
        }
    }
}
class MazeInfo {
    int x, y;
    public MazeInfo(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
