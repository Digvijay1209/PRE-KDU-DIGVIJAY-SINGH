package com.prekdu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/** Utility class to read a CSV file and print the top 3 most frequent words. */
public final class CSVWordFrequency {

  // Private constructor to prevent instantiation (utility class)
  private CSVWordFrequency() {
    // Prevent instantiation
  }

  // Declare constant for the top N frequent words
  /** Number of top frequent words to display. */
  private static final int TOP_N = 3;

  /**
   * Main method to read the CSV file and print the top 3 most frequent words.
   *
   * @param args command line arguments
   */
  public static void main(final String[] args) {
    String filePath = "resources/input.csv";
    Map<String, Integer> wordFrequencyMap = new HashMap<>();
    // Use the interface Map

    // Reading and processing the CSV file
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] words = line.split(",");
        for (String word : words) {
          word = word.trim().toLowerCase(Locale.ENGLISH);
          // Use Locale for case conversions

          // Update word frequency count in the map
          wordFrequencyMap.merge(word, 1, Integer::sum);
          // Using merge to avoid getOrDefault
        }
      }
    } catch (IOException e) {
      System.out.println("Error reading the file: " + e.getMessage());
    }

    printTopWords(wordFrequencyMap, TOP_N);
  }

  /**
   * Prints the top N most frequent words from the word frequency map.
   *
   * @param w the map containing words and their frequencies
   * @param n the number of top frequent words to display
   */
  private static void printTopWords(final Map<String, Integer> w, final int n) {
    // Priority Queue to store words by frequency in descending order

    Comparator<Map.Entry<String, Integer>> comparator =
        (a, b) -> Integer.compare(b.getValue(), a.getValue());
    Queue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(comparator);

    // Lambda expression

    maxHeap.addAll(w.entrySet());

    System.out.println("Top " + n + " repeated words:");
    int count = 0;
    while (count < n && !maxHeap.isEmpty()) {
      Map.Entry<String, Integer> entry = maxHeap.poll();
      System.out.println(entry.getKey() + ": " + entry.getValue());
      count++;
    }
  }
}
