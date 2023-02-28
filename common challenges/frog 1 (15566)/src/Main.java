import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] frogTalk, frogPreference, logBridge;
    static boolean[] lotus;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int bridge = Integer.parseInt(st.nextToken());
        frogTalk = new int[node][4]; // 대화 주제 흥미도
        for(int i=0; i<node; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++) frogTalk[i][j] = Integer.parseInt(st.nextToken());
        }
        frogPreference = new int[node][2]; // 선호 연꽃 번호
        for(int i=0; i<node; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++) frogPreference[i][j] = Integer.parseInt(st.nextToken());
        }
        logBridge = new int[bridge][3]; // 통나무 다리 정보
        for(int i=0; i<bridge; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) logBridge[i][j] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=0; i<node; i++) {
            for(int j=0; j<2; j++) {
                lotus = new boolean[node+1];
                dfsNode(frogPreference[i][j]);
            }
        }
    }
    private static void dfsNode(int n) {
        // 개구리를 선호하는 연꽃에 배치 (경우의 수)
        // 배치 상태에서 개구리끼리 대화 통하는지 판별
    }
}