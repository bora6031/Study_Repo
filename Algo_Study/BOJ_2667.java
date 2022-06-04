import java.util.*;


public class BOJ_2667 {
  //단지 번호 
	static int node[][];
	static int check[][];
	static int cnt =1;

	static ArrayList<Integer> array = new ArrayList<>();
	
		static void dfs(int x,int y) {
			
			check[x][y] =1; 
				if( y<node.length-1 && node[x][y+1]==1 && check[x][y+1]!=1) {
					
					cnt++;
					dfs(x,y+1);
				
				}  
				 if(x<node.length-1 && node[x+1][y]==1&& check[x+1][y]!=1) {
					
					cnt++;
					dfs(x+1,y);
				}
				 if(y>0 &&  node[x][y-1]==1&& check[x][y-1]==0) {
					
					cnt++;
					dfs(x,y-1);
					
					}  
					 if(x>0 &&  node[x-1][y]==1&& check[x-1][y]==0) {
					
						cnt++;
						dfs(x-1,y);
					}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		
		int n= sc.nextInt();
		node = new int[n][n];
		check = new int[n][n];
		for(int i=0;i<node.length;i++) {
			String row=sc.next();
			for(int j=0;j<node[i].length;j++) {
				node[i][j] = row.charAt(j)-'0';
			}
		}
		
		for(int i=0;i<node.length;i++) {
			for(int j=0;j<node[i].length;j++) {
				if(node[i][j] == 1 && check[i][j]==0) { 
				cnt =1; 
		
					dfs(i,j);
					array.add(cnt); 
					
				}
			}
		}
		
		System.out.println(array.size()); 
		Collections.sort(array); 
		for(int i=0;i<array.size();i++) {
			System.out.println(array.get(i));
		}
	}	
}
