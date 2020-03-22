// Name:       Nathan Neeley
// Class:      CS 5040
// Term:       Spring 2020
// Instructor: Dr. Haddad
// Assignment: 5
// IDE:        jGrasp

import java.io.*;

public class BST_Nathan_Neeley<E extends Comparable<E>>
   extends AbstractTree_Nathan_Neeley<E> {
   protected TreeNode<E> root;
   protected int size = 0;
   
   //create a default binary search tree
   public BST_Nathan_Neeley() {     //no argument constructor
   }
   //create a binary search tree from an array of objects
   public BST_Nathan_Neeley(E[] objects) {           //constructor
      for (int i = 0; i < objects.length; i++) 
         insert(objects[i]);
   } 
       
   @Override //return true if the element is in the tree
    public boolean search (E e) {
      TreeNode<E> current = root; //start from the root
      while (current != null) {
         if (e.compareTo(current.element) < 0) {
            current = current.left;
         }
         else if (e.compareTo(current.element) > 0) {
            current = current.right;
         }
         else //element matches current.element
            return true; //element is found
      }
          
      return false;
   }
        
   @Override //insert element e into the binary search tree.
        //return true if the element is inserted successfully
   public boolean insert(E e) {
      if (root == null)
         root = createNewNode(e);  //create a new root
          
      else { //locate the parent node
         TreeNode<E> parent = null;
         TreeNode<E> current = root;
         while (current != null)
            if (e.compareTo(current.element) < 0) {
               parent = current;
               current = current.left;
            }
            else if (e.compareTo(current.element) > 0) {
               parent = current;
               current = current.right;
            }
            else
               return false;  //duplicate node not inserted
                     
         //create the new node and attach it to the parent node
         if (e.compareTo(parent.element) < 0)
            parent.left = createNewNode(e);
         else
            parent.right = createNewNode(e);
      }
                         
      size++;
      return true; //element inserted successfully
   }
   
   //createNewNode
   protected TreeNode<E> createNewNode(E e) {
      return new TreeNode<>(e);
   }      
                         
   @Override //inorder traversal from the root
   public void inorder() {
      inorder(root);
   }
                        
    //inorder traversal from a subtree
   protected void inorder(TreeNode<E> root) {
      if (root == null) 
         return;
      inorder(root.left);
      System.out.print(root.element + " ");
      inorder(root.right);
   }
                         
   @Override //postorder traversal from the root
   public void postorder() {
      postorder(root);
   }
                         
    //postorder traversal from a subtree
   protected void preorder (TreeNode<E> root) {                      
      if(root == null) 
         return;
      postorder(root.left);
      postorder(root.right);
      System.out.print(root.element + " ");
   }
                           
   @Override //preorder traversal from the root
   public void preorder() {
      preorder(root);
   }
                              
    //preorder traversal from a subtree
   protected void postorder(TreeNode<E> root) {
      if (root == null) 
         return;
      System.out.print(root.element + " ");
      preorder(root.left);
      preorder(root.right);
   }
                             
    //this inner class is static bc/ it does not access any 
    //instance members defined in its outer class
   public static class TreeNode<E extends Comparable<E>> {
      protected E element;
      protected TreeNode<E> left;
      protected TreeNode<E> right;
                              
      public TreeNode(E e) {
         element = e;
      }
   }    
                             
   @Override //get the number of nodes in the tree
   public int getSize() {
      return size;
   }
                              
    //return root of the tree
   public TreeNode<E> getRoot() {
      return root;
   }
                               
    //return a path from the root leading to the specified element
   public java.util.ArrayList<TreeNode<E>> path(E e) {
      java.util.ArrayList<TreeNode<E>> list =
                                    new java.util.ArrayList<>();
      TreeNode<E> current = root;   //start from the root
                                  
      while (current != null) {
         list.add(current); //add the node to the list
         if (e.compareTo(current.element) < 0) {
            current = current.left;
         }
         else if (e.compareTo(current.element) > 0) {
            current = current.right;
         }
         else
            break;
      }
                                         
      return list; //return an array list of nodes
   }
                                         
   @Override /*delete an element from the binary search tree 
   return true if the element is deleted successfully
   return false if element is not in the tree*/
   public boolean delete(E e) {
    //locate the node to be deleted and also locate its parent node
      TreeNode<E> parent =  null;
      TreeNode<E> current = root;
      while (current != null) {
         if (e.compareTo(current.element) < 0) {
            parent = current;
            current = current.left;
         }
         else if (e.compareTo(current.element) > 0) {
            parent = current;
            current = current.right;
         }
         else
            break; //element is in the tree pointed at by current
      }
                                           
      if (current == null)
         return false;  //element is not in the tree
                                             
      //case 1: current has no left child
      if (current.left == null) {
         //connect the parent with the right child of the current node
         if (parent == null) {
            root = current.right;
         }
         else {
            if (e.compareTo(parent.element) < 0)
               parent.left = current.right;
            else
               parent.right = current.right;
         }
      }    
      else{
      //case 2: the current node has a left child
      //locate the rightmost node in the left subtree of the
      //current node and also its parent
         TreeNode<E> parentOfRightMost = current;
         TreeNode<E> rightMost = current.left;
                                                         
         while (rightMost.right != null) {
            parentOfRightMost = rightMost;
            rightMost = rightMost.right; //keep going to the right
         }
                                                          
         //replace the element in current by the element in rightMost
         current.element = rightMost.element;
                                                          
         //eliminate rightmost node
         if (parentOfRightMost.right == rightMost)
            parentOfRightMost.right = rightMost.left;
                                                           
         else 
         //special case: parentOfRightMost == current
            parentOfRightMost.left = rightMost.left;
      }
      size--;
      return true;  //element deleted successfully
   }
                                                            
   @Override //obtain an iterator.use inorder
   public java.util.Iterator<E> iterator() {
      return new InorderIterator();
   }
                                                             
    //inner class inorderIterator
   private class InorderIterator implements java.util.Iterator<E> {
      //store the elements in a list
      private java.util.ArrayList<E> list = new java.util.ArrayList<>();
      private int current = 0;  //point to the current element in list
                                                                
      public InorderIterator() {
         inorder();  //traverse binary tree and store elements in list
      }
                                                                  
       //inorder traversal form the root
      private void inorder() {
         inorder(root);
      }
                                                                   
       //inorder traversal from a subtree
      private void inorder(TreeNode<E> root) {
         if (root == null) 
            return;
         inorder(root.left);
         list.add(root.element);
         inorder(root.right);
      }
                                                                     
      @Override //more elements for traversing?       
      public boolean hasNext() {
         if (current < list.size())
            return true;
                                                                           
         return false;
      }
                                                                         
      @Override //get the current element and move to the next
      public E next() {
         return list.get(current++);
      } 
                                                                           
      @Override //remove the current element
      public void remove() {
         delete(list.get(current));   //delete the current element
         list.clear();  //clear the list
         inorder();   //rebuild the list
      }
   }
                                                                            
    //remove all elements form the tree
   public void clear() {
      root = null;
      size = 0;
   }
}    
