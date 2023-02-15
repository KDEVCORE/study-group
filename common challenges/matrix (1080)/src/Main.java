import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] matrixA, matrixB;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        matrixA = new boolean[row][col];
        matrixB = new boolean[row][col];
        for(int i=0; i<row; i++) {
            String data = br.readLine();
            int j = 0;
            for(char item: data.toCharArray()) {
                matrixA[i][j] = Character.getNumericValue(item) == 0 ? false : true;
                j++;
            }
        }
        for(int i=0; i<row; i++) {
            String data = br.readLine();
            int j = 0;
            for(char item: data.toCharArray()) {
                matrixB[i][j] = Character.getNumericValue(item) == 0 ? false : true;
                j++;
            }
        }
        int count = 0;
        for(int i=0; i<row-3+1; i++) {
            for(int j=0; j<col-3+1; j++) {
                if(matrixA[i][j] != matrixB[i][j]) {
                    converter(i, j);
                    count++;
                }
            }
        }
        System.out.println(Arrays.deepEquals(matrixA, matrixB) ? count : -1);
    }
    public static void converter(int x, int y) {
        for(int i=x; i<x+3; i++) {
            for(int j=y; j<y+3; j++) {
                matrixA[i][j] = !matrixA[i][j];
            }
        }
    }
}
