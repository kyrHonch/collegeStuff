/*public class HW07 {

    public static void intialize(int [][] arr){
       for(int y = 0; y<arr.length;y++){
           for(int x = 0; x<arr[y].length;x++){
               if(x==y){
                   arr[y][x] = -1;
               }else{
                   arr[y][x] = x+y;
               }
           }
       }

    }

    public static int [] dieStats(Die [][] dice){
        int [] arr = new int [dice.length];

        for(int i = 0; i<dice.length; i++){
            int counter = 0;
            for(Die d : dice[i]){
                d.roll();
                if(d.getFaceValue() % 2 == 0){
                    counter++;
                }
            }
            arr[i] = counter;
        }
        return arr;
    }

    public static void printDigits(int n){
        if(n<10){
            System.out.println(n);
        }else {
            System.out.println(n / (int) Math.pow(10, ((int) (Math.log10(n)))));
            printDigits(n % (int) Math.pow(10, ((int) (Math.log10(n)))));
        }
    }

    public static int sumArray(int[] numArray, int numbersToAdd){
        if(numbersToAdd == 1){
            return numArray[numbersToAdd-1];
        }else{
            return numArray[numbersToAdd-1] + sumArray(numArray, numbersToAdd-1);
        }

    }
}*/
