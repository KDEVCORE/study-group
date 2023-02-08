import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int song = Integer.parseInt(st.nextToken()); // 연주 곡 수
        int[] volume_list = new int[song+1];
        int default_volume = Integer.parseInt(st.nextToken()); // 초기 볼륨
        int max_volume = Integer.parseInt(st.nextToken()); // 볼륨 최댓값
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=song; i++) volume_list[i] = Integer.parseInt(st.nextToken());
        int result = Integer.MIN_VALUE;
        int[][] volume = new int[song+1][max_volume+1];
        volume[0][default_volume] = 1;
        for(int i=1; i<=song; i++) {
            for(int j=0; j<=max_volume; j++) {
                if(volume[i-1][j] == 1) {
                    int small = j - volume_list[i];
                    int large = j + volume_list[i];
                    if(small >= 0) volume[i][small] = 1;
                    if(large <= max_volume) volume[i][large] = 1;
                    if(small < 0 && large > max_volume) {
                        result = -1;
                        break;
                    }
                }
            }
        }
        for(int i=0; i<=max_volume; i++) if(volume[song][i] == 1) result = Math.max(result, i);
        System.out.println(result);
    }
}