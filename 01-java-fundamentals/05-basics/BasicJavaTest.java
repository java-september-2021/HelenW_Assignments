public class BasicJavaTest {
    public static void main(String[] args) {
        int[] nums = {1,3,5,-7,9,13};
        int[] nums1 = { 22,43,-9,10,101};
        BasicJava tester = new BasicJava();
        
        
        System.out.println("Print number from 1 to 255");
        tester.print255();
        System.out.println("Print odd number from 1 to 255");
        tester.printOdd();
        System.out.println("Sum of 1 to 255 is :"+ tester.sum255());
        System.out.println("Iterating an array");
        tester.LoopArray(nums);
        System.out.println("Find Max :"+ tester.findMax(nums1));
        System.out.println("Array with odd numbers is :");
        System.out.println(tester.OddArray());
        tester.findAve(nums1);
        tester.greatY(nums1, 0);
        tester.squareArr(nums);
        tester.goNeg(nums1);

        


        

    }
}