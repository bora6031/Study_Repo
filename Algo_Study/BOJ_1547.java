import java.util.*;

public class BOJ_1547 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M= sc.nextInt();
		int[] arr= {0,1,0,0};
		
		
		for (int i = 0; i < M; i++) {
			int X= sc.nextInt();
			int Y= sc.nextInt();
			
			arr[0]=arr[X];
			arr[X]=arr[Y];
			arr[Y]=arr[0];
		}
		
		for (int i = 1; i < arr.length; i++) {
			if(arr[i]==1) {
				System.out.println(i);
			}
		}
	}
}
