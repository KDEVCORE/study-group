import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class App {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] field;
    static boolean[][] visited;
    static int row, col, count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t > 0) { // 테스트 케이스 반복
            StringTokenizer st = new StringTokenizer(br.readLine());
            col = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            field = new boolean[row][col];
            visited = new boolean[row][col];
            count = 0;
            for(int i=0; i<row; i++) { // 배열 초기화
                for(int j=0; j<col; j++) {
                    field[i][j] = false;
                    visited[i][j] = false;
                }
            }
            for(int i=0; i<k; i++) { // 배추가 심어진 위치 반영
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                field[x][y] = true;
            }
            for(int i=0; i<row; i++) {
                for(int j=0; j<col; j++) {
                    if(field[i][j] && !visited[i][j]) {
                        if(dfs(i, j)) count++;
                    }
                }
            }
            sb.append(count + "\n");
            t--;
        }
        System.out.println(sb);
    }
    public static boolean dfs(int x, int y) {
        if(visited[x][y]) return false;
        visited[x][y] = true;
        for (int i=0; i<4; i++) {
            int a = x + dx[i];
            int b = y + dy[i];

            if (a >= 0 && b >= 0 && a < row && b < col && field[a][b]) {
                dfs(a, b);
            }
        }
        return true;
    }
}