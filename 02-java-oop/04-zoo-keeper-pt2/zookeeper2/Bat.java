



public class Bat extends Mammal {
    public void fly() {
        
        System.out.println("SSSSSsssssssssssSSSSSSSS, energy will decreased by 50");
        energyLevel -= 50;
        
    }
    public void eatHumans() {
        System.out.println("So -well, never mind. energy will be increased by 25");
        energyLevel += 25;

    }

    public void attackTown() {
        System.out.println("TsiiiiiiiiTsiiiiiiiiBanggggggg, the town is on fire now. Energy will be decreased by 100.");
        energyLevel -= 100;
    }
    
}
