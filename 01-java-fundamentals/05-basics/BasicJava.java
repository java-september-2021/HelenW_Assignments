import java.util.ArrayList;
public class BasicJava {
 
   
    //Print 1-255
    public void print255() {
        for (int i = 1; i < 256; i++) {
            System.out.println(i);
        }
        
    }

    //Print odd numbers between 1-255
    public void printOdd() {
        for (int i = 1; i < 256; i=i+2) {
            System.out.println(i);
        }
    }

    //Sigma of 255 AKA Sum to 255, need return sum
    public int sum255() {
            int sum  = 0;
        for (int i = 1; i < 256; i++) {
            sum = sum + i;
        }
        return sum;
    }
    //Iterating through an array 
    public static void LoopArray(int[] arr) {
		for(int val: arr)
			System.out.println(val);
	}


    //Find Max
    public int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
           
        }
        return max;
    }

    //Array with Odd Numbers :Write a method that creates an array 'y' that contains all the odd numbers between 1 to 255. When the method is done, 'y' should have the value of [1, 3, 5, 7, ... 255].
    public static ArrayList<Integer> OddArray() {
		ArrayList<Integer> oddList = new ArrayList<Integer>();
		for(int i = 1; i <= 255; i=i+2) {
			
			oddList.add(i);
		}
		return oddList;
	}
    
    //get Average
    public double findAve(int[] arr) {
        double ave = 0;
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
        }
        ave = (double) sum/arr.length;
        System.out.println("Average is "+ ave);
        return ave;
    }

    //greater than y
    public int greatY (int[] arr, int y) {
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (y < arr[i]) {
                cnt++;
            }
        }
        System.out.println("There are "+cnt+" numbers that are greater than "+y+".");
        return cnt;
    }

    //square the values
    
    public static void squareArr(int[] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			
			arr[i] =arr[i]*arr[i];
		}
        LoopArray(arr);
		
	}

    //Eliminate Negative Numbers
    public static void goNeg(int[] arr) {
		
		for(int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                arr[i] = 0;
            }
		}
        LoopArray(arr);
		
	}
}

