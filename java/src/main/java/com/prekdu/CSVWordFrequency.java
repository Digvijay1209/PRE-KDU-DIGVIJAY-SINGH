package com.prekdu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Comparator;

/*
 * Create a basic Java Program that reads a CSV file and prints the top 3 repeated words in the file.
 * The CSV file is in the reosurces folder and the file name is input.csv.
 */

public class CSVWordFrequency {
  public static void main(String[] args) {
    String filePath = "resources/input.csv";
    Map<String, Integer> wordFrequencyMap = new HashMap<>();
   
      // Reading  and processing the CSV file
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] words = line.split(",");
            for (String word : words) {
                word = word.trim().toLowerCase();// Cleaning and standardizing the words

                // Update word frequency count in the map
                wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
            }
        }
    } catch (IOException e) {
        System.out.println("Error reading the file: " + e.getMessage());
    }

    printTopWords(wordFrequencyMap, 3);
  }

  private static void printTopWords(Map<String, Integer> wordFrequencyMap, int n) {
    // Priority Queue to store words by frequency in descending order
    PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue).reversed());
    maxHeap.addAll(wordFrequencyMap.entrySet());

    System.out.println("Top " + n + " repeated words:");
    int count = 0;
    while (count < n && !maxHeap.isEmpty()) {
        Map.Entry<String, Integer> entry = maxHeap.poll();
        System.out.println(entry.getKey() + ": " + entry.getValue());
        count++;
    }
  }
}
