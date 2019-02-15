package com.mango.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * Permutation of a give word.
 * From: Sadhu sir
 */
public class Permutation {

    /**
     * Solving using BFS and using Heap's Algorithm to generate all permutation.
     * In case if you don't know about Heap's Algorithm, Go figure it out. 🤪
     *
     * @param sourceString
     * @return List of permutations
     */
    private List<String> generateAllPurmutation(String sourceString) {
        if (Objects.isNull(sourceString) ||
                "".equals(sourceString)) {
            return Collections.emptyList();
        }

        Set<String> visitedString = new HashSet<>();
        visitedString.add(sourceString);
        Queue<String> bfsQueue = new LinkedList<>();
        bfsQueue.add(sourceString);

        while(!bfsQueue.isEmpty()) {
            String processingRecord = bfsQueue.poll();
            for (int itr = 1; itr < processingRecord.length(); itr++) {
                String swappedString = swapTwoCharacterInString(processingRecord , 0, itr);
                if ( !visitedString.contains(swappedString)) {
                    bfsQueue.add(swappedString);
                    visitedString.add(swappedString);
                }
            }
        }
        return new ArrayList<>(visitedString);
    }

    private String swapTwoCharacterInString(String sourceString, int firstIndex, int secondIndex) {

        if (Objects.isNull(sourceString) ||
                "".equals(sourceString.trim()) ||
                firstIndex < 0 ||
                secondIndex > sourceString.length()) {
            return sourceString;
        }

        return sourceString.substring(0, firstIndex) +
                sourceString.charAt(secondIndex) +
                sourceString.substring(firstIndex + 1, secondIndex) +
                sourceString.charAt(firstIndex) +
                sourceString.substring(secondIndex + 1);
    }

    public void generatePermutation() {
        sampleTest1();
        sampleTest2();
        sampleTest3();
        sampleTest4();
    }

    private void sampleTest1() {
        String sourceString = "AB";
        List<String> permutedStringList = generateAllPurmutation(sourceString);
        System.out.println("Test: 1:\nGenerated ["+permutedStringList.size() +"] Permutations for String: "+ sourceString);
        System.out.println(permutedStringList);
        System.out.println("------------------------------------------");
    }

    private void sampleTest2() {
        String sourceString = "ABC";
        List<String> permutedStringList = generateAllPurmutation(sourceString);
        System.out.println("Test: 2:\nGenerated ["+permutedStringList.size() +"] Permutations for String: "+ sourceString);
        System.out.println(permutedStringList);
        System.out.println("------------------------------------------");
    }

    private void sampleTest3() {
        String sourceString = "ABCD";
        List<String> permutedStringList = generateAllPurmutation(sourceString);
        System.out.println("Test: 3:\nGenerated ["+permutedStringList.size() +"] Permutations for String: "+ sourceString);
        System.out.println(permutedStringList);
        System.out.println("------------------------------------------");
    }

    private void sampleTest4() {
        String sourceString = "MANGO";
        List<String> permutedStringList = generateAllPurmutation(sourceString);
        System.out.println("Test: 4:\nGenerated ["+permutedStringList.size() +"] Permutations for String: "+ sourceString);
        System.out.println(permutedStringList);
        System.out.println("------------------------------------------");
    }
}
