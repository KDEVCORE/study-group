import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int dotsCount = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        ArrayList<Dots> coordinates = new ArrayList<>();
        for(int i=0; i<dotsCount; i++) {
            st = new StringTokenizer(br.readLine());
            coordinates.add(new Dots(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        int count = 0;
        int[][] dx = {
            {0, width, 0, -width},
            {0, width, 0, -width},
            {0, -width, 0, width},
            {0, -width, 0, width}
        };
        int[][] dy = {
            {length, 0, -length, 0},
            {-length, 0, length, 0},
            {length, 0, -length, 0},
            {-length, 0, length, 0}
        };
        for(Dots item: coordinates) {
            boolean valid = false;
            int fx = item.x, fy = item.y;
            for(int i=0; i<4; i++) {
                for(int j=0; j<4; j++) {
                    fx += dx[i][j];
                    fy += dy[i][j];
                    if(!coordinates.contains(new Dots(fx, fy))) {
                        valid = false;
                        break;
                    } else {
                        valid = true;
                    }
                }
                if(valid && item.x == fx && item.y == fy) count++;
            }
        }
        System.out.println(count);
    }
}
class Dots {
    int x, y;
    public Dots(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean equals(Object object) {
        Dots dot = (Dots) object;
 
        if (this.x == dot.x && this.y == dot.y) {
            return true;
        }
        return false;
    }
}