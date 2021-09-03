import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava {

    public ArrayList<Integer> getTenRolls() {
    ArrayList<Integer> numArr = new ArrayList<Integer>();
    Random r = new Random();
    for (int i = 0; i < 10; i++) {
        numArr.add(r.nextInt(20)+1);
    }
    return numArr;
    }

    public static Character getRandomLetter() {
        ArrayList<Character> alphabetArr = new ArrayList<Character>();
        Random rand = new Random();
        for (char ch = 'a'; ch <= 'z'; ++ch) {
            alphabetArr.add(ch);
          }
        //   System.out.println(alphabetArr.size());
      
          int randomVal = rand.nextInt(26);
        //   System.out.println(alphabetArr);
        //   System.out.println(randomVal);
          return (alphabetArr.get(randomVal));
         
    }
    //get password as an array
    public ArrayList<Character> generatePassword() {
        ArrayList<Character> passwordArr = new ArrayList<Character>();
        for (int i = 0; i < 8; i++) {
            passwordArr.add(getRandomLetter());
        }
        return passwordArr;
    }

    //generate password
    public String genePassword() {
        String password = "";
        for (int i = 0; i < 8; i++) {
            password = password + getRandomLetter();
        }
        return password;

    }

    //getNewPasswordSet
    public ArrayList<String> passwordSet(int width) {
        ArrayList<String> wordset = new ArrayList<String>();
        for (int i = 0; i < width; i++) {
            wordset.add(genePassword());
        }
        return wordset;
    }

}
