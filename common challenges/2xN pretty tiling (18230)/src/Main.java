import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] tileA, tileB, tempA, tempB;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        tileA = new int[Integer.parseInt(st.nextToken())];
        tileB = new int[Integer.parseInt(st.nextToken())];
        tempA = new int[tileA.length];
        tempB = new int[tileB.length];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<tileA.length; i++) tileA[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<tileB.length; i++) tileB[i] = Integer.parseInt(st.nextToken());
        mergeSortA(0, tileA.length-1);
        mergeSortB(0, tileB.length-1);
        long sumA = 0, sumB = 0, result = Integer.MIN_VALUE;
        int b = tileB.length < size / 2 ? tileB.length : size / 2;
        while(b >= 0) {
            sumA = 0;
            sumB = 0;
            int a = tileA.length < size - (2*b) ? tileA.length : size - (2*b);
            for(int i=0; i<b; i++) sumB += tileB[i];
            for(int i=0; i<a; i++) sumA += tileA[i];
            result = Math.max(result, sumA + sumB);
            b--;
        }
        System.out.println(result);
    }
    private static void mergeSortA(int start, int end) {
        if(start >= end) return;
        int mid = (start + end) / 2;
        mergeSortA(start, mid);
        mergeSortA(mid+1, end);
        tempA = tileA.clone();
        int k = start, index1 = start, index2 = mid + 1;
        while(index1 <= mid && index2 <= end) {
            if(tempA[index1] < tempA[index2]) tileA[k++] = tempA[index2++];
            else tileA[k++] = tempA[index1++];
        }
        while(index1 <= mid) tileA[k++] = tempA[index1++];
        while(index2 <= end) tileA[k++] = tempA[index2++];
    }
    private static void mergeSortB(int start, int end) {
        if(start >= end) return;
        int mid = (start + end) / 2;
        mergeSortB(start, mid);
        mergeSortB(mid+1, end);
        tempB = tileB.clone();
        int k = start, index1 = start, index2 = mid + 1;
        while(index1 <= mid && index2 <= end) {
            if(tempB[index1] < tempB[index2]) tileB[k++] = tempB[index2++];
            else tileB[k++] = tempB[index1++];
        }
        while(index1 <= mid) tileB[k++] = tempB[index1++];
        while(index2 <= end) tileB[k++] = tempB[index2++];
    }
}