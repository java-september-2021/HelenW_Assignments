package zookeeper2;

public class BatTest {
    public static void main(String[] args) {
        Bat batTest = new Bat();
        batTest.displayEnergy();
        // batTest.setEnergyVal(300);
        batTest.attackTown();
        batTest.displayEnergy();
        batTest.attackTown();
        batTest.attackTown();
        batTest.displayEnergy();
        batTest.eatHumans();
        batTest.displayEnergy();
        batTest.eatHumans();
        batTest.fly();
        batTest.fly();
        batTest.displayEnergy();

    }
    
    
}
