import java.util.*;
 
public class BOJ_2947 {
  //BOJ_2947 나무 조각
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
 
        int[] arr = new int[5];
        int[] answer = new int[5];
 
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }
 
        while (check(arr)) {
            for (int x = 0; x <= 3; x++) {
                if (compare(arr, x, x + 1) && check(arr)) {
                    swap(arr, x, x + 1);
                    print(arr);
                }
            }
        }
 
    }
 
    public static void swap(int[] arr, int x, int y) {
        int swap;
        swap = arr[x];
        arr[x] = arr[y];
        arr[y] = swap;
    }
 
    public static boolean compare(int[] arr, int x, int y) {
        if (arr[x] > arr[y]) {
            return true;
        }
        return false;
    }
 
    public static boolean check(int[] arr) {
        boolean flags = false;
        for (int i = 0; i < 5; i++) {
            if (arr[i] != (i + 1)) {
                flags = true;
                break;
            }
        }
        return flags;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < 5; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
 
    }
}
