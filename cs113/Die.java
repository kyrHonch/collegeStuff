package cs113;

public class Die {
    
   //attributes
   private int faceValue;

   //operations
   //default constructor
   public Die(){
      //faceValue = 2;
      roll();
   }
   //non-default constructor
   public Die(int face) {
      faceValue = face;
   }
   
   //roll method
   public void roll() {
      faceValue = (int)(Math.random() * 6) + 1;
   }
   //getter
   public int getFaceValue() {
      return faceValue;
   }
   //setter
   public void setFaceValue(int face){
      faceValue = face;
   }
   //toString
   public String toString() {
      return ""+ faceValue;//String.valueOf(faceValue)
   }
}