   // Name:       Nathan Neeley
// Class:      CS 5040
// Term:       Spring 2020
// Instructor: Dr. Haddad
// Assignment: 5
// IDE:        jGrasp

public class TestBSTDelete_Nathan_Neeley {
   public static void main(String[] args) {
   
     //create BST 
      BST_Nathan_Neeley<String> tree = new BST_Nathan_Neeley<>();
      tree.insert("George");
      tree.insert("Michael");
      tree.insert("Tom");
      tree.insert("Adam");
      tree.insert("Jones");
      tree.insert("Peter");
      tree.insert("Daniel");
      printTree(tree);
      
      //delete from tree
      System.out.println("\nAfter delete George:");
      tree.delete("George");
      printTree(tree);
      
      //delete from tree
      System.out.println("\nAfter delete Adam:");
      tree.delete("Adam");
      printTree(tree);
      
      //delete from tree
      System.out.println("\nAfter delete Michael:");
      tree.delete("Michael");
      printTree(tree);
   }
  
    //traverse Tree with different orders
   public static void printTree(BST_Nathan_Neeley tree) {
   
      System.out.print("Inorder (sorted): ");
      tree.inorder();
      System.out.print("\nPostorder: ");
      tree.postorder();
      System.out.print("\nPreorder: ");
      tree.preorder();
      System.out.print("\nThe number of nodes is " + tree.getSize());
      System.out.println();
   }
}