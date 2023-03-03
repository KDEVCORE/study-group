import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] frogTalk, frogPreference, logBridge;
    static boolean[] visited;
    static int[] lotus;
    static int node, bridge;
    static boolean result;
    static StringBuilder sb;
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
        
        sb = new StringBuilder();
        result = false;
        visited = new boolean[node];
        lotus = new int[node];
        dfsNode(0);
        System.out.print(result ? sb : "NO");
    }
    private static void dfsNode(int index) {
        if(index == node) {
            if(validation()) {
                result = true;
                sb.append("YES\n");
                for(int i=0; i<node; i++) sb.append((lotus[i]+1) + " ");
            }
            return;
		}
        if(result) return;
		for(int i=0; i<2; i++) {
			int preference = frogPreference[index][i];
			if(preference == -1) continue;
			if(!visited[preference]) {
				visited[preference] = true;
				lotus[preference] = index;
				dfsNode(index+1);
				visited[preference] = false;
			}
		}
    }
    private static boolean validation() {
		for (int i=0; i<logBridge.length; i++) {
            // 억지스럽다고 느낀 이유
            // int nodeA = logBridge[i][0];
            // int nodeB = logBridge[i][1];
            // int theme = logBridge[i][2];
            // int frog1 = lotus[nodeA];
            // int frog2 = lotus[nodeB];
			// if(frogTalk[frog1][theme] != frogTalk[frog2][theme]) return false;
			if(frogTalk[lotus[logBridge[i][0]]][logBridge[i][2]] != frogTalk[lotus[logBridge[i][1]]][logBridge[i][2]]) return false;
		}
		return true;
	}
}