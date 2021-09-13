package objectmaster;

public class HumanTest {
    public static void main(String[] args) {
        Human A = new Human();
        Human B = new Human();
        A.attack(B);
        Wizard w1 = new Wizard();
        Ninja n1 = new Ninja();
        Samurai s1 = new Samurai();
        Samurai s2 = new Samurai();
        System.out.println("There are "+Samurai.howMany()+" Samurai generated");
        w1.attack(n1);
        s1.deathBlow(s2);
        s2.meditate();
        System.out.println(B.getStrength());
        w1.heal(B);
        System.out.println(B.getStrength());
    }
    
}
