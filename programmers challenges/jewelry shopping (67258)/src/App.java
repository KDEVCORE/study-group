import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

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
        List<String> list = Arrays.stream(gems).distinct().collect(Collectors.toList()); // HashSet 대체 가능
        HashMap<String, Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        if(list.size() == 1) return new int[]{1, 1}; // 보석 종류가 하나라면

        int start = 0, startMarker = 0;
        int section = Integer.MAX_VALUE;

        for(String gem: gems) {
            queue.add(gem);
            map.put(gem, map.getOrDefault(gem, 0)+1); // key:gem, value: map에 key값이 있으면 gem, 없으면 기본값 0

            while(map.get(queue.peek()) > 1) {
                String tmp = queue.peek();
                map.put(tmp, map.get(tmp)-1);
                queue.poll();
                startMarker++;
            }

            if(map.size() == list.size() && section > queue.size()) { // 진열대에서 담은 상태의 보석 종류 수(map)와 보석 종류 수(list)가 같고, 현재 진열대 구간(section)보다 새로 입력될 진열대 구간(queue)이 작으면
                start = startMarker;
                section = queue.size();
            }
        }

        return new int[]{start+1, start+section};
    }
}