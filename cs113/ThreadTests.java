package cs113;

public class ThreadTests {

    public static void main( String [] args){
        MultiThreaddingThing mt = new MultiThreaddingThing();
        for(int i = 1; i<=5; i++){
            mt.start();
        }
    }
}
