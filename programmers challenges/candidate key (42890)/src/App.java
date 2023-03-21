import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception {
        String[][] relation = {
                { "100", "ryan", "music", "2" },
                { "200", "apeach", "math", "2" },
                { "300", "tube", "computer", "3" },
                { "400", "con", "computer", "4" },
                { "500", "muzi", "music", "3" },
                { "600", "apeach", "music", "2" }
        };
        Solution sol = new Solution();
        System.out.println(sol.solution(relation));
    }
}

class Solution {
    boolean[] visited;
    int row, col;
    Set<String> combination = new HashSet<>(); // 조합(경우의 수)
    List<String> minimality = new ArrayList<>();

    public int solution(String[][] relation) {
        row = relation.length;
        col = relation[0].length;
        visited = new boolean[col];

        for (int i = 1; i <= col; i++) {
            backtracking(0, i, relation); // 가능한 조합 찾기
            validUniqueness(relation); // 유일성 판단
            combination.clear();
        }
        return minimality.size();
    }

    private void backtracking(int start, int r, String[][] relation) {
        if (r == 0) {
            String temp = "";
            for (int i = 0; i < col; i++)
                if (visited[i])
                    temp += i;
            combination.add(temp); // 조합(경우의 수) 추가
        }
        for (int i = start; i < col; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(start + 1, r - 1, relation); // index 증가 시키고, 조합 개수 감소 시키기
                visited[i] = false;
            }
        }
    }

    private void validUniqueness(String[][] relation) {
        for (String data : combination) { // 유일성 찾기
            Set<String> uniqueness = new HashSet<>();
            
            for (int i = 0; i < row; i++) {
                String concat = "";
                for (String j : data.split("")) concat += relation[i][Integer.parseInt(j)]; // 조합(경우의 수) 분해, 문자열 합체
                uniqueness.add(concat);
            }

            if (uniqueness.size() == row) { // 유일성 성립
                boolean flag = false;
                for (String childs : minimality) { // 최소성 찾기 (현재 추가된 최소성 요소부터)
                    int count = 0;
                    for (String child : childs.split(""))
                        if (data.contains(child)) // 유일성 비교군 값과 최소성 비교군 값이 존재하면
                            count++;
                    if (count == childs.length()) // 유일성 비교군과 일치하기 때문에, 최소성 성립 불가
                        flag = true;
                }
                if (!flag) // flag가 false면 최소성 성립
                    minimality.add(data); // 최소성 조합 추가
            }
        }
    }
}