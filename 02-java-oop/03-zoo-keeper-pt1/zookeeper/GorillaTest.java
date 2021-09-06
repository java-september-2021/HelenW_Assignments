package zookeeper;

public class GorillaTest {
    public static void main(String[] args) {
    Gorilla gTest = new Gorilla();
    //display original energy value
    gTest.displayEnergy();
    //set a new value through setter
    gTest.setEnergyVal(500);
    //display its new energy value
    gTest.displayEnergy();
    gTest.throwSomething();
    gTest.displayEnergy();
    gTest.throwSomething();
    gTest.displayEnergy();
    gTest.throwSomething();
    gTest.displayEnergy();
    
    gTest.eatBananas();
    gTest.eatBananas();
    gTest.displayEnergy();
    gTest.climb();
    gTest.displayEnergy();

}
}

