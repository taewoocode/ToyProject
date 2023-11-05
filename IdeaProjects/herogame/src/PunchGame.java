// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class PunchGame {
    public static void main(String[] args) {
        Leona leona = new Leona();
        Arthas arthas = new Arthas();

        while (true) {
            // 레오나가 아서스에게 펀치
            leona.punch(arthas);
            System.out.println("[" + leona.getName() + "]의 펀치");
            System.out.println("아서스: " + arthas.getHealth() + "/30");

            // 아서스가 레오나에게 펀치
            arthas.punch(leona);
            System.out.println("[" + arthas.getName() + "]의 펀치");
            System.out.println("레오나: " + leona.getHealth() + "/30");

            if (leona.getHealth() <= 10 && arthas.getHealth() <= 10) {
                arthas.punch(leona);
                System.out.println("[" + arthas.getName() + "]의 펀치");
                System.out.println("레오나: " + leona.getHealth() + "/30");
                break;
            }

        }

        if (leona.getHealth() == 0) {
            System.out.println("아서스 승리!");

        }
    }
}

