public class PuzzleJavaTest {
    public static void main(String[] args) {
        PuzzleJava tester = new PuzzleJava();
        int num = 9;
        System.out.println("Ten random numbers between 1 and 20 inclusive :"+tester.getTenRolls());
        System.out.println("Generating one random character : "+tester.getRandomLetter());
        // System.out.println(tester.generatePassword());
        System.out.println("Generating 8 characters long random password :"+tester.genePassword());
        System.out.println("Generating "+ num +" sets of passwords." +tester.passwordSet(9));

    }
}
