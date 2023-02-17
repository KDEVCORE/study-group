import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int titleCount = Integer.parseInt(st.nextToken());
        int characterCount = Integer.parseInt(st.nextToken());
        ArrayList<TitleInfo>[] titleList = new ArrayList[titleCount];
        for(int i=0; i<titleCount; i++) {
            st = new StringTokenizer(br.readLine());
            titleList[i] = new ArrayList<>();
            titleList[i].add(new TitleInfo(st.nextToken(), Integer.parseInt(st.nextToken())));
        }
        ArrayList<Integer> characterPowerList = new ArrayList<>();
        for(int i=0; i<characterCount; i++) characterPowerList.add(Integer.parseInt(br.readLine()));
        StringBuilder sb = new StringBuilder();
        for(int characterPower: characterPowerList) sb.append(getTitle(titleList, characterPower) + "\n");
        System.out.print(sb);
    }
    public static String getTitle(ArrayList<TitleInfo>[] titleList, int fightingPower) {
        int min = 0;
        int max = titleList.length - 1;
        String result = "";
        while(min <= max) {
            int mid = (min + max) / 2;
            if(fightingPower <= titleList[mid].get(0).maximum) {
                if(fightingPower <= titleList[min].get(0).maximum) {
                    result = titleList[min].get(0).name;
                    break;
                } else {
                    max = mid;
                    min++;
                }
            } else if(titleList[mid].get(0).maximum < fightingPower) {
                min = mid + 1;
            }
        }
        return result;
    }
}
class TitleInfo {
    String name;
    int maximum;
    public TitleInfo(String name, int maximum) {
        this.name = name;
        this.maximum = maximum;
    }
}