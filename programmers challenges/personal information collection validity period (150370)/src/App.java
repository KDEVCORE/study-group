import java.util.ArrayList;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        // String today = "2022.05.19";
        // String[] x1 = {"A 6", "B 12", "C 3"};
        // String[] x2 = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        String today = "2022.12.28";
        String[] x1 = {"A 12"};
        String[] x2 = {"2021.12.28 A"};
        for(int item: sol.solution(today, x1, x2)) {
            System.out.print(item + "\n");
        }
    }
}
class Solution {
    static ArrayList<Terms> termsList;
    static int baseYear, baseMonth, baseDay;
    public ArrayList<Integer> solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(today, ".");
        baseYear = Integer.parseInt(st.nextToken());
        baseMonth = Integer.parseInt(st.nextToken());
        baseDay = Integer.parseInt(st.nextToken());
        termsList = new ArrayList<>();
        for(int i=0; i<terms.length; i++) {
            st = new StringTokenizer(terms[i]);
            termsList.add(new Terms(st.nextToken(), Integer.parseInt(st.nextToken())));
        }
        for(int i=0; i<privacies.length; i++) {
            if(isDestruction(privacies[i])) answer.add(i+1);
        }
        return answer;
    }
    private boolean isDestruction(String privacy) {
        StringTokenizer st = new StringTokenizer(privacy, ". ");
        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        String type = st.nextToken();
        
        for(Terms item: termsList) {
            if(item.termsType.equals(type)) {
                month += item.validMonth;
                if(month > 12) {
                    year += (month / 12);
                    month = month % 12;
                    if(month == 0) {
                        year--;
                        month = 12;
                    }
                }
                if(day == 1) {
                    month--;
                    day = 28;
                } else day--;
                
                if(year < baseYear) return true;
                else {
                    if(year == baseYear && month < baseMonth) return true;
                    else {
                        if(year == baseYear && month == baseMonth && day < baseDay) return true;
                    }
                }
            }
        }
        return false;
    }
}
class Terms {
    String termsType;
    int validMonth;
    
    public Terms(String termsType, int validMonth) {
        this.termsType = termsType;
        this.validMonth = validMonth;
    }
}