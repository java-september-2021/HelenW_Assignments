package objectmaster;

public class Wizard extends Human {
    public Wizard() {
        this.health = 50;
        this.intelligence = 8;
    }
    public void heal(Human otherHuman) {
        System.out.println("A human can receive healing from current wizard, so that human strength can be enhanced.");
        otherHuman.strength += this.intelligence;
    }

    public void fireball(Human otherHuman) {
        otherHuman.health -= 3*this.intelligence;
    }
}
