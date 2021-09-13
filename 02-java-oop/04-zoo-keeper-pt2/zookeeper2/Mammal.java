package zookeeper2;

public class Mammal {
    protected int energyLevel;
    private static int defaultVal = 100;
    //one constructor with argument
    public Mammal(int energyLevel) {
        this.energyLevel = energyLevel;
    }
    //one constructor without argument which use default value to set energyLevel
    public Mammal() {
        energyLevel = defaultVal;
    }

    //getter 
    public int getEnergyVal() {
        return energyLevel;
    }

    //setter
    public void setEnergyVal(int val) {
        this.energyLevel = val;
    }
    
    public int displayEnergy() {
        System.out.println("Energy Level ls :"+energyLevel);
        return energyLevel;
    }
}
