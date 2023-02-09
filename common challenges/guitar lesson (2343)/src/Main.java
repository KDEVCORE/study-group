import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int lesson = Integer.parseInt(st.nextToken());
        int bluray = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] chapter = new int[lesson+1];
        int start = 0, end = 0;
        for(int i=1; i<=lesson; i++) {
            chapter[i] = Integer.parseInt(st.nextToken()); // 분 단위, 1~10000
            end += chapter[i]; // 끝 index, 모든 강의 길이 합
            start = Math.max(start, chapter[i]); // 논리 오류 무엇이 잘못됐는지 모르겠다
        }
        // Arrays.sort(chapter); // 오름차순 정렬
        // start = chapter[lesson]; // 시작 index, 마지막 강의 길이
        while(start <= end) { // 예제 초기 시행, 9 <= 45
            int mid = (start + end) / 2; // 중앙(=블루레이 크기), 예제 mid = (9 + 45) / 2 = 27
            int sum = 0, count = 0;
            for(int i=1; i<=lesson; i++) { // 강의만큼 반복
                if(sum + chapter[i] > mid) { // i-1까지 강의 길이 합계와 i번째 강의 길이를 더했을 때 중앙값보다 크면, 합계 하기 전에 블루레이 개수 증가 처리
                    count++; // 사용한 블루레이 개수 증가
                    sum = 0; // 합계 초기화, 앞으로 담겨질 i번째부터 합계부터 강의 길이 계산
                }
                sum += chapter[i]; // i-1번째 강의 길이 합계 + i번째 강의 길이 합계
            }
            if(sum != 0) count++; // sum이 0이 아니다 = 이미 강의를 블루레이에 다 담은 상태, 임의 count 증가
            if(count > bluray) start = mid + 1; // 현재 사용된 블루레이 개수(count)가 정해진 블루레이 개수(bluray)보다 크면, 시작 index+1
            else end = mid - 1; // 
        }
        System.out.println(start);
    }
}