package com.mango.problems;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given a total cost and set of denomination. Return a combination of denomination that sum up upto total cost.
 * Source: Sadhu sir
 */
public class CoinChange {

    private CoinStore getMinimumCoins(int coins[], int totalMonetaryAmount)
    {
        CoinStore table[] = new CoinStore[totalMonetaryAmount + 1];
        table[0] = new CoinStore(0,0);

        for (int tableIterator = 1; tableIterator <= totalMonetaryAmount; tableIterator++)
            table[tableIterator] = new CoinStore(tableIterator, Integer.MAX_VALUE);

        for (int tableIterator = 1; tableIterator <= totalMonetaryAmount; tableIterator++)
        {
            //System.out.println(Arrays.toString(table));
            // Go through all coins smaller than tableIterator
            for (int coinIterator = 0; coinIterator < coins.length; coinIterator++) {
                int coinValue = coins[coinIterator];
                if (coinValue <= tableIterator) {
                    CoinStore recordToProcess = table[tableIterator - coinValue];
                    if (recordToProcess.totalCoinsNeeded != Integer.MAX_VALUE
                            && recordToProcess.totalCoinsNeeded + 1 < table[tableIterator].totalCoinsNeeded) {

                        table[tableIterator] = new CoinStore(tableIterator, recordToProcess.totalCoinsNeeded + 1);
                        table[tableIterator].coinCount.putAll(recordToProcess.coinCount);
                        int currentCount = 1;
                        if (table[tableIterator].coinCount.containsKey(coinValue)) {
                            currentCount = table[tableIterator].coinCount.get(coinValue) + 1;
                        }
                        table[tableIterator].coinCount.put(coinValue, currentCount);
                    }

                }
            }
        }
        return table[totalMonetaryAmount];
    }

    class CoinStore {
        public int index;
        public int totalCoinsNeeded;
        public HashMap<Integer, Integer> coinCount;
        public CoinStore(int index, int totalCoinsNeeded) {
            this.index = index;
            this.totalCoinsNeeded = totalCoinsNeeded;
            this.coinCount = new HashMap<>();
        }
        @Override
        public String toString() {
            return "Total Coins Needed: "+totalCoinsNeeded+" Coins: " + coinCount.toString();
        }
    }

    public void generateCoinDistribution() {
        sampleTest1();
        sampleTest2();
        sampleTest3();
    }

    private void sampleTest1() {
        int coins[] = {4, 3, 2, 1};
        int totalCost = 4;
        System.out.println ( "Minimum coins required for totalCost: ["+totalCost+"]\n"
                + getMinimumCoins(coins, totalCost));
    }

    private void sampleTest2() {
        int coins[] = {9, 6, 5, 1, 11};
        int totalCost = 11;
        System.out.println ( "Minimum coins required for totalCost: ["+totalCost+"]\n"
                + getMinimumCoins(coins, totalCost));
    }

    private void sampleTest3() {
        int coins[] = {9, 6, 5, 1, 11};
        int totalCost = 13;
        System.out.println ( "Minimum coins required for totalCost: ["+totalCost+"]\n"
                + getMinimumCoins(coins, totalCost));
    }
}
