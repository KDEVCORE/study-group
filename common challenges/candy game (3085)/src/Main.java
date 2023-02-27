import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    static String[][] board, temp;
    static boolean[][] visited;
    static int boardSize;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boardSize = Integer.parseInt(br.readLine());
        board = new String[boardSize][boardSize];
        temp = new String[boardSize][boardSize];
        for(int i=0; i<boardSize; i++) {
            String input = br.readLine();
            int j=0;
            for(char item: input.toCharArray()) {
                board[i][j++] = String.valueOf(item);
                for(int k=0; k<4; k++) {
                    int x1 = i + dx[k];
                    int y1 = j + dy[k];
                    if(x1 >= 0 && y1 >= 0 && x1 < boardSize && y1 < boardSize) {
                        // x,y 좌표와 색깔이 다를 경우 담아두기
                    }
                }
            }
        }
        int result = Integer.MIN_VALUE;
        for(int i=0; i<boardSize; i++) {
            for(int j=0; j<boardSize; j++) {
                visited = new boolean[boardSize][boardSize];
                temp = board.clone();
                for(int k=0; i<4; i++) {
                    int searchX = i + dx[k];
                    int searchY = j + dy[k];
                    if(searchX >=0 && searchY >=0 && searchX < boardSize && searchY < boardSize) {
                        if(valid(searchX, searchY, temp[i][j])) {
                            String color = temp[i][j];
                            temp[i][j] = temp[searchX][searchY];
                            temp[searchX][searchY] = color;
                            result = Math.max(result, bfs(searchX, searchY));
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
    private static boolean valid(int x, int y, String color) {
        return board[x][y].equals(color) ? false : true;
    }
    private static int bfs(int x, int y) {
        Queue<BoardInfo> queue = new LinkedList<>();
        queue.offer(new BoardInfo(x, y, 0));
        visited[x][y] = true;
        int sumC = 0, sumP = 0, sumZ = 0, sumY = 0;
        while(!queue.isEmpty()) {
            BoardInfo now = queue.poll();
            for(int i=0; i<4; i++) {
                int searchX = now.x + dx[i];
                int searchY = now.y + dy[i];
                if(searchX >=0 && searchY >=0 && searchX < boardSize && searchY < boardSize && !visited[searchX][searchY]) {
                    switch(board[searchX][searchY]) {
                        case "C":
                        sumC++;
                        break;
                        case "P":
                        sumP++;
                        break;
                        case "Z":
                        sumZ++;
                        break;
                        case "Y":
                        sumY++;
                        break;
                    }
                }
            }
        }
        return Math.max(sumC, Math.max(sumP, Math.max(sumZ, sumY)));
    }
}
class BoardInfo {
    int x, y, count;

    public BoardInfo(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}