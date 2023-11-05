public class Hero {
    private String name;
    private int health;

    public Hero(String name, int health){

        this.name = name;
        this.health = health;
    }

    public String getName(){  //객체의 이름을 읽어오는 메서드
        return name; //객체의 이름을 반환
    }

    public int getHealth(){ //객체의 체력을 읽어오는 메서드
        return health; //객체의 체력상태 반환
    }

    public void punch(Hero target){
        int damage = 10; // 펀치로 입히는 피해
        target.receieveDamage(damage);
    }

    public void receieveDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            health = 0;
        }
    }
}
