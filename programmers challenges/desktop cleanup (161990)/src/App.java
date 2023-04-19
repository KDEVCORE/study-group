import java.util.ArrayList;
import java.util.Collections;

public class App {
    public static void main(String[] args) throws Exception {
        String[] wallpaper = {".#...", "..#..", "...#."}; // 0, 1, 3, 4
        // String[] wallpaper = {"..........", ".....#....", "......##..", "...##.....", "....#....."}; // 1, 3, 5, 8
        // String[] wallpaper = {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."}; // 0, 0, 7, 9
        // String[] wallpaper = {"..", "#."}; // 1, 0, 2, 1
        StringBuilder sb = new StringBuilder();
        for(int item: new Solution().solution(wallpaper)) {
            sb.append(item + " ");
        }
        System.out.println(sb);
    }
}
class Solution {
    public int[] solution(String[] wallpaper) {
        ArrayList<Integer> listX = new ArrayList<Integer>();
        ArrayList<Integer> listY = new ArrayList<Integer>();
        for(int i=0; i<wallpaper.length; i++) {
            for(int j=0; j<wallpaper[i].length(); j++) {
                if("#".equals(String.valueOf(wallpaper[i].charAt(j)))) {
                    if(!listX.contains(i)) listX.add(i);
                    if(!listY.contains(j)) listY.add(j);
                }
            }
        }
        return new int[] {Collections.min(listX), Collections.min(listY), Collections.max(listX)+1, Collections.max(listY)+1};
    }
}