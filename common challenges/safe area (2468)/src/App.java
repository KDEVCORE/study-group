import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// #2468 안전 영역
public class App {
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0}; // 네방향(상하좌우) 이동 좌표
    static int[][] area; // 영역 배열
    static boolean[][] visited; // 방문 체크 배열
    static int length; // 행과 열, row = col (정사각형)
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        length = Integer.parseInt(br.readLine()); // 2 <= length <= 200
        area = new int[length][length];
        int maxCount = 0;
        ArrayList<Integer> height = new ArrayList<>(); // 영역 안의 높이 저장용 리스트
        for(int i=0; i<length; i++) { // 영역 length(row)만큼 반복
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<length; j++) {
                area[i][j] = Integer.parseInt(st.nextToken()); // 높이, 1 <= area[i][j] <= 100
                if(!height.contains(area[i][j])) height.add(area[i][j]); // 이미 저장된 height(높이)가 아니면 리스트에 추가
            }
        }
        if(height.size() > 1) { // height 리스트 크기가 1 초과(2개 이상)일 경우
            for (int item: height) {
                visited = new boolean[length][length];
                int count = 0;
                for(int i=0; i<length; i++) {
                    for(int j=0; j<length; j++) {
                        if(area[i][j] > item && !visited[i][j] && dfs(i, j, item)) count++; // area배열 값(높이) 중에서 item(높이)보다 크고 방문하지 않은 좌표고 DFS 결과가 참일 경우, 안전 영역 1 증가
                    }
                }
                maxCount = Math.max(maxCount, count); // 안전 영역 최댓값 저장
            }
        } else maxCount = 1; // height 리스트 크기가 1 이하일 경우 안전구역 최댓값 1
        System.out.println(maxCount);
    }
    public static boolean dfs(int x, int y, int z) {
        if(visited[x][y]) return false;
        visited[x][y] = true;
        for(int i=0; i<4; i++) { // 네방향 반복
            int a = x + dx[i];
            int b = y + dy[i];
            if(a>=0 && b>=0 && a<length && b<length && area[a][b] > z) dfs(a, b, z); // 좌표 유효성 체크, 해당 영역값이 z(높이)보다 크면 DFS 진행
        }
        return true;
    }
}