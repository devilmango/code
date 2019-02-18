package com.mango.problems;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Get length of longest non-repeating sequence from a string
 * Source: Sadhu sir
 */
public class NonRepeatingStringSequence {

    private int getMaxLenthNonRepeatingSequence(String sourceString) {

        List<SequenceHolder> sequenceHolderList = generateLongestNonRepeatingSequence(sourceString);
        if (sequenceHolderList.isEmpty()) {
            return 0;
        }

        int maxLength = 0;
        for (SequenceHolder sequenceHolder : sequenceHolderList) {
            int sequenceHolderSequenceLength = sequenceHolder.sequence.length();
            if (sequenceHolderSequenceLength > maxLength) {
                maxLength = sequenceHolderSequenceLength;
            }
        }
        return maxLength;
    }

    private List<SequenceHolder> generateLongestNonRepeatingSequence(String sourceString) {
        if ( sourceString == null || sourceString.length() == 0 ) {
            return Collections.emptyList();
        }

        Map<Character, Integer> mapOfCharacter = new HashMap<>();
        List<SequenceHolder> sequenceHolderSet = new LinkedList<>();
        int beginIndex = 0;
        int iterator = 0;
        for (; iterator < sourceString.length(); iterator++) {
            Character character = sourceString.charAt(iterator);
            if(!mapOfCharacter.containsKey(character)) {
                mapOfCharacter.put(character, iterator);
                continue;
            }
            // Found a repeating character. Thus capture non-repeating sequence so far.
            String nonRepeatingSequenceSoFar = sourceString.substring(beginIndex, iterator);
            sequenceHolderSet.add(new SequenceHolder(nonRepeatingSequenceSoFar, beginIndex, iterator - 1));
            beginIndex++;
            mapOfCharacter.put(character, iterator);
        }
        // At last insert the last sequence for safekeeping 😎
        String nonRepeatingSequenceSoFar = sourceString.substring(beginIndex);
        sequenceHolderSet.add(new SequenceHolder(nonRepeatingSequenceSoFar, beginIndex, iterator - 1));

        return sequenceHolderSet;
    }

    class SequenceHolder{
        public String sequence;
        public int beginIndex;
        public int endIndex;

        SequenceHolder(String sequence, int beginIndex, int endIndex) {
            this.sequence = sequence;
            this.beginIndex = beginIndex;
            this.endIndex = endIndex;
        }
    }

    public void testNonRepeatingStringSequence() {
        sampleTest1();
        sampleTest2();
        sampleTest3();
        sampleTest4();
    }

    private void sampleTest1() {
        String sourceSequence = null;

        System.out.println("Test 1: Length of longest non repeating sequence for String: " + sourceSequence);
        System.out.println(">> " + getMaxLenthNonRepeatingSequence(sourceSequence));
        System.out.println("----------------------------------------------");
    }

    private void sampleTest2() {
        String sourceSequence = "dvdf";

        System.out.println("Test 2: Length of longest non repeating sequence for String: " + sourceSequence);
        System.out.println(">> " + getMaxLenthNonRepeatingSequence(sourceSequence));
        System.out.println("----------------------------------------------");
    }

    private void sampleTest3() {
        String sourceSequence = "abcabcbb";

        System.out.println("Test 3: Length of longest non repeating sequence for String: " + sourceSequence);
        System.out.println(">> " + getMaxLenthNonRepeatingSequence(sourceSequence));
        System.out.println("----------------------------------------------");
    }

    private void sampleTest4() {
        String sourceSequence = "dabcebad";

        System.out.println("Test 4: Length of longest non repeating sequence for String: " + sourceSequence);
        System.out.println(">> " + getMaxLenthNonRepeatingSequence(sourceSequence));
        System.out.println("----------------------------------------------");
    }
}
