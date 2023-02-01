import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {1, 2, 1, 2, -1, -2, -1, -2}, dy = {2, 1, -2, -1, 2, 1, -2, -1};
    static int[][] chessboard;
    static boolean[][] visited;
    static int length;
    static ChessboardInfo startPosition, targetPosition;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine()); // 테스트케이스
        StringBuilder sb = new StringBuilder();
        for(int c=0; c<testCase; c++) {
            int x1, y1, x2, y2;
            length = Integer.parseInt(br.readLine()); // 체스판 한 변의 길이, 4 <= length <= 300
            chessboard = new int[length][length];
            visited = new boolean[length][length];
            StringTokenizer st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            startPosition = new ChessboardInfo(x1, y1, 0); // 출발 칸
            st = new StringTokenizer(br.readLine());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            targetPosition = new ChessboardInfo(x2, y2, 0); // 도착 칸
            sb.append(bfs(startPosition, targetPosition) + "\n");
        }
        System.out.print(sb);
    }
    public static int bfs(ChessboardInfo start, ChessboardInfo target) {
        Queue<ChessboardInfo> queue = new LinkedList<ChessboardInfo>();
        queue.offer(start);
        int count = 0;
        while(!queue.isEmpty()) {
            ChessboardInfo now = queue.poll();
            if(now.x == target.x && now.y == target.y) {
                count = now.z;
                break;
            }
            for(int i=0; i<8; i++) {
                int x = now.x + dx[i];
                int y = now.y + dy[i];
                int z = now.z; // 깊이 변수
                if(x>=0 && y>=0 && x<length && y<length && !visited[x][y]) {
                    visited[x][y] = true;
                    queue.offer(new ChessboardInfo(x, y, z+1));
                }
            }
        }
        return count;
    }
}
class ChessboardInfo {
    int x, y, z;
    public ChessboardInfo(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}