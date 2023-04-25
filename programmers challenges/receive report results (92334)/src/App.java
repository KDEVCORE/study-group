import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        for(Integer item: new Solution().solution(id_list, report, k)) {
            System.out.print(item + " ");
        }
    }
}
class Solution {
    public ArrayList<Integer> solution(String[] id_list, String[] report, int k) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashSet<String> sets = new HashSet<>();
        for(String item: report) sets.add(item);
        
        ArrayList<Report> reportList = new ArrayList<>();
        Map<String, Integer> banMap = new LinkedHashMap<>();
        Map<String, Integer> resultMap = new LinkedHashMap<>();
        for(int i=0; i<id_list.length; i++) {
            banMap.put(id_list[i], 0);
            resultMap.put(id_list[i], 0);
        }
        for(String item: sets) {
            StringTokenizer st = new StringTokenizer(item);
            String accuser = st.nextToken();
            String accused = st.nextToken();
            reportList.add(new Report(accuser, accused));
            banMap.put(accused, banMap.get(accused) + 1);
        }
        for(Entry<String, Integer> entry: banMap.entrySet()) {
            if(entry.getValue() >= k) {
                for(Report item: reportList) {
                    if(entry.getKey().equals(item.accused)) resultMap.put(item.accuser, resultMap.get(item.accuser) + 1);
                }
            }
        }
        for(Entry<String, Integer> result: resultMap.entrySet()) answer.add(result.getValue());
        return answer;
    }
}

class Report {
    String accuser, accused;
    public Report(String accuser, String accused) {
        this.accuser = accuser;
        this.accused = accused;
    }
}