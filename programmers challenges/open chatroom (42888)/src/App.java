import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        for (String solution : sol.solution(record)) {
            System.out.println(solution);
        }
    }
}
class Solution {
    public ArrayList<String> solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();
        ArrayList<Action> actionList = new ArrayList<>();
        HashMap<String, String> member = new HashMap<>();
        String action = "", id = "", nick = "";
        for(int i=0; i<record.length; i++) {
            StringTokenizer st = new StringTokenizer(record[i], " ");
            action = st.nextToken();
            id = st.nextToken();
            if(!"Leave".equals(action)) {
                nick = st.nextToken();
                member.put(id, nick);
            }
            actionList.add(new Action(action, id));
        }

        for(Action item: actionList) {
            String act = "";
            switch(item.action) {
                case "Enter":
                    act = "들어왔습니다.";
                    answer.add(member.get(item.id)+"님이 " + act);
                    break;
                case "Leave":
                    act = "나갔습니다.";
                    answer.add(member.get(item.id)+"님이 " + act);
                    break;
            }

        }
        return answer;
    }
}
class Action {
    String action, id;
    public Action(String action, String id) {
        this.action = action;
        this.id = id;
    }
}