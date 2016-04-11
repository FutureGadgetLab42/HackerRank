package CodeFights;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Tom on 4/9/16.
 */
public class StockOptimizer {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/CodeFights/input0"));
        int numStocks = Integer.parseInt(sc.nextLine());
        Stock[] stocks = new Stock[numStocks];
        String[] line;
        for(int i = 0; i < numStocks; i++) {
            line = sc.nextLine().split(" ");
            stocks[i] = new Stock(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        }
        int riskBudget = Integer.parseInt(sc.nextLine());
        System.out.println("" + optimalStockBasket(stocks, riskBudget));
        sc.close();
    }

    private static int optimalStockBasketRecursive(Stock[] stocks, int riskBudget) {
        return optimalStockBasketRecursive(stocks, riskBudget, stocks.length - 1, 0);
    }

    private static int optimalStockBasketRecursive(Stock[] stocks, int riskBudget, int currentIndex, int currentValue) {
        if(currentIndex < 0) return currentValue;
        Stock current = stocks[currentIndex];
        if(current.risk <= riskBudget) {
            return Math.max(optimalStockBasketRecursive(stocks, riskBudget, currentIndex - 1, currentValue),
             optimalStockBasketRecursive(stocks, riskBudget - current.risk, currentIndex - 1, currentValue + current.expectedReturn));
        } else {
            return currentValue;
        }
    }

    private static int optimalStockBasket(Stock[] stocks, int riskBudget) {
        int result = 0;
        int[][] matrix = new int[stocks.length + 1][stocks.length + 1];
        for(int i = 0; i < matrix.length - 1; i++) {
            for(int j = i; j < matrix[i].length - 1; j++) {
//                if(stocks[i].)
            }
        }
        return result;
    }

    private static class Stock{
        int expectedReturn;
        int risk;
        private Stock(int expectedReturn, int risk){
            this.expectedReturn = expectedReturn;
            this.risk = risk;
        }
    }
}
