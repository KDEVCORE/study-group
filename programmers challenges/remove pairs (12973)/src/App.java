import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new Solution().solution("baabaa"));
    }
}
class Solution {
    public int solution(String s) {
        ArrayList<String> temp = new ArrayList<>();
        for(int i=0; i<s.length(); i++) {
            temp.add(String.valueOf(s.charAt(i)));
            if(temp.size() >= 2) {
                if(temp.get(temp.size()-2).equals(temp.get(temp.size()-1))) {
                    temp.remove(temp.size()-1);
                    temp.remove(temp.size()-1);
                }
            }
        }
        
        return temp.size() > 0 ? 0 : 1;
    }
}