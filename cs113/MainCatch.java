package cs113;

import cs113.BonusTooLowException;
import cs113.Executive;

import java.util.Scanner;

public class MainCatch {
    public static void main (String [] args ){
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the length of the executive array");
        int l = s.nextInt();

        Executive[] exArr = new Executive[l];
        for(int i = 0; i<exArr.length; i++){

            System.out.print("Enter the name of the executive: ");
            String name = s.nextLine();

            System.out.print("Enter the address of the executive: ");
            String address = s.nextLine();

            System.out.print("Enter the phone number of the executive: ");
            String phone = s.nextLine();

            System.out.print("Enter the social security of the executive: ");
            String ssn = s.nextLine();

            System.out.print("Enter the pay rate amount(double): ");
            double rate = s.nextDouble();

            System.out.print("Enter the bonus amount(double): ");
            double bonus = s.nextDouble();

            exArr[i] = new Executive(name,address,phone,ssn,rate);

            try{
                exArr[i].awardBonus(bonus);
                
            }catch (BonusTooLowException e){
                System.out.println("Bonus cannot be lower than $2000");
            }
        }

        System.out.println("\n____________________________\n\nExecutives:");

        for (Executive executive : exArr)
        {

            System.out.println(executive);
            System.out.println("____________________________");

        }
    }
}
