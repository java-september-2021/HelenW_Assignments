package objectmaster;

public class Ninja extends Human {
    public Ninja() {
        this.stealth = 10;
    }

    public void steal(Human otherHuman) {
        System.out.println("Attacking otherHuman, other human health decrease, current Ninja health");
        otherHuman.health -= this.stealth;
        this.health += this.stealth;
    }

    public void runAway() {
        System.out.println("Ninaja run away and health is decreased by 10");
        this.health -= 10;
    }
}
