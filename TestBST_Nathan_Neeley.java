// Name:       Nathan Neeley
// Class:      CS 5040
// Term:       Spring 2020
// Instructor: Dr. Haddad
// Assignment: 5
// IDE:        jGrasp

public class TestBST_Nathan_Neeley {
   public static void main(String[] args) {
      //create a BST
      BST_Nathan_Neeley<String> tree = new BST_Nathan_Neeley<>();
      tree.insert("George");
      tree.insert("Michael");
      tree.insert("Tom");
      tree.insert("Adam");
      tree.insert("Jones");
      tree.insert("Peter");
      tree.insert("Daniel");
      
      //traverse tree
      System.out.print("Inorder (sorted): ");
      tree.inorder();
      System.out.print("\nPostorder: ");
      tree.postorder();
      System.out.print("\nPreorder: ");
      tree.preorder();
      System.out.print("\nThe number of nodes is " + tree.getSize());
      
      //search for an element
      System.out.print("\nIs Peter in the tree? " + tree.search("Peter"));
      
      //get a path from the root to peter
      System.out.print("\nA path from the root to Peter is: ");
      java.util.ArrayList<BST_Nathan_Neeley.TreeNode<String>> path
         = tree.path("Peter");
      for (int i = 0; path != null && i < path.size(); i++)
         System.out.print(path.get(i).element + " ");
      
      //create a BST
      Integer[] numbers = {2,4,3,1,8,5,6,7};
      BST_Nathan_Neeley<Integer> intTree = new BST_Nathan_Neeley<>(numbers);
      System.out.print("\nInorder (sorted): ");
      intTree.inorder();
   }
}    
