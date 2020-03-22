// Name:       Nathan Neeley
// Class:      CS 5040
// Term:       Spring 2020
// Instructor: Dr. Haddad
// Assignment: 5
// IDE:        jGrasp

public interface Tree_Nathan_Neeley<E> extends Iterable<E> {
   //return true if the element is in the tree
   public boolean search(E e);
   
   //insert element e into the binary search tree
   //return true if the element is inserted sucessfully
   public boolean insert(E e);
   
   //delete the specified element from the tree
   //return true if the element is deleted successfully
   public boolean delete(E e);
   
   //inorder traversal from the root
   public void inorder();
   
   //post order traversal form the root
   public void postorder();
   
   //preorder traversal from the root
   public void preorder();
   
   //get the number of nodes in the tree
   public int getSize();
   
   //return true if the tree is empty
   public boolean isEmpty();
}   
