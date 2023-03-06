import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class App {
    static int[] temp;
    static int number, target, answear, end;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        number = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        temp = new int[number];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<number; i++) temp[i] = Integer.parseInt(st.nextToken());
        answear = 0;
        end = number-1;
        searchDepth(0, 0);
        System.out.println(answear);

    }
    private static void searchDepth(int depth, int count) {
        if(depth == end) {
            if(count+temp[depth] == target || count-temp[depth] == target) answear++;
            return;
        }
        searchDepth(depth+1, count+temp[depth]);
        searchDepth(depth+1, count-temp[depth]);
    }
}