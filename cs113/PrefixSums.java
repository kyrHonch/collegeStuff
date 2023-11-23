package cs113;


import java.util.Random;

public class PrefixSums {

    public static void main(String[] args) {
        /*int n = 0;  //length of array
        long seed = 0; // for pseudo-random number generator
        int k = 0;  // index of result to print out
        if(args.length != 3) {
            System.out.println("Supply length, seed, and index as arguments.");
            System.exit(0);
        } else {
            n = Integer.parseInt(args[0]);
            seed = Long.parseLong(args[1]);
            k = Integer.parseInt(args[2]);
            if(k<0 || k>n-1) {
                System.out.println("Invalid index "+k);
                System.exit(0);
            }
        }

        Random rand = new Random(seed);
        int[] X = new int[n];

        // Populate array with random integers between -5 and 5.
        for(int i=0; i<n; ++i)
            X[i] = rand.nextInt(11) -5;

        for(int i : X){
            System.out.print(i + " ");
        }

        System.out.println();

       */
        int [] X = {-1,1,3,3,4,-3};
        X = prefixSums2(X);
        System.out.println(X[4]);

    }


    public static int[] prefixSums2(int[] A)
    {
        int [] tempArr = new int[A.length];
        int sum = 0;
        for(int i=0; i<A.length; ++i)
        {
            sum = sum + A[i];

            tempArr[i] = sum;
        }
        int [] outP = new int[A.length];
        sum = 0;
        for(int i=0; i<tempArr.length; ++i)
        {
            sum = sum + tempArr[i];
            outP[i] = sum;
        }
        return outP;
    }



}
