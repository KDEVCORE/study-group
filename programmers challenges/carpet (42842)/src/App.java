import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        for(int item: sol.solution(24, 24)) {
            System.out.println(item);
        }
    }
}
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        ArrayList<Carpet> divisor = new ArrayList<>();
        int total = brown + yellow;
        int count = 3;
        while(count <= total/count) {
            if(total % count == 0) divisor.add(new Carpet(total/count, count));
            count++;
        }
        for(Carpet item: divisor) {
            int countBrown = 0, countYellow = 0;
            for(int i=0; i<item.length; i++) {
                for(int j=0; j<item.width; j++) {
                    if(i == 0 || j == 0 || i == item.length-1 || j == item.width-1) countBrown++;
                    else countYellow++;
                }
            }
            if(countBrown == brown && countYellow == yellow) {
                answer[0] = item.width;
                answer[1] = item.length;
                break;
            }
        }
        return answer;
    }
}
class Carpet {
    int width, length;
    
    public Carpet(int width, int length) {
        this.width = width;
        this.length = length;
    }
}