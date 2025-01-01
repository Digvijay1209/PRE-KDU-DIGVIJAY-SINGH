package com.prekdu;

import java.util.Scanner;

/** Utility class to demonstrate string comparison in Java. */
public final class StringComparison {

  // Private constructor to prevent instantiation
  private StringComparison() {
    // Utility class, prevent instantiation
  }

  /**
   * Main method that compares two strings based on their length and content.
   *
   * @param args command line arguments
   */
  public static void main(final String[] args) {
    // Use try-with-resources to ensure the Scanner is closed
    try (Scanner scanner = new Scanner(System.in)) {
      // Taking input of two strings
      System.out.println("Enter the first String");
      String input1 = scanner.nextLine();

      System.out.println("Enter the second String");
      String input2 = scanner.nextLine();

      // Printing lengths of both strings
      System.out.println("Length of the first String is: " + input1.length());
      System.out.println("Length of the second String is: " + input2.length());

      // Checking if lengths match
      if (input1.length() == input2.length()) {
        System.out.println("Length of both the strings are the same");

        // Checking if strings are the same
        if (input1.equals(input2)) {
          System.out.println("Both the Strings are the Same");
        } else {
          System.out.println("Both the Strings are not the Same");
        }
      } else {
        System.out.println("Length of both the Strings are not the same");
        System.out.println("Both the Strings are not the Same");
      }
    }
  }
}
