import java.util.Scanner;

public class Solution {

        public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);
            int price=0;
            int Money = 10000;
            int safe = 0;

            int[] array = new int[3];
            System.out.println("ㅡㅡㅡㅡㅡ입력ㅡㅡㅡㅡㅡ");
            while(true) {
                System.out.println("1: 붕어빵 구매, 2: 소유중인 붕어빵, 3: 붕어빵 먹기, 4: 판매중인 붕어빵, 5: 나의 소지금, 6: 금고, 0: 종료");
                int num = scan.nextInt();
                switch(num) {
                    case 1:
                        System.out.println("구매할 종류");
                        scan.nextLine();

                        String type = scan.nextLine();
                        System.out.println("구매할 갯수");
                        int n = scan.nextInt();
                        if (type.equals("팥")) {
                            price = 1000;
                            array[0] = n;
                        } else if (type.equals("슈크림")) {
                            price = 1500;
                            array[1] = n;
                        } else if (type.equals("매운")) {
                            price = 2000;
                            array[2] = n;
                        } else {
                            System.out.println("없는 메뉴");
                        }
                        int total = price*n;
                        if (total > Money) {
                            System.out.println("비싸서 못삼");
                        } else {
                            Money -= total;
                            safe += total;
                        }
                        break;
                    case 2:
                        System.out.println("팥: "+array[0]+" | 슈크림: "+array[1]+" | 매운: "+array[2]);
                        break;
                    case 3:
                        System.out.println("먹을 종류");
                        scan.nextLine();
                        type = scan.nextLine();
                        System.out.println("먹을 갯수");
                        n = scan.nextInt();
                        if (type.equals("팥")) {
                            if (n>array[0]) {
                                System.out.println("수량 부족");
                            } else {
                                array[0] -= n;
                                System.out.println("아이 맛있다~ "+type+" 맛이네~"+n);
                            }
                        } else if (type.equals("슈크림")) {
                            if (n>array[1]) {
                                System.out.println("수량 부족");
                            } else {
                                array[1] -= n;
                                System.out.println("아이 맛있다~ "+type+" 맛이네~"+n);
                            }
                        } else if (type.equals("매운")) {
                            if (n>array[2]) {
                                System.out.println("수량 부족");
                            } else {
                                array[2] -= n;
                                System.out.println("아이 맛있다~ "+type+" 맛이네~"+n);
                            }
                        } else {
                            System.out.println("없는 맛");
                        }
                        break;
                    case 4:
                        System.out.println("판매중인 붕어빵");
                        System.out.println("팥: 1000원");
                        System.out.println("슈크림: 1500원");
                        System.out.println("매운: 2000원");
                        break;
                    case 5:
                        System.out.println("내 돈: "+Money);
                        break;
                    case 6:
                        System.out.println("금고: "+safe);
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("숫자를 다시 입력");
                        n = scan.nextInt();
                }
                if (num == 0) {
                    break;
                }
            }
            System.out.println("종료");
        }
}
