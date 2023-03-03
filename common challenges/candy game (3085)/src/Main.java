import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    static char[][] board;
    static int boardSize;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boardSize = Integer.parseInt(br.readLine());
        board = new char[boardSize][boardSize];
        for(int i=0; i<boardSize; i++) {
            String input = br.readLine();
            int j=0;
            for(char item: input.toCharArray()) board[i][j++] = item;
        }

        char[] color = {'C', 'P', 'Z', 'Y'};
        int result = Integer.MIN_VALUE, sum = 0;
        for(int i=0; i<boardSize; i++) {
            for(int j=0; j<boardSize; j++) {
                for(int k=0; k<4; k++) {
                    int kx = i + dx[k];
                    int ky = j + dy[k];
                    if(kx >= 0 && ky >= 0 && kx < boardSize && ky < boardSize && board[i][j] != board[kx][ky]) {
                        char temp = board[kx][ky];
                        board[kx][ky] = board[i][j];
                        board[i][j] = temp;
                        for(int c=0; c<color.length; c++) {
                            sum = search(color[c]);
                            result = Math.max(result, sum);
                        }
                        temp = board[kx][ky];
                        board[kx][ky] = board[i][j];
                        board[i][j] = temp;
                    }
                }
            }
        }
        System.out.println(result);
    }
    private static int search(char item) {
        int maxSum = Integer.MIN_VALUE, index1 = 0;
        while(index1 < boardSize) {
            int countRow = 0, countCol = 0, index2 = 0;
            while(index2 < boardSize) {
                if(item == board[index1][index2]) countRow++;
                else {
                    maxSum = Math.max(maxSum, countRow);
                    countRow = 0;
                }
                if(item == board[index2][index1]) countCol++;
                else {
                    maxSum = Math.max(maxSum, countCol);
                    countCol = 0;
                }
                index2++;
            }
            maxSum = Math.max(maxSum, Math.max(countRow, countCol));
            index1++;
        }
        return maxSum;
    }
}