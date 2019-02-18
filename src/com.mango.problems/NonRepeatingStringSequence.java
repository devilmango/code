package com.mango.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Get length of longest non-repeating sequence from a string
 * Source: Sadhu sir
 */
public class NonRepeatingStringSequence {

    private int getMaxLenthNonRepeatingSequence(String sourceString) {

        SequenceHolder sequenceHolder = generateLongestNonRepeatingSequence(sourceString);
        System.out.print(sequenceHolder.sequence + "  ");
        return sequenceHolder.length;
    }

    private SequenceHolder generateLongestNonRepeatingSequence(String sourceString) {
        SequenceHolder maxLengthSequenceHolder = new SequenceHolder("", 0, 0, 0);
        if ( sourceString == null || sourceString.length() == 0 ) {
            return maxLengthSequenceHolder;
        }

        Map<String, Integer> mapOfCharacter = new HashMap<>();
        int beginIndex = 0;
        int iterator = 0;
        for (; iterator < sourceString.length(); iterator++) {
            String character = "" + sourceString.charAt(iterator);
            //System.out.println("\nMap Content: "+ mapOfCharacter);
            //System.out.println("Current Character: "+ character + " IndexCollected: ["+ beginIndex + ", "+ iterator + "] Stored: ["+maxLengthSequenceHolder.toString());
            if(!mapOfCharacter.containsKey(character)) {
                mapOfCharacter.put(character, iterator);
                continue;
            }
            int locationOfRepeatedCharacterInMap = mapOfCharacter.get(character);
            int maxLenghtSoFar = iterator - beginIndex;
            if (maxLenghtSoFar > maxLengthSequenceHolder.length) {
                maxLengthSequenceHolder.length = maxLenghtSoFar;
                maxLengthSequenceHolder.beginIndex = beginIndex;
                maxLengthSequenceHolder.endIndex = iterator;
            }
            mapOfCharacter.put(character, iterator);
            beginIndex = beginIndex < locationOfRepeatedCharacterInMap ? locationOfRepeatedCharacterInMap + 1 : beginIndex;
        }
        // At last insert the last sequence for safekeeping 😎
        if(iterator - beginIndex > maxLengthSequenceHolder.length) {
            maxLengthSequenceHolder.length = iterator - beginIndex;
            maxLengthSequenceHolder.beginIndex = beginIndex;
            maxLengthSequenceHolder.endIndex = iterator;
        }
        maxLengthSequenceHolder.sequence = sourceString.substring(maxLengthSequenceHolder.beginIndex, maxLengthSequenceHolder.endIndex);
        return maxLengthSequenceHolder;
    }

    class SequenceHolder{
        public String sequence;
        public int length;
        public int beginIndex;
        public int endIndex;

        SequenceHolder(String sequence, int length, int beginIndex, int endIndex) {
            this.sequence = sequence;
            this.length = length;
            this.beginIndex = beginIndex;
            this.endIndex = endIndex;
        }
        @Override
        public String toString() {
            return sequence + " L: " + length + " S: "+ beginIndex + " E: " + endIndex;
        }
    }

    public void testNonRepeatingStringSequence() {
        sampleTest1();
        sampleTest2();
        sampleTest3();
        sampleTest4();
        sampleTest5();
        sampleTest6();
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
        String sourceSequence = "dabcebdfgh";

        System.out.println("Test 4: Length of longest non repeating sequence for String: " + sourceSequence);
        System.out.println(">> " + getMaxLenthNonRepeatingSequence(sourceSequence));
        System.out.println("----------------------------------------------");
    }

    private void sampleTest5() {
        String sourceSequence = "dabcebdafaa";

        System.out.println("Test 5: Length of longest non repeating sequence for String: " + sourceSequence);
        System.out.println(">> " + getMaxLenthNonRepeatingSequence(sourceSequence));
        System.out.println("----------------------------------------------");
    }

    private void sampleTest6() {
        String sourceSequence = "abcdaabcdef";

        System.out.println("Test 6: Length of longest non repeating sequence for String: " + sourceSequence);
        System.out.println(">> " + getMaxLenthNonRepeatingSequence(sourceSequence));
        System.out.println("----------------------------------------------");
    }
}
