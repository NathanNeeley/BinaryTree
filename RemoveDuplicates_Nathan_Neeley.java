   // Name:       Nathan Neeley
// Class:      CS 5040
// Term:       Spring 2020
// Instructor: Dr. Haddad
// Assignment: 5
// IDE:        jGrasp

import java.util.*;
import java.io.*;

public class RemoveDuplicates_Nathan_Neeley {
   public static void main(String[] args) throws Exception {
   
      Scanner input = new Scanner(System.in);
      int number = -1; 
      
      do {
         try {
         //MAIN MENU
            System.out.println("\n---MAIN MENU------"); //heading for options to execute in program
            System.out.println("0 - Exit Program");
            System.out.println("1 - Read Input From Text File");
            System.out.println("2 - Read Input From Keyboard");
            System.out.print("Enter menu option: "); //prompt user for menu option
            number = input.nextInt(); //read menu option from user
            
            switch (number) {
            
               case 0:
                  break;
               
               //call FileInput method
               case 1: 
                  Scanner scan = new Scanner(System.in);
                  System.out.print("Enter input text file: ");
                  String inputFile = scan.next();
               
                  File file = new File(inputFile);
                  BST_Nathan_Neeley<String> tree = new BST_Nathan_Neeley<>();
                  String temp = "";
               
                  if (!file.exists()) {
                     System.out.println("File doesn't exists.");
                     System.exit(1);
                  }
                  else {
                     Scanner InputFile = new Scanner(file);
                     while (InputFile.hasNext()) {
                        temp = InputFile.next();
                        tree.insert(temp);
                     }
                     InputFile.close();
                  }
               
                  System.out.println("\nProcessed text is saved to output file.");
                  PrintStream original = System.out;              
                  File output = new File("output.txt");
                  FileOutputStream fileOutputStream = new FileOutputStream(output);
                  PrintStream printStream = new PrintStream(fileOutputStream);
               
                  System.setOut(printStream);
                  tree.inorder();              
               
                  //close the streams
                  printStream.close();       
                  fileOutputStream.close();
               
                  System.setOut(original);  //set outputs back to original state             
                  break;      
               
               //call keyboardInput method
               case 2:
                  input.nextLine();
                  System.out.print("Input from Keyboard: ");
                  String keyboardInput = input.nextLine();
                  KeyboardInput(keyboardInput);
                  break;
               
               default: 
                  System.out.println("Option not in list. Re-enter menu option."); //default menu option that continues loop
            }
         }
         //catch exception if something besides an integer is entered
         catch (InputMismatchException ex) {
            System.out.println("Invalid input. Re-enter menu option."); //error message
            input.nextLine(); //discard input
         }
      } while (number != 0);
      System.out.println("Program is terminated.");
      
   }
         
   //print out processed keyboard input 
   public static void KeyboardInput(String keyboardInput) {
   
      String temp = "";
      BST_Nathan_Neeley<String> tree = new BST_Nathan_Neeley<>();
      
      System.out.println("Original Text: \n" + keyboardInput);
      for (int i = 0; i < keyboardInput.length(); i++) {
         if (i == keyboardInput.length() - 1) {
            temp = temp + keyboardInput.charAt(i); //last run that adds character to string2
            tree.insert(temp);
         }
         else if (Character.isWhitespace(keyboardInput.charAt(i))) {
            tree.insert(temp); //add string2 to stack if whitespace detected
            temp = ""; //string2 is reset
         }
         else
            temp = temp + keyboardInput.charAt(i); //add character to string2
      }
      
      System.out.println("\nProcessed Text: ");
      tree.inorder();
   }
}