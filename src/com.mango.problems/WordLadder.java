package com.mango.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * LeetCode: 127: Word Ladder
 */
public class WordLadder {

    private int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(Objects.isNull(beginWord) || beginWord.isEmpty() ||
                Objects.isNull(endWord) || endWord.isEmpty() ||
                Objects.isNull(wordList) || wordList.isEmpty() ||
                beginWord.equals(endWord)) {
            return 0;
        }

        Set<String> unvisitedWordSet = new HashSet<>(wordList);
        WordAndTransformationCounter startWord = new WordAndTransformationCounter(beginWord, 0);

        Queue<WordAndTransformationCounter> bfsQueue = new LinkedList<>();
        bfsQueue.add(startWord);

        while(!bfsQueue.isEmpty()) {
            WordAndTransformationCounter processingRecord = bfsQueue.poll();

            Set<String> visitedWordSet = new HashSet<>();
            unvisitedWordSet.forEach(
                    word -> {
                        if (isSingleTransformationPossible(processingRecord.word, word)) {
                            bfsQueue.add(new WordAndTransformationCounter(word, processingRecord.transformationCounter + 1));
                            visitedWordSet.add(word);
                        }
                    }
            );
            unvisitedWordSet.removeAll(visitedWordSet);
            if (processingRecord.word.equals(endWord)) {
                return processingRecord.transformationCounter + 1;
            }
        }

        return 0;
    }

    private Boolean isSingleTransformationPossible(CharSequence startWord, CharSequence endWord) {
        if (Objects.isNull(startWord) || Objects.isNull(endWord) ||
                startWord.length() != endWord.length()) {
            return Boolean.FALSE;
        }

        int transformationCounter = 0;
        for (int itr = 0; itr < startWord.length(); itr++) {
            if (startWord.charAt(itr) != endWord.charAt(itr)) {
                transformationCounter++;
            }
            if(transformationCounter > 1) {
                return Boolean.FALSE;
            }
        }
        if (transformationCounter == 0) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

    public class WordAndTransformationCounter {
        public String word;
        public int transformationCounter;

        WordAndTransformationCounter(String word, int transformationCounter) {
            this.word = word;
            this.transformationCounter = transformationCounter;
        }
    }

    public void testWordLadder() {
        sampleTest1();
        sampleTest2();
        sampleTest3();
    }

    private void sampleTest1() {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        System.out.println("----------------------------------------------");
        System.out.println("Sample Test: 1");
        System.out.println("----------------------------------------------");
        System.out.println("Begin Word: "+beginWord + ", End Word: "+endWord);
        System.out.println("Word List: "+ Arrays.toString(wordList.toArray()));
        System.out.println("");
        System.out.println("Output: "+ ladderLength(beginWord, endWord, wordList));
        System.out.println("----------------------------------------------");
        System.out.println("");
    }

    private void sampleTest2() {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log");

        System.out.println("----------------------------------------------");
        System.out.println("Sample Test: 2");
        System.out.println("----------------------------------------------");
        System.out.println("Begin Word: "+beginWord + ", End Word: "+endWord);
        System.out.println("Word List: "+ Arrays.toString(wordList.toArray()));
        System.out.println("");
        System.out.println("Output: "+ ladderLength(beginWord, endWord, wordList));
        System.out.println("----------------------------------------------");
        System.out.println("");
    }

    private void sampleTest3() {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "cot", "cog");

        System.out.println("----------------------------------------------");
        System.out.println("Sample Test: 3");
        System.out.println("----------------------------------------------");
        System.out.println("Begin Word: "+beginWord + ", End Word: "+endWord);
        System.out.println("Word List: "+ Arrays.toString(wordList.toArray()));
        System.out.println("");
        System.out.println("Output: "+ ladderLength(beginWord, endWord, wordList));
        System.out.println("----------------------------------------------");
        System.out.println("");
    }
}
