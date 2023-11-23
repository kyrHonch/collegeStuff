/*public class TestArraysAndRecursion {
    public static void main(String [] args){

        //Question 1

        int [][] arr = new int[4][5];
        HW07.intialize(arr);
        for (int[] y : arr) {
            System.out.print("[ ");
            for (int x = 0; x<y.length; x++){
                System.out.print((x == y.length-1) ? y[x] :  y[x] + ", ");
            }
            System.out.print(" ]\n");
        }

        Die d1 = new Die();
        Die d2 = new Die();
        Die d3 = new Die();
        Die d4 = new Die();
        Die d5 = new Die();
        Die d6 = new Die();
        Die [][] dice = {{d1,d2,d3},{d4,d5,d6}};
        int [] evens = HW07.dieStats(dice);

        //Question 2

        System.out.print("[");
        for(int x : evens){
            System.out.print(x + "\t");
        }

        System.out.print("]");
        //Question 3

        HW07.printDigits(23145);

        //Question 4
        int [] a = {1,3,2,5};
        System.out.println(HW07.sumArray(a, 4));

    }
}
*/