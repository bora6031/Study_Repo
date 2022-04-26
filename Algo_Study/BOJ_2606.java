import java.util.*;
 
public class BOJ_2606 {
    //BOJ_2606 바이러스
    static int computers,networks,wasted;
    static boolean visits[];
    static boolean map[][];
    
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        
        computers = sc.nextInt();
        networks = sc.nextInt();
        visits = new boolean [computers+1];
        map = new boolean [computers+1][computers+1];
        wasted = 0;
        
        for (int i=1; i<=networks; i++) {
            int tmp1 = sc.nextInt();
            int tmp2 = sc.nextInt();
            
            map[tmp1][tmp2] = true;
            map[tmp2][tmp1] = true;
            
        }
        
        dfs(1);
        
        System.out.println(wasted);
        
    }
 
    private static void dfs(int start) {
        visits[start] = true;
        for(int i=1; i<=computers; i++) {
            if(map[start][i] && !visits[i]) {
                wasted++;
                dfs(i);
            }
        }
    }
}
 
