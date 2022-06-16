import java.util.Scanner;

public class BOJ_1213 {
    //팰린드롭 만들기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] abc = new int[26];
        for (int i = 0; i < str.length(); i++) {
            abc[str.charAt(i) - 'A']++;
        }

        int oddCnt = 0, oddIdx = 0;

        for (int j = 0; j < abc.length; j++) {
            if (abc[j] % 2 == 1) {
                oddCnt++;
                oddIdx = j;
            }
        }

//        System.out.printf("%d %d \n", oddCnt, oddIdx);

        if ((str.length() % 2 == 0 && oddCnt > 0) || (str.length() % 2 == 1 && oddCnt != 1)) {
            System.out.printf("I'm Sorry Hansoo");
            return;
        }

        for (int i = 0; i < abc.length; i++) {
            for (int j = 0; j < abc[i] / 2; j++) {
                System.out.printf("%c", i + 'A');
            }
        }

        if (str.length() % 2 == 1) System.out.printf("%c", oddIdx + 'A');

        for (int i = 25; i >= 0; i--) {
            for (int j = 0; j < abc[i] / 2; j++) {
                System.out.printf("%c", i + 'A');
            }
        }
    }

}
