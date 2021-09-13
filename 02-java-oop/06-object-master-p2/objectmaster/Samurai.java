package objectmaster;

public class Samurai extends Human{
    public static int numOfSamurai = 0;
    public static int full_health = 200;

    public Samurai() {
        this.health = full_health;
        numOfSamurai++;
    }
   
    public void deathBlow(Human otherHuman) {
        System.out.println("This is a deathblow to ");
        this.health = (this.health)/2;
        otherHuman.health = 0;

    }
    public void meditate() {
        System.out.println("Meditating........");
        this.health = full_health;

    }
    public static int howMany() {
        
        return numOfSamurai;
    }
}
