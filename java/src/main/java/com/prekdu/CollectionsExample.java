package com.prekdu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*Utilityclassdemonstrating Java collections */
/* : ArrayList, HashSet, and HashMap. */
public final class CollectionsExample {

  // Private constructor to prevent instantiation
  private CollectionsExample() {
    // Utility class, prevent instantiation
  }

  /** The number of strings to be input by the user. */
  private static final int NUM_STRINGS = 10;

  /**
   * Main method to demonstrate collections usage in Java.
   *
   * @param args command line arguments
   */
  public static void main(final String[] args) {
    List<String> stringList = new ArrayList<>();
    Set<String> uniqueStringsSet = new HashSet<>();
    Map<String, Integer> wordFrequencyMap = new HashMap<>();

    // Use try-with-resources to ensure Scanner is closed
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("Enter " + NUM_STRINGS + " strings:");

      for (int i = 0; i < NUM_STRINGS; i++) {
        String inputString = scanner.nextLine();
        stringList.add(inputString);
        int count = wordFrequencyMap.getOrDefault(inputString, 0);
        wordFrequencyMap.put(inputString, count + 1);
      }
    }

    System.out.println("\nArrayList contents:");
    for (String string : stringList) {
      System.out.println(string);
    }

    System.out.println("\nHashSet contents (unique values):");
    for (String string : uniqueStringsSet) {
      System.out.println(string);
    }

    System.out.println("\nHashMap contents (word frequencies):");
    for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
      System.out.println(entry.getKey() + " : " + entry.getValue());
    }
  }
}
