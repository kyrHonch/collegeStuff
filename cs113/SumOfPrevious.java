package cs113;

import java.util.Scanner;

/* Determine if sum of input number is even.
 * First input line is a single positive integer giving the
 * number of integers on the second line.
 */

public class SumOfPrevious {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        int[] arr = new int[count];
        int sum = 0;
        for(int i=0;i<count;++i) {
            arr[i] = scan.nextInt();
            sum += arr[i];
        }
        long beginning = System.nanoTime();
        boolean b = sumPrevRec(count,arr);
        long ending = System.nanoTime();
        System.out.println(b + "\nElapsed time: " + (ending-beginning)/1000000.0);
    }

    public static boolean sumPrevRec(int a, int [] list){

        boolean result = false;

        if(a<=1){
            return result;
        }

        int n = list[a-1];

        for(int i = 0; i<a-1;i++){
            for(int k = i+1; k<a-1; k++){
                if ((list[i] + list[k]) == n) {
                    result = true;
                    break;
                }
            }
        }

        if(!result){
            return sumPrevRec((a-1),list);
        }else{
            return result;
        }
    }
}
