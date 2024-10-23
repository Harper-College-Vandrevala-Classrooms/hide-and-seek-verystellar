package com.csc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestFuzzyFinder {

  FuzzyFinder finder;
  FuzzyListGenerator generator;

  @BeforeEach
  void setUp() {
    finder = new FuzzyFinder();
    generator = new FuzzyListGenerator(1); //note one iteration specified
  }

  @Test
  void testingSortedLinearAndBinary() {
    ArrayList<Fuzzy> fuzzies = generator.sortedRainbowFuzzies();
    int idxlin = finder.linearSearch(fuzzies);
    int idxbin = finder.binarySearch(fuzzies);

    assertEquals("blue", fuzzies.get(0).color); //blue should be #1 alphabetically
    assertEquals(1, idxlin); //gold should be #2 alphabetically
    assertEquals(1, idxbin); //should get same as above

  }
}
