import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<LotusInfo>[] lotusList;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int lotus = Integer.parseInt(st.nextToken());
        int log = Integer.parseInt(st.nextToken());
        FrogInfo[] frogs = new FrogInfo[lotus];
        for(int i=0; i<lotus; i++) {
            st = new StringTokenizer(br.readLine());
            frogs[i] = new FrogInfo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0, 0);
        }
        for(int i=0; i<lotus; i++) {
            st = new StringTokenizer(br.readLine());
            frogs[i].preferredA = Integer.parseInt(st.nextToken());
            frogs[i].preferredB = Integer.parseInt(st.nextToken());
        }
        lotusList = new ArrayList[lotus+1];
        visited = new boolean[lotus+1];
        for(int i=1; i<=lotus; i++) lotusList[i] = new ArrayList<>();
        for(int i=0; i<log; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            int theme = Integer.parseInt(st.nextToken());
            lotusList[nodeA].add(new LotusInfo(nodeB, theme));
            lotusList[nodeB].add(new LotusInfo(nodeA, theme));
        }
        for(int i=1; i<=lotus; i++) {
            if(!visited[i]) dfs(i);
        }
        System.out.println();
    }
    private static void dfs(int search) {
        if(visited[search]) return;
        visited[search] = true;
        for(int i=1; i<=lotusList.length-1; i++) {
            lotusList[i].get(i)
        }
    }
}
class FrogInfo {
    int food, hobby, family, philosophy, preferredA, preferredB;
    
    public FrogInfo(int food, int hobby, int family, int philosophy, int preferredA, int preferredB) {
        this.food = food;
        this.hobby = hobby;
        this.family = family;
        this.philosophy = philosophy;
        this.preferredA = preferredA;
        this.preferredB = preferredB;
    }
}
class LotusInfo {
    int node, theme;

    public LotusInfo(int node, int theme) {
        this.node = node;
        this.theme = theme;
    }
}