import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// #2468 안전 영역
public class App {
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    static int[][] area;
    static boolean[][] visited;
    static int length;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        length = Integer.parseInt(br.readLine()); // 행과 열, 2 <= length <= 200
        area = new int[length][length];
        int maxHeight = 0, maxCount = 0;
        ArrayList<Integer> height = new ArrayList<>();
        for(int i=0; i<length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<length; j++) {
                area[i][j] = Integer.parseInt(st.nextToken()); // 높이, 1 <= area[i][j] <= 100
                if(!height.contains(area[i][j])) height.add(area[i][j]);
                maxHeight = Math.max(maxHeight, area[i][j]);
            }
        }
        if(height.size() > 1) {
            for (Integer item: height) {
                visited = new boolean[length][length];
                int count = 0;
                for(int i=0; i<length; i++) {
                    for(int j=0; j<length; j++) {
                        if(area[i][j] > item && !visited[i][j]) {
                            if(dfs(i, j, item)) count++;
                        }
                    }
                }
                maxCount = Math.max(maxCount, count);
            }
        } else {
            maxCount = 1;
        }
        System.out.println(maxCount);
    }
    public static boolean dfs(int x, int y, int z) {
        if(visited[x][y]) return false;
        visited[x][y] = true;
        for(int i=0; i<4; i++) {
            int a = x + dx[i];
            int b = y + dy[i];
            if(a>=0 && b>=0 && a<length && b<length && area[a][b] > z) {
                dfs(a, b, z);
            }
        }
        return true;
    }
}
