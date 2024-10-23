package com.csc;

import java.util.ArrayList;

public class FuzzyFinder {
  int binarySearch(ArrayList<Fuzzy> list){
    int lo = 0;
    int hi = list.size()-1;
    while(lo<=hi){
      int mid = lo + (hi-lo)/2;
      if (list.get(mid).color.compareTo("gold") ==  0) { return mid; }
      if (list.get(mid).color.compareTo("gold") < 0) { lo = mid + 1; }
      else { hi = mid - 1; }
    }
    return -1;
  }

  int linearSearch(ArrayList<Fuzzy> list){
    for(int i=0; i<list.size(); i++){
      if (list.get(i).color == "gold"){
        return i;
      }
    }
    return -1;
  }

  public static void main(String args[]) {
    FuzzyListGenerator generator = new FuzzyListGenerator();
    FuzzyFinder finder = new FuzzyFinder();
    ArrayList<Fuzzy> sortedFuzzies = generator.sortedRainbowFuzzies();
    ArrayList<Fuzzy> randomFuzzies = generator.randomizedRainbowFuzzies();
    int testOne = finder.linearSearch(randomFuzzies);
    int testTwo = finder.linearSearch(sortedFuzzies);
    int testThree = finder.binarySearch(sortedFuzzies);
    int testFour = finder.binarySearch(randomFuzzies);
    System.out.println("Test result indices\n");
    System.out.println("Random List Tests");
    //test one should be equal to test four
    System.out.print("Linear: " +  testOne + "   Binary: ");
    System.out.println(testFour + "\n");
    System.out.println("Sorted List Tests");

    //test two should be equal to test three
    System.out.print("Linear: "+ testTwo + "   Binary: ");
    System.out.println(testThree);
  }
}
