package zookeeper;

public class Gorilla extends Mammal {
    // public Gorilla(int energyLevel) {
    //     //my question is how to create an instance of a Gorilla with default energy value 100, 
    //     //or else, the default value is useless.
    //     super(energyLevel);
        
    // }
   public void throwSomething() {
       System.out.println("It is throwing something now and energy will be decreased by 5");
       energyLevel = energyLevel -5;
       
   } 
   public void eatBananas() {
       System.out.println("Gorilla eats bananas and is satisfied now and his energy will be increased by 10");
       energyLevel += 10;

   }
   public void climb() {
       System.out.println("The gorilla has climbed a tree and energy will be decreased by 10");
       energyLevel -= 10;
   }
}
