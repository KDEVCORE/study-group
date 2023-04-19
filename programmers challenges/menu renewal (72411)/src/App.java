import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) throws Exception {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}; // "AC", "ACDE", "BCFG", "CDE"
        int[] course = {2,3,4};
        StringBuilder sb = new StringBuilder();
        for(String item: new Solution().solution(orders, course)) {
            sb.append(item + " ");
        }
        System.out.println(sb);
    }
}
class Solution {
    public ArrayList<String> solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        HashSet<String> sets = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String order: orders) {
            int n = order.length();
            for(int i=1; i<(1<<n); i++) {
                String temp = "";
                for(int j=0; j<n; j++) {
                    if((i & (1<<j)) > 0) {
                        temp += order.charAt(j);
                    }
                }
                temp = Stream.of(temp.split("")).sorted().collect(Collectors.joining());
                if(temp.length() > 1) sets.add(temp);
            }
            for(String set: sets) {
                int count = set.length();
                for(int i=0; i<set.length(); i++) {
                    if(order.contains(String.valueOf(set.charAt(i)))) count--;
                }
                if(count == 0) map.put(set, map.getOrDefault(set, 0) + 1);
            }
        }
        for(int count: course) {
            int temp = 2;
            Queue<String> queue = new LinkedList<>();
            for(Entry<String,Integer> entry : map.entrySet()) {
                if(entry.getKey().length() == count && temp <= entry.getValue()) {
                    if(temp < entry.getValue()) {
                        temp = entry.getValue();
                        queue.clear();
                    }
                    queue.offer(entry.getKey());
                }
            }
            if(queue.size() > 0) for(String item: queue) answer.add(item);
        }
        Collections.sort(answer);
        return answer;
    }
}