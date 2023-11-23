package cs113;

public class MainDriver {

   public static void main(String [] args){

       MonetaryCoin [] arr = new MonetaryCoin[20];
       int largestV = 0;

       for(MonetaryCoin m : arr) {
           m = new MonetaryCoin((int) (Math.random() * 100) + 1);
           if (!m.isHeads()) {
               if (largestV < m.getValue()) {
                   largestV = m.getValue();
               }
           }
       }
       System.out.println("Largest value of the coin with Tails is " + largestV + ".");
   }
}