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
                    int small = j - volume_list[i]; // 감소하는 결괏값 계산
                    int large = j + volume_list[i]; // 증가하는 결괏값 계산
                    if(small >= 0) volume[i][small] = 1;
                    if(large <= max_volume) volume[i][large] = 1;
                    // 이 로직이 문제인 이유. 이 if문을 한 번도 방문하지 않았을 경우의 반례 케이스 존재. (케이스는 찾지 못함)
                    // 따라서, 이 로직이 완전무결하지 않고 예외가 발생할 수 있어, 해당 로직을 삭제하고 결괏값 도출이 끝난 후 -1 처리.
                    // if(small < 0 && large > max_volume) {
                    //     result = -1;
                    //     break;
                    // }
                }
                // if(volume[i-1][j]==1 && j+volume_list[i]<=max_volume) volume[i][j+volume_list[i]]=1;
                // if(volume[i-1][j]==1 && j-volume_list[i]>=0) volume[i][j-volume_list[i]]=1;
            }
            if(i == song) {
                for(int k=0; k<=max_volume; k++) if(volume[i][k] == 1) result = Math.max(result, k);
            }
        }
        if(result < 0) System.out.println(-1);
        else System.out.println(result);
    }
}