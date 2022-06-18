import java.util.*;

public class BOJ_4796 {
    //캠핑
    static int cases;
    static int cnt;
    static int l;
    static int p;
    static int v;
    static int result;

    public static void main(String[] arg) {
        Scanner sc= new Scanner(System.in);
        cases = 0;
        cnt = 1;

        while (true) {
            l = sc.nextInt();
            p = sc.nextInt();
            v = sc.nextInt();

            if (l == 0 && p == 0 && v == 0)
                break;

            result = (((v / p) * l)) + Math.min(l, (v % p));
            System.out.println("Case " + cnt++ + ": " + result);
        }
    }
}
