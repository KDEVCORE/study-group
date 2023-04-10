public class App {
    public static void main(String[] args) throws Exception {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        for(Object item: new Solution().solution(n, arr1, arr2)) {
            System.out.print(item);
        }
    }
}

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0; i<n; i++) {
            String result = "";
            String temp1 = Integer.toBinaryString(arr1[i]);
            while(temp1.length() < n) temp1 = "0" + temp1;
            String temp2 = Integer.toBinaryString(arr2[i]);
            while(temp2.length() < n) temp2 = "0" + temp2;
            for(int j=0; j<n; j++) {
                result += (temp1.charAt(j) == '1' || temp2.charAt(j) == '1') ? "#" : " ";
            }
            answer[i] = result;
        }
        return answer;
    }
}