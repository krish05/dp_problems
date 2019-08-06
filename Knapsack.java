package com.krip.alg.dp;

public class Knapsack {

	public static void solve_knapsack(int[] weights, int[] values, int max_weight) {
		if(weights.length == 0 || values.length == 0 || weights.length != values.length ) {
			System.err.println("Invalid input");
			return;
		}
		int n = weights.length;
		int[][] temp_table = new int[n+1][max_weight+1];
				
		for(int item=0; item<n+1; item++) {
			for(int weight=0; weight<max_weight+1; weight++) {
				if(item == 0 || weight == 0) {
					temp_table[item][weight] = 0;
					continue;
				}
				System.out.println("Weight:"+weight+", Item:"+item);
				if(weights[item-1] > weight) {
					temp_table[item][weight] = temp_table[item-1][weight];
				} else {
					temp_table[item][weight] = Math.max(values[item-1] + temp_table[item-1][weight- weights[item-1]], temp_table[item-1][weight]);
				}
				print(temp_table);
			}
		}
		
	}
	
	public static void print(int[][] table) {
		for(int i=0; i<table.length; i++) {
			for(int j=0; j<table[i].length; j++) {
				System.out.print(table[i][j]+ " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		
		int[] weights = {  1,3,4,5 };
		int[] values = {  1,4,5,7 };
		int max_weight = 7;
		
		/*
		 * 		0	1	2	3	4	5	6	7
		 * -----------------------------------
		 * 1(1) 0	1	1	1	1	1	1	1
		 * 3(4) 0	1	1	4	5	5	5	5
		 * 4(5) 0	1	1	4	5	6	6	9
		 * 5(7) 0	1	1	4	5	7	8	9
		 */
		
		solve_knapsack(weights, values, max_weight);
		
		
	}
}
