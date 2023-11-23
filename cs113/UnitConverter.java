package cs113;

import java.util.*;

public class UnitConverter {
    public static void main(String args []){
        //Question 1
        int in = 80;
        System.out.println(in + " inches is " + in/12 + " feet " + in%12 + " inches.");

        //Question 2
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the weight of an object in grams please: ");
        double grams = s.nextDouble();
        System.out.println(grams/453.592 + " pounds.");

        //Question 3
        System.out.println("Enter the weight of an object in milligrams please: ");
        int weight = s.nextInt();
        int kg = weight/1000000, g = (weight - kg*1000000) / 1000, mg = (weight - kg*1000000 - g*1000);
        System.out.println(weight + " milligrams are equivalent to " + weight/1000000 + " kilogram, " + g + " grams, and " + mg + " milligrams.");

    }
}
