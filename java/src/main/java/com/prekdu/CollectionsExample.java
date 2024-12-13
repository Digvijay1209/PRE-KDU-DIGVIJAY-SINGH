package com.prekdu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;
/*
 * Create a basic Java Program that takes 10 strings as input and adds them to an ArrayList and
 * HashSet. Also, create a HashMap by populating the words as key and frequency as the value in the
 * map. Iterate the list, set and map and print the content of the collection.
 */

public final class CollectionsExample {

  public static void main(String[] args) {
    // Created the collections to store strings, unique strings, and frequency map
    ArrayList<String> stringList = new ArrayList<>();
    HashSet<String> uniqueStringsSet = new HashSet<>();
    HashMap<String, Integer> wordFrequencyMap = new HashMap<>();
    
    // Created a scanner object to read user input
    Scanner scanner =new Scanner(System.in);

   // Asking  the user to enter 10 strings
   System.out.println("Enter 10 strings:");

   for(int i=0;i<10;i++)
   {
     String inputString=scanner.nextLine();

     // Adding the input string to ArrayList (duplicates allowed)
     stringList.add(inputString);
      
     // Adding the input string to HashSet (duplicates automatically removed)
     uniqueStringsSet.add(inputString);
     
     // Updating the frequency of the input string in HashMap
     if (wordFrequencyMap.containsKey(inputString))
      {
        wordFrequencyMap.put(inputString, wordFrequencyMap.get(inputString) + 1);
      } 
    else 
     {
      wordFrequencyMap.put(inputString, 1); 
     }

   }

   scanner.close();
   
  // Printing the contents of the ArrayList
   System.out.println("\nArrayList contents:");
   for (String string : stringList) 
   {
    System.out.println(string);
   }

    // Printing the contents of the HashSet (unique values only)
    System.out.println("\nHashSet contents (unique values):");
    for (String string : uniqueStringsSet) {
      System.out.println(string);
    }

    // Printing the contents of the HashMap (word frequencies)
    System.out.println("\nHashMap contents (word frequencies):");
    for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
      System.out.println(entry.getKey() + " : " + entry.getValue());
    }
  }
}
