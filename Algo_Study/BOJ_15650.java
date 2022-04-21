import java.util.Scanner;

public class BOJ_15650 {
  //N과 M(2)
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		combination(N,new int[M],0,0);
		
	}
	
	private static void  combination(int N, int[] sel, int idx,int k) {
		if(k==sel.length) {
			//댜 뽑았으면 
			for(int i:sel) {
				System.out.print(i+" ");
			}System.out.println();
			
			return;
		}
		
		for (int i = idx; i < N; i++) {
			sel[k]=i+1;
			combination(N, sel, i+1, k+1);
		}
	}
}
