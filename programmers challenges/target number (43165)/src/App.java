import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] temp = new int[number];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<number; i++) temp[i] = Integer.parseInt(st.nextToken());

        Solution solution = new Solution();
        System.out.println(solution.solution(temp, target));
    }
}

class Solution {
    int[] numbers;
    int target, answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        this.numbers = numbers.clone();
        this.target = target;
        searchDepth(0, 0);
        return answer;
    }
    private void searchDepth(int depth, int count) {
        if(depth == numbers.length-1) {
            if(count+numbers[depth] == target || count-numbers[depth] == target) answer++;
            return;
        }
        searchDepth(depth+1, count+numbers[depth]);
        searchDepth(depth+1, count-numbers[depth]);
    }
}