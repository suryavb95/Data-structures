import java.util.Random;

public class BSTDemo {
   public static void main(String args[]) {
      Random randomNumber = new Random();
      BST tree = new BST();

      for (int i = 1; i <= 10; i++) {
         int value = randomNumber.nextInt(100);
         System.out.print(value + " ");
         tree.insert(value);
      }

      System.out.println("\n\nPreorder traversal");
      tree.preorderTraversal();

      System.out.println("\n\nInorder traversal");
      tree.inorderTraversal();

      System.out.println("\n\nPostorder traversal");
      tree.postorderTraversal();
      System.out.println();
   }
}