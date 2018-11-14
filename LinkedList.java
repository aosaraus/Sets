public class LinkedList {
   protected Node head; 
   protected long size; 
   
   //constuctor for linkedlist
   public LinkedList() {
     head = new Node(null, null); 
     size = 0; 
   }

   //returns true if given object is contained in the set, false if otherwise
   public boolean contain(Object object) {
      Node curNode = head.getNext();
      boolean contains = false;  
      while (curNode != null && !curNode.getElement().equals(object)) {
         if (curNode.getElement().equals(object)) {
            contains = true;
         } else {
         curNode = curNode.getNext();
         } 
      }
      return contains;       
   }
  
   //returns true if the node containing the object is removed from the set and false otherwise
   public boolean remove(Object object) {
      Boolean removed = false;
      Node tempNode = head;
      Node prevNode = null;
      Node c = null;
      if(tempNode == null)
         throw new IllegalStateException("List is empty");
   
      while(tempNode.getNext() != null){
         if(tempNode.getNext().getElement().equals(object)) {
            if(tempNode == head) {
               head = head.getNext();
            } else { 
               c = tempNode.getNext().getNext();
               prevNode.getNext().getNext().setNext(c);
            }
            removed = true;
         } else {
            prevNode = tempNode;
         }
         tempNode = tempNode.getNext();
      }   
      return removed;
   } 
 
   //returns false if element not added because it is already in the set
   public boolean addElement(Object object) {
      boolean added = false;
      if (head == null) {
         head = new Node(object, null);
         added = true;
      } else {
         Node curNode = head.getNext();
         Node v = new Node (object, null);
         int counter = 0;   
         while (curNode != null) {
            if(curNode.getElement().equals(object)) {
                counter++; 
            }
            curNode = curNode.getNext();
         }
         if (counter == 0) {
             v.setNext(head.getNext());
             head.setNext(v);
             size ++;
             added = true;
         } 
      } 
      return added;
   } 
 
   //returns an integer equal to the number of distinct objects are in the set
   public int size() { 
      if (head.getNext() == null) throw new IllegalStateException("This list is empty"); 
      Node curNode = head.getNext();
      int size = 0; 
      while(curNode != null) {
         size++; 
         curNode = curNode.getNext();
      }
      return size;
   }
  
   //returns true if every element in set A is in set B 
   public boolean subsetOf(LinkedList b) {
      boolean subsetOf = false;
      int counterA = 0; //counts size of setA
      int counterB = 0; //counts size of setB
      int counterAB = 0; //counts how many times element in setA is found in set B
      Node tempA = head.getNext();
      Node tempB = b.head.getNext();
      while(tempA != null){ 
         counterA++;
         tempA = tempA.getNext();
      }
      while(tempB != null) {
        counterB++;
        tempB = tempB.getNext();
      }
      if(counterA <  counterB) {
         tempA = head.getNext();
         tempB = b.head.getNext();      
         while(tempB != null) {
            if(tempA.getElement() == tempB.getElement()) {
               counterAB++;
               tempB =tempB.getNext(); 
            } else {
               tempB = tempB.getNext(); 
               if( tempA == null){
                  tempB = b.head.getNext();
                  tempA = head.getNext();
               }
            }
         }
      } 
      //checks if all elements in setA are in B
      if(counterA == counterAB){ 
         subsetOf = true;
      }
      return subsetOf;
   } 

   //returns true if both sets contain the same element where order in either set does not count 
   public boolean isEqual(LinkedList b) { 
      boolean isEqual = false;
      int counterA = 0; //size of setA
      int counterB = 0; //size of setB
      int counterAB =0; //counts occurences
      Node tempA = head.getNext(); 
      Node tempB = b.head.getNext();
      while(tempA!=null){
         counterA++; 
         tempA = tempA.getNext(); 
      }
      while(tempB!= null){
         counterB++;
         tempB = tempB.getNext();
      }
      if(counterA == counterB){
         tempA = head.getNext();
         tempB = b.head.getNext(); 
         while(tempA != null) {
            if(tempA.getElement() == tempB.getElement()){
               counterAB++;
               tempA = tempA.getNext();
            }else{ 
                tempB = tempB.getNext(); 
                if (tempB == null){
                   tempB = b.head.getNext();
                   tempA = tempA.getNext();
                }
            }
         }
      }
      if(counterAB == counterA){
         isEqual = true;
      }
      return isEqual; 
   }

   //if a,b,c are sets, has the form C=A.union(B). Union returns a set that contains all the elementsin set 
   //A and B, but only list duplicates once
   public LinkedList intersection (LinkedList b) {
      LinkedList setC = new LinkedList();
      Node tempA = head.getNext();
      Node tempB = b.head.getNext();
      while(tempA != null){
         if(tempA.getElement() == tempB.getElement()) {
            setC.addElement(tempA.getElement());
            tempB = b.head.getNext();
            tempA = tempA.getNext();
         } else {
            tempB = tempB.getNext();
            if(tempB == null){
               tempB = b.head.getNext();
               tempA = tempA.getNext();
            }
         }
      }
      return setC;     
   }

   //if a, b, c are sets, has form C=A.intersection(B) and returns a set containing only elements that are 
   // common to both A and B. But no duplicates 
   public LinkedList union (LinkedList b) { 
      LinkedList setC = new LinkedList(); 
      Node tempA = head.getNext();
      Node tempB = b.head.getNext();

      while(tempA != null) {
         setC.addElement(tempA.getElement());
         tempA = tempA.getNext();
      }
      tempA = head.getNext();
      while(tempB != null) {
         if(tempB.getElement() != tempA.getElement()){
            setC.addElement(tempB.getElement());
            tempB = tempB.getNext();
            tempA = head.getNext();
         } else {
            tempA = tempA.getNext();
            if (tempA  == null){
               tempA = head.getNext();
               tempB = tempB.getNext();
            }
         }
      }
      return setC;
   } 
   
   //if a, b, c are sets has form C=A.complement(B) and returns a set containing only elements that are in A 
   // but not in B 
   public LinkedList complement(LinkedList b) {
      LinkedList setC = new LinkedList(); 
      Node tempA = head.getNext();
      Node tempB = b.head.getNext();
      int counterAB = 0;
      while(tempA != null){
         if(tempA.getElement() == tempB.getElement()){
            counterAB++;
            tempB = b.head.getNext();
            tempA = tempA.getNext();
         } else {
            tempB = tempB.getNext();
            if(tempB == null) {
               if(counterAB == 0){
                  setC.addElement(tempA.getElement());
               } 
               tempB = b.head.getNext();
               tempA = tempA.getNext();
               counterAB  = 0;
            }
         }
      }
      return setC;
   }

   //displays a message that indicates an object's state. An object's state is the data that is tored in the 
   // objects field at any given moment
   public String toString() {
      String newN = "";
      newN += "Linked List: ";
      
      Node curNode = head.getNext();
      if (curNode ==  null)
         newN += "empty list";
      while (curNode != null) {
         newN += "[" + curNode.getElement().toString() + "]";
         curNode = curNode.getNext();
      }
      return newN;
   }
}



