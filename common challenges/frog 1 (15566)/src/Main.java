import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] frogTalk, frogPreference, logBridge;
    static boolean[] visited;
    static int[] lotus;
    static int node, bridge;
    static boolean result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        bridge = Integer.parseInt(st.nextToken());
        frogTalk = new int[node][4]; // 대화 주제 흥미도
        for(int i=0; i<node; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++) frogTalk[i][j] = Integer.parseInt(st.nextToken());
        }
        frogPreference = new int[node][2]; // 선호 연꽃 번호
        for(int i=0; i<node; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++) frogPreference[i][j] = Integer.parseInt(st.nextToken())-1;
            if(frogPreference[i][0] == frogPreference[i][1]) frogPreference[i][1] = -1;
        }
        logBridge = new int[bridge][3]; // 통나무 다리 정보
        for(int i=0; i<bridge; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) logBridge[i][j] = Integer.parseInt(st.nextToken())-1;
        }
        
        StringBuilder sb = new StringBuilder();
        result = false;
        visited = new boolean[node];
        lotus = new int[node];
        dfsNode(0);
        if(result) {
            sb.append("YES\n");
            for(int i=1; i<=lotus.length-1; i++) sb.append(lotus[i] + " ");
        } else {
            sb.append("NO\n");
        }
        System.out.print(sb);
    }
    private static void dfsNode(int index) {
        if(index == node) {
			if(check()) {
                System.out.println("YES");
				for (int i = 0; i < node; i++)
					System.out.print((lotus[i]+1) + " ");
				System.exit(0);
                result = true;
            }
            return;
		}

		for(int i=0; i<2; i++) {
			if(frogPreference[index][i] == -1) continue;
			int num = frogPreference[index][i];
			if(!visited[num]) {
				visited[num] = true;
				lotus[num] = index;
				dfsNode(index+1);
				visited[num] = false;
			}
		}
    }
    private static boolean check() {
		for (int i=0; i<logBridge.length; i++) {
			int aNode = logBridge[i][0];
			int bNode = logBridge[i][1];
			int theme = logBridge[i][2];
			int frog1 = lotus[aNode];
			int frog2 = lotus[bNode];
			if(frogTalk[frog1][theme] != frogTalk[frog2][theme]) return false;
		}
		return true;
	}
}