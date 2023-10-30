package basic;

public class 시간복잡도_판별원리2_연산횟수_3N {
    public static void main(String[] args) {
        int N = 100000;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            System.out.println("연산횟수:" + cnt++);
        }
        for (int i = 0; i < N; i++) {
            System.out.println("연산횟수:" + cnt++);
        }
        for (int i = 0; i < N; i++) {
            System.out.println("연산횟수:" + cnt++);
        }
    }
}
