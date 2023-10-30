package basic;

import java.util.Scanner;

public class 숫자의합 {
    public static void main(String[] args) { // 메인메소드 선언하기
        Scanner sc = new Scanner(System.in); // Scanner 객체 만들어주기
        int N = sc.nextInt();
        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();
        int sum = 0;
        for(int i = 0; i < cNum. length; i ++ ) {
            sum +=cNum[i]-'0';

        }
        System.out.println(sum);

    }
}
