import java.util.*

public class BOJ_2579{
	//BOJ_2579 계단 오르기
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N + 1];
		for (int i = 0; i < N; i++) {
			arr[i + 1] = sc.nextInt();
		}
		if (N == 1) {
			System.out.println(arr[N]);
		} else if (N == 2) {
			System.out.println(arr[2] + arr[1]);
		} else {
			DP(N + 1, arr);
		}
	}

	static void DP(int N, int[] arr) {
		int[] dp = new int[N];
		int jump = 0;
		int noJump = 0;
		dp[1] = arr[1];
		dp[2] = arr[2] + arr[1];
		for (int i = 3; i < N; i++) {
			jump = arr[i] + dp[i - 2];
			noJump = arr[i] + arr[i - 1] + dp[i - 3];

			dp[i] = Math.max(jump, noJump);
		}
//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[N - 1]);
	}

	private static String src = "6\r\n" + "10\r\n" + "20\r\n" + "15\r\n" + "25\r\n" + "10\r\n" + "20";
}
