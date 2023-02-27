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
            }
        }
        for(int i=0; i<boardSize; i++) {
            temp = board[i].clone();
            for(int j=0; j<boardSize; j++) {
                visited = new boolean[boardSize][boardSize];
                for(int k=0; i<4; i++) {
                    int searchX = i + dx[k];
                    int searchY = j + dy[k];
                    if(searchX >=0 && searchY >=0 && searchX < boardSize && searchY < boardSize) {
                        if(valid(searchX, searchY, board[i][j])) {
                            String temp = board[i][j];
                            board[i][j] = board[searchX][searchY];
                            board[searchX][searchY] = temp;
                        }
                    }
                }
            }
        }
        System.out.println();
    }
    private static boolean valid(int x, int y, String color) {
        return board[x][y].equals(color) ? false : true;
    }
    private static int bfs(int x, int y) {
        Queue<BoardInfo> queue = new LinkedList<>();
        queue.offer(new BoardInfo(x, y, 0));
        visited[x][y] = true;
        while(!queue.isEmpty()) {
            BoardInfo now = queue.poll();
            for(int i=0; i<4; i++) {
                int searchX = now.x + dx[i];
                int searchY = now.y + dy[i];
                if(searchX >=0 && searchY >=0 && searchX < boardSize && searchY < boardSize) {

                }
            }
        }
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