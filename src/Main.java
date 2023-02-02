public class Main {
    //RPG
    public static int bossHealth = 700;
    public static int bossDamage = 50;
    public static String bossAttackType = "";

    public static int [] heroesHealth = {270, 280, 260};
    public static int [] heroesDamage = {20, 15, 25};
    public static String [] heroesAttackType = {"Physical", "Magical", "Kinetic"};

    public static int roundNumber = 0;

    public static void main(String[] args) {
        printStatics();
        while (!isGameFinished()) {
            round();
        }
    }
    public static  void printStatics(){
        System.out.println("********** " + roundNumber + " **********");
        System.out.println("Boss health = " + bossHealth + " [ " + bossDamage + " ] ");
        for (int i = 0; i < heroesAttackType.length; i++) {
            System.out.println(heroesAttackType[i] + " Hero health = " + heroesHealth[i] + " [ " + heroesDamage[i] + " ] ");
        }
        System.out.println();
    }
    public static void bossHits() {
        for (int i = 0; i < heroesHealth.length; i++) {
            heroesHealth[i] = heroesHealth[i] - bossDamage;
        }
    }
    public static void heroesHits() {
        for (int i = 0; i < heroesHealth.length; i++) {
            bossHealth = bossHealth - heroesDamage[i];
        }
    }
    public static void round(){
        roundNumber++;
        bossHits();
        heroesHits();
        printStatics();
    }
    public static Boolean isGameFinished() {
        if (bossHealth <= 0){
            System.out.println("Heroes won ! ");
            return true;
        }
        if (heroesHealth[0]<=0 && heroesHealth[1]<=0 && heroesHealth[2]<=0){
            System.out.println("Boss won ! ");
            return true;
        }
        return false;
    }
//











}
