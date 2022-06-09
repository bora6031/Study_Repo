import java.util.*;

public class BOJ_7795{
    //먹을 것인가, 먹힐 것인가
    static int N, M;
    static int[] A, B;

    public static void main(String[] args) {
				Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
	        N = sc.nextInt();
	        M = sc.nextInt();
	        A = new int[N];
	        B = new int[M];
	        for (int j = 0; j < N; j++)
	            A[j] = sc.nextInt();
	        for (int x = 0; x < M; x++)
	            B[x] = sc.nextInt();
          Arrays.sort(B);
	        int cnt = 0;
	        for (int y = 0; y < N; y++) {
	            cnt += find(A[y]);
	        }
	        System.out.println(cnt);
        }
    }

    private static int find(int x) {
        int l = 0, r = M - 1;
        int result = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (B[mid] < x) {
                result = mid + 1;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }

}
