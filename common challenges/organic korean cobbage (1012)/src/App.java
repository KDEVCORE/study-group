import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// #1012 유기농 배추
// 입력 값: 테스트 케이스(t), 배추밭의 가로 길이(col), 배추밭의 세로 길이(row), 배추가 심어져 있는 위치 개수(k),
//         배추가 심어져 있는 위치 좌표(x, y)
// 설계: 인접행렬, 가중치 없는 그래프, 너비 우선 탐색(BFS) -> 깊이 우선 탐색(DFS)
// 과정
//  실패1. 가로, 세로가 있는 x, y 형태의 좌표인 2차원 배열로 그래프 표현했지만, 너비 우선 탐색 구현 못함
//  실패2. (책에 있는) '#2178 미로 탐색하기'문제 참고, 너비 우선 탐색으로 구현하려 했으나 조건문 판단이 되지 않음
//  실패3. 너비 우선 탐색 포기, 깊이 우선 탐색으로 전환하여 구현, 기본 틀은 책을 참고하여 조건문 수정
public class App {
    static int[] dx = {0, 1, 0, -1}; // 좌우 탐색
    static int[] dy = {1, 0, -1, 0}; // 상하 탐색
    static boolean[][] field; // 배추밭(2차원 배열)
    static boolean[][] visited; // 방문 확인용 배열
    static int row, col, count; // row(행, 세로 길이(n)), col(열, 가로 길이(m)), count(필요한 지렁이)
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t > 0) { // 테스트 케이스 반복
            StringTokenizer st = new StringTokenizer(br.readLine());
            col = Integer.parseInt(st.nextToken()); // 1 <= col <= 50
            row = Integer.parseInt(st.nextToken()); // 1 <= row <= 50
            int k = Integer.parseInt(st.nextToken()); // 심어져 있는 배추의 개수, 1 <= k <= 2500
            field = new boolean[row][col];
            visited = new boolean[row][col];
            count = 0;
            for(int i=0; i<row; i++) { // 배열 초기화
                for(int j=0; j<col; j++) {
                    field[i][j] = false;
                    visited[i][j] = false;
                }
            }
            for(int i=0; i<k; i++) { // 심어진 배추 위치 반영
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                field[x][y] = true;
            }
            for(int i=0; i<row; i++) { // 처음부터 끝까지 탐색
                for(int j=0; j<col; j++) {
                    if(field[i][j] && !visited[i][j]) { // 배추가 심어진 배열 좌표 and 방문하지 않은 배열 좌표
                        if(dfs(i, j)) count++; // 탐색 결과 = true, count 1 증가
                    }
                }
            }
            sb.append(count + "\n");
            t--;
        }
        System.out.println(sb);
    }
    public static boolean dfs(int x, int y) {
        if(visited[x][y]) return false; // 방문한 좌표면, 탐색 결과 = false
        visited[x][y] = true; // 방문 체크
        for (int i=0; i<4; i++) { // 상하좌우 탐색
            int a = x + dx[i]; // a: row 탐색용 임시 좌표
            int b = y + dy[i]; // b: col 탐색용 임시 좌표

            if (a >= 0 && b >= 0 && a < row && b < col && field[a][b]) { // 유효한 좌표, 심어진 배추 위치 체크
                dfs(a, b); // 재귀 함수 구현
            }
        }
        return true;
    }
}