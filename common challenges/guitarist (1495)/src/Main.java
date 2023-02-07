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
        int[] volume = new int[song+1];
        volume[0] = default_volume;
        for(int i=1; i<=song; i++) {
            if(volume[i-1] == -1) break;
            volume[i] = volume[i-1] + volume_list[i];
            if(volume[i] < 0 || volume[i] > max_volume) volume[i] = -1;
            result = Math.max(result, volume[i]);
        }
        volume[0] = default_volume;
        for(int i=1; i<=song; i++) {
            if(volume[i-1] == -1) break;
            volume[i] = volume[i-1] + volume_list[i];
            if(volume[i] < 0 || volume[i] > max_volume) volume[i] = -1;
            result = Math.max(result, volume[i]);
        }
        System.out.println(result);
    }
}
