import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        System.out.println(sol.solution(survey, choices));
    }
}

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<String, Integer>() {{
            put("R", 0);
            put("T", 0);
            put("C", 0);
            put("F", 0);
            put("J", 0);
            put("M", 0);
            put("A", 0);
            put("N", 0);
        }};
        int score = 0;
        for(int i=0; i<survey.length; i++) {
            String str1 = survey[i].substring(0, 1), str2 = survey[i].substring(1);
            switch(choices[i]) {
                case 1:
                case 7:
                    score = 3;
                    break;
                case 2:
                case 6:
                    score = 2;
                    break;
                case 3:
                case 5:
                    score = 1;
                    break;
                default:
                    score = 0;
            }
            if(choices[i] > 4) map.put(str1, map.get(str1) + score);
            else if(choices[i] < 4) map.put(str2, map.get(str2) + score);
        }
        
        if(Integer.compare(map.get("R"), map.get("T")) <= 0) {
            answer += "R";
        } else {
            answer += "T";
        }
        
        if(Integer.compare(map.get("C"), map.get("F")) <= 0) {
            answer += "C";
        } else {
            answer += "F";
        }
        
        if(Integer.compare(map.get("J"), map.get("M")) <= 0) {
            answer += "J";
        } else {
            answer += "M";
        }
        
        if(Integer.compare(map.get("A"), map.get("N")) <= 0) {
            answer += "A";
        } else {
            answer += "N";
        }
        
        return answer;
    }
}