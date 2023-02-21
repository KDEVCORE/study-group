import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int dotCount = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        ArrayList<Dot> dots = new ArrayList<>();
        for(int i=0; i<dotCount; i++) {
            st = new StringTokenizer(br.readLine());
            dots.add(new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(dots);
        int count = 0;
        for(Dot item: dots) {
            Dot dot1 = new Dot(item.x+width, item.y);
            Dot dot2 = new Dot(item.x+width, item.y+length);
            Dot dot3 = new Dot(item.x, item.y+length);
            if(bsDot(dots, dot1) && bsDot(dots, dot2) && bsDot(dots, dot3)) count++;
        }
        System.out.println(count);
    }
    private static boolean bsDot(ArrayList<Dot> dots, Dot target) {
        int min = 0, max = dots.size() - 1;
        while(min <= max) {
            int mid = (min + max) / 2;
            if(dots.get(mid).x == target.x && dots.get(mid).y == target.y) return true;
            else {
                if(target.x < dots.get(mid).x || (target.x == dots.get(mid).x && target.y < dots.get(mid).y)) max = mid - 1;
                else min = mid + 1;
            }
        }
        return false;
    }
}
class Dot implements Comparable<Dot> {
    int x, y;
    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Dot dot) {
        if(this.x == dot.x) return this.y - dot.y;
        return this.x - dot.x;
    }
}