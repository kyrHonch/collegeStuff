package cs113;//import java.util.*;

public class PS1 {
    public static int calls = 0;
    public static void main( String [] args){
  /*      Scanner s = new Scanner(System.in);
        System.out.println("Enter the 1st number");
        int a = s.nextInt();
        System.out.println("Enter the 2nd number");
        int b = s.nextInt();*/
        long beginning = System.nanoTime();
        //System.out.println(multi( 20000000,20000000));
        System.out.println(multi( 13,23));
        long ending = System.nanoTime();
        System.out.println("Elapsed time: " + (ending-beginning)/1000000.0);

        System.out.println("calls: " + calls);

    }

    public static long multi( int a, int b){
        calls+=1;
        if(b==1){
            return a;
        }else if(b%2==0){
            long y = multi(a,b/2);
            return y + y;
        }else{
            long y = multi(a,(b-1)/2);

            return a + y + y;
        }
    }
}
