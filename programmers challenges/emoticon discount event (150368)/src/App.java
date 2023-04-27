public class App {
    public static void main(String[] args) throws Exception {
        int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        int[] emoticons = {1300, 1500, 1600, 4900};
        for(int item: new Solution().solution(users, emoticons)) {
            System.out.print(item + " ");
        }
    }
}
class Solution {
    static double[] discount = {0.1, 0.2, 0.3, 0.4};
    static int totalUserCount;
    static int totalCost;
    public int[] solution(int[][] users, int[] emoticons) {
        findResult(new double[emoticons.length], 0, emoticons.length, users, emoticons);
        return new int[]{totalUserCount, totalCost};
    }

    public void findResult(double[] syncDiscount, int index, int emoticonsLength, int[][] users, int[] emoticons){
        if(index == emoticonsLength) {
            int userCount = 0;
            int cost = 0;

            for(int[] user: users) {
                double userPreferenceRate = (double) user[0]/100;
                int userPreferenceCost = user[1];
                int sum = 0;
                for(int i=0; i<emoticons.length; i++) {
                    if(syncDiscount[i] >= userPreferenceRate) sum += emoticons[i]*(1-syncDiscount[i]);
                }
                if(sum >= userPreferenceCost) userCount++;
                else cost += sum;
            }
            if(userCount > totalUserCount) {
                totalUserCount = userCount;
                totalCost = cost;
            } else if(userCount == totalUserCount) {
                totalCost = Math.max(totalCost, cost);
            }
            return;
        }
        for(int i=0; i<4; i++) {
            syncDiscount[index] = discount[i];
            findResult(syncDiscount, index+1, emoticonsLength, users, emoticons);
        }
    }
}
// class Solution {
//     public ArrayList<String> solution(int[][] users, int[] emoticons) {
//         ArrayList<String> answer = new ArrayList<>();
//         int emoLength = emoticons.length;
//         for(int i=0; i<(1<<emoLength); i++) {
//             String temp = "";
//             for(int j=0; j<emoLength; j++) {
//                 if((i & (1<<j)) > 0) temp += emoticons[j] + " ";
//             }
//             answer.add(temp.trim());
//         }
//         double[] discount = {0.6, 0.7, 0.8, 0.9};
//         for(int i=0; i<(1<<discount.length); i++) {
//             for(int j=0; j<discount.length; j++) {
//                 if((i & (1<<j)) > 0) {
//                     discount[j]
//                 }
//             }
//         }
//         return answer;
//     }
// }