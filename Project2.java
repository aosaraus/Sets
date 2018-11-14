import java.util.Scanner;

public class Project2 {
   public static void main(String [] args) {
      LinkedList setA = createA();
  
      System.out.println(setA.toString());
      System.out.println("Set A size: " + setA.size());

      LinkedList setB = createB(); 

      System.out.println(setB.toString());
      System.out.println("Set B size: " + setB.size());
      
      setsC(setA, setB);
   }  
   
   //create set A
   public static LinkedList createA() {
      Scanner kb = new Scanner(System.in); 
      LinkedList setA = new LinkedList();
      System.out.println("How many integers would you like to enter into set A: ");
      int setNumber = kb.nextInt(); 
      //use for loop to allow user to input x number of elements
      System.out.println("Please enter numbers you would like to store into the set: ");
      for(int i = 0; i < setNumber; i++){
         setA.addElement(kb.nextInt());
      } 
      return setA;
   }  
 //creates set B  
   public static LinkedList createB(){
      Scanner kb = new Scanner(System.in); 
      LinkedList setB = new LinkedList(); 
      System.out.println("How many integers would you like to enter into set B: ");
      int setNumber = kb.nextInt();

      System.out.println("Please enter numbers you would like to store into the set: ");
      for(int i = 0; i < setNumber; i++){
         setB.addElement(kb.nextInt());
      }
      return setB;
   }
   //implements union, complement, and intersection methods
   public static void setsC(LinkedList setA, LinkedList setB){
      LinkedList setC = new LinkedList();
      LinkedList setC2 = new LinkedList();
      LinkedList setC3 = new LinkedList();
      setC = setA.union(setB);
      System.out.println("Union of set A and set B: " + setC.toString());
  
      setC2 = setA.complement(setB);
      System.out.println("Complement of set A and set B: " + setC2.toString());
 
      setC3 = setA.intersection(setB);
      System.out.println("Intersection of setA and set B: " + setC3.toString());

   }
  
}
