import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        for (int item : sol.solution(gems)) {
            System.out.println(item);
        }
    }
}
class Solution {
    public int[] solution(String[] gems) {
        HashSet<String> set = new HashSet<>(Arrays.asList(gems));
        HashMap<String, Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        if(set.size() == 1) return new int[]{1,1};

        int start=0, tmp_start=0;
        int min_distance = Integer.MAX_VALUE;

        for(String gem: gems) {
            queue.add(gem);
            map.put(gem, map.getOrDefault(gem, 0)+1); // key:gem, value: map에 key값이 있으면 gem, 없으면 기본값 0

            while(true) {
                String tmp = queue.peek();
                if(map.get(tmp) > 1) {
                    map.put(tmp, map.get(tmp)-1);
                    queue.poll();
                    tmp_start++;
                } else break;
            }

            if(map.size() == set.size() && min_distance > queue.size()) {
                min_distance = queue.size();
                start = tmp_start;
            }
        }

        return new int[]{start+1, start+min_distance};
    }
}