public class App {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        int[][] board = {
            {5,5,5,5,5},
            {5,5,5,5,5},
            {5,5,5,5,5},
            {5,5,5,5,5}
        };
        int[][] skill = {
            {1,0,0,3,4,4},
            {1,2,0,2,3,2},
            {2,1,0,3,1,2},
            {1,0,1,3,3,1}
        };
        System.out.println(sol.solution(board, skill));
    }
}
class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int row = board.length;
        int col = board[0].length;
        int[][] temp = new int[row+1][col+1];
        for(int i=0; i<skill.length; i++) {
            int type = skill[i][0];
            int row1 = skill[i][1];
            int col1 = skill[i][2];
            int row2 = skill[i][3];
            int col2 = skill[i][4];
            int degree = skill[i][5];
            if(type == 1) {
                temp[row1][col1] -= degree;
                temp[row1][col2+1] += degree;
                temp[row2+1][col1] += degree;
                temp[row2+1][col2+1] -= degree;
            } else {
                temp[row1][col1] += degree;
                temp[row1][col2+1] -= degree;
                temp[row2+1][col1] -= degree;
                temp[row2+1][col2+1] += degree;
            }
        }
        for(int j=0; j<col+1; j++) {
            for(int i=0; i<row; i++) {
                temp[i+1][j] += temp[i][j];
            }
        }
        for(int i=0; i<row+1; i++) {
            for(int j=0; j<col; j++) {
                temp[i][j+1] += temp[i][j];
            }
        }

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                board[i][j] += temp[i][j];
                if(board[i][j] > 0) answer++;
            }
        }
        return answer;
    }
}