import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        // int[] order = {4, 3, 1, 2, 5};
        // int[] order = {5, 4, 3, 2, 1};
        // int[] order = {3, 2, 1, 4, 5}; // 5
        int[] order = {2, 1, 4, 3, 6, 5, 8, 7, 10, 9}; // 10
        System.out.println(new Solution().solution(order));
    }
}
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> sub = new Stack<>();
        int index = 0;
        for(int i=1; i<=order.length; i++) {
            while(!sub.isEmpty()) {
                if(sub.peek() == order[index]) {
                    sub.pop();
                    index++;
                    answer++;
                } else if(sub.peek() == i) {
                    sub.pop();
                    answer++;
                } else break;
            }
            if(order[index] == i) {
                index++;
                answer++;
            } else {
                sub.push(i);
            }
        }

        while(!sub.empty()) {
            if(order[index++] == sub.pop()) answer++;
            else break;
        }

        // Queue<Integer> orderQ = new LinkedList<>();
        // Stack<Integer> sub = new Stack<>();
        // for(int item: order) orderQ.offer(item);
        // for(int i=1; i<=order.length; i++) {
        //     while(!sub.isEmpty()) {
        //         if(sub.peek() == orderQ.peek()) {
        //             sub.pop();
        //             orderQ.poll();
        //             answer++;
        //         } else if(sub.peek() == i) {
        //             sub.pop();
        //             answer++;
        //         } else break;
        //     }
        //     if(orderQ.poll() == i) {
        //         orderQ.poll();
        //         answer++;
        //     } else {
        //         sub.push(i);
        //     }
        // }

        // while(!sub.empty()) {
        //     if(orderQ.poll() == sub.pop()) answer++;
        //     else break;
        // }

        return answer;
    }
}