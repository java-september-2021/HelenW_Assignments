public class ProjectTest {
    public static void main(String[] args) {
        

    Project sample1 = new Project();
    Project sample2 = new Project("playground");
    Project sample3 = new Project("shop", "pet food and supplies");

    String sample1Name = sample1.getName();
    String sample1Desc = sample1.getDesc();
    System.out.println(sample1Name);
    System.out.println(sample1Desc);
    System.out.println(sample1.elevatorPitch());

    //test for sample2, with name augument
    sample2.setName("HelloSample2");
    System.out.println(sample2.getName());
    sample2.setDesc("This is a description for sample2");
    System.out.println(sample2.getDesc());
    sample2.setInitialCost(1200);
    System.out.println("Sample2's new cost : "+sample2.getInitialCost());
    System.out.println(sample2.elevatorPitch());
    

    //test for sample3, with name and description augument
    System.out.println("Original name of sample 3: "+ sample3.getName());
    sample3.setName("shopNew");
    System.out.println("New name is :"+ sample3.getName());
    System.out.println("Original descrption: "+sample3.getDesc());
    sample3.setDesc("This is another shop");
    System.out.println("New description is :" +sample3.getDesc());
    sample3.setInitialCost(66666666);
    System.out.println("Sample3's new inital cost is :"+sample3.getInitialCost());
    System.out.println(sample3.elevatorPitch());


}


}
