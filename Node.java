public class Node { 
   private Object element; 
   private Node next; 
   //constructor for Node
   public Node (Object object, Node n) {
      element = object; 
      next = n; 
   }
   //returns element
   public Object getElement() {
      
      return element; 
   } 
   //returns next
   public Node getNext() {
      return next;
   }
   //sets element
   public void setElement(Object newE) {
      element = newE; 
   }
   //sets next
   public void setNext(Node newN) {
      next = newN; 
   } 
}
