import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] switchList;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int switchCount = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        switchList = new boolean[switchCount + 1];
        for(int i=1; i<=switchCount; i++) switchList[i] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
        int studentCount = Integer.parseInt(br.readLine());
        for(int i=0; i<studentCount; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            changeSwitchList(a, b);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=switchCount; i++) sb.append((switchList[i] ? 1 : 0) + (i % 20 == 0 ? "\n" : " "));
        System.out.print(sb);
    }
    private static void changeSwitchList(int sex, int number) {
        if(sex == 1) {
            for(int i=number; i<switchList.length; i+=number) switchList[i] = !switchList[i];
        } else {
            int index = 1;
            if(number > 1 && number < switchList.length-1) {
                while(switchList[number-index] == switchList[number+index]) {
                    switchList[number-index] = !switchList[number-index];
                    switchList[number+index] = !switchList[number+index];
                    index++;
                    if(number-index < 1 || switchList.length <= number+index) break;
                }
            }
            switchList[number] = !switchList[number];
        }
    }
}