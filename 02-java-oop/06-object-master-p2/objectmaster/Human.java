package objectmaster;

public class Human {
    protected int strength =3 ;
    protected int stealth = 3;
    protected int intelligence = 3;
    protected int health = 100;

   //getter
   public int getStrength() {
       return this.strength;
   }

   //setter
   public void setStrength(int strengthVal) {
        this.strength = strengthVal;
   }

    
    

    public void attack (Human attacked) {
        System.out.println("Attacked person's original strengh is "+ attacked.strength);
        attacked.health -= this.strength;
        System.out.println("After being attacked, his energy becomes "+attacked.strength);
        
    }
}
