package com.dsalgo.problems;

import static org.junit.Assert.assertEquals;

/**
 * Created by stuppad on 1/31/19.
 */
public class BuySellStock {


    public static void main(String[] args) {
        BuySellStock buySellStock = new BuySellStock();
        assertEquals(7, buySellStock.maxProfit(new int[]{7,1,5,3,6,4}));
        assertEquals(4, buySellStock.maxProfit(new int[]{1,2,3,4,5}));
        assertEquals(0, buySellStock.maxProfit(new int[]{7,6,4,3,1}));
        assertEquals(0, buySellStock.maxProfit(new int[]{77,6,4,3,1}));
        assertEquals(78, buySellStock.maxProfit(new int[]{1,6,4,77,1}));
        assertEquals(495, buySellStock.maxProfit2(new int[]{468, 335, 1, 170, 225, 479, 359, 492, 496, 443, 8, 1}));
    }

    //This is to do multiple transactions, the idea is to buy and sell whenever i < i +1
    public int maxProfit(int[] prices) {

        int max = 0;
        for( int i =0 ;i< prices.length-1; i++){
            int diff = prices[i + 1] - prices[i];
            max += diff <=0 ? 0 : diff;

        }

       return max;

    }

    //This is to return the max profit along with the buy and sell position
    public int maxProfit2 (int[] input) {


        if(input.length <=1){
            return 0;
        }
        int maxProfit =  0 ;
        int min = Integer.MAX_VALUE;
        int maxPos = 0;
        int currMinPos = 0;
        int minPos=0;
        for(int i=0; i<input.length;i++){

            if(input[i]<min ){
                min = input[i];
                currMinPos = i;
            }else{
                if(input[i] - min > maxProfit){
                    maxProfit = input[i] - min;
                    maxPos = i;
                    minPos = currMinPos;
                }
            }



        }
        System.out.println(maxProfit);
        System.out.println(minPos);
        System.out.println(maxPos);
        return maxProfit;
    }


    /**
     * Here, the oneBuy keeps track of the lowest price, and sellOne keeps track of the biggest profit we could get.
     * Then the tricky part comes, how to handle the buyTwo? Suppose in real life, you have bought and sold a stock
     * and made $100 dollar profit. When you want to purchase a stock which costs you $300 dollars, how would you think this?
     * You must think, um, I have made $100 profit, so I think this $300 dollar stock is worth $200 FOR ME since I have hold $100 for free.
     * There we go, you got the idea how we calculate buyTwo!! We just minimize the cost again!! The sellTwo is just making as much profit as possible.
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        int buyOne = Integer.MAX_VALUE;
        int sellOne = 0;
        int buyTwo = Integer.MAX_VALUE;
        int sellTwo = 0;
        for(int p : prices) {
            buyOne = Math.min(buyOne, p);
            sellOne = Math.max(sellOne, p - buyOne);
            buyTwo = Math.min(buyTwo, p - sellOne);
            sellTwo = Math.max(sellTwo, p - buyTwo);
        }
        return sellTwo;
    }
}
