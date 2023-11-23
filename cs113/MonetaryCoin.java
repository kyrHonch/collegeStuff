package cs113;

import cs113.Coin;

public class MonetaryCoin extends Coin {

    private int value;

    public MonetaryCoin(int value){
        this.value = value;

    }

    public void setValue(int value){

        this.value = value;

    }

    public int getValue(){
        return value;
    }

    public String toString(){
        return "Coin's value is " + value  + ". Face:  " + super.toString();
    }

}
