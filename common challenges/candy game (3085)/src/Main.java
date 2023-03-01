import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    static char[][] board, temp;
    static boolean[][] visited;
    static int boardSize;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boardSize = Integer.parseInt(br.readLine());
        board = new char[boardSize][boardSize];
        temp = new char[boardSize][boardSize];
        for(int i=0; i<boardSize; i++) {
            String input = br.readLine();
            int j=0;
            for(char item: input.toCharArray()) board[i][j++] = item;
        }
        for(int x=0; x<boardSize; x++) temp[x] = board[x].clone();

        int result = Integer.MIN_VALUE;
        int sumC = 0, sumP = 0, sumZ = 0, sumY = 0;
        for(int i=0; i<boardSize; i++) {
            for(int j=0; j<boardSize; j++) {
                for(int k=0; k<4; k++) {
                    int kx = i + dx[k];
                    int ky = j + dy[k];
                    if(kx >= 0 && ky >= 0 && kx < boardSize && ky < boardSize && temp[i][j] != temp[kx][ky]) {
                        char item = temp[kx][ky];
                        temp[kx][ky] = temp[i][j];
                        temp[i][j] = item;
                        sumC = search('C');
                        sumP = search('P');
                        sumZ = search('Z');
                        sumY = search('Y');
                        result = Math.max(result, Math.max(sumC, Math.max(sumP, Math.max(sumZ, sumY))));
                        for(int x=0; x<boardSize; x++) temp[x] = board[x].clone();
                    }
                }
            }
        }
        System.out.println(result);
    }
    private static int search(char item) {
        int result = Integer.MIN_VALUE, rowSum = 0, colSum = 0, index = 0;
        while(index < boardSize) {
            int count = 0;
            for(int j=0; j<boardSize; j++) {
                if(item == temp[index][j]) count++;
                else {
                    rowSum = Math.max(rowSum, count);
                    count = 0;
                }
            }
            rowSum = Math.max(rowSum, count);
            count = 0;
            for(int i=0; i<boardSize; i++) {
                if(item == temp[i][index]) count++;
                else {
                    colSum = Math.max(colSum, count);
                    count = 0;
                }
            }
            colSum = Math.max(colSum, count);
            result = Math.max(result, Math.max(rowSum, colSum));
            index++;
        }
        return result;
    }
}