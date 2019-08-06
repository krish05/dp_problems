package com.krip.alg.dp;

public class LCS {

	public static void lcs(String s1, String s2) {
		int[][] lcs_result = new int[s1.length()+1][s2.length()+1];
		for(int i=0; i<=s1.length(); i++) {
			for(int j=0; j<=s2.length(); j++) {
				if(i==0 || j==0) {
					lcs_result[i][j] = 0;
					continue;
				}
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					lcs_result[i][j] = lcs_result[i-1][j-1]+1;
				} else {
					lcs_result[i][j] = Math.max(lcs_result[i-1][j], lcs_result[i][j-1]);
				}
				System.out.println("i="+i+", j="+j);
				print(lcs_result);
			}
		}
		System.out.println(lcs_result[s1.length()][s2.length()]);
	}
	
	private static void print(int[][] lcs_result) {
		for(int i=0; i<lcs_result.length; i++) {
			for(int j=0; j< lcs_result[i].length; j++) {
				System.out.print(lcs_result[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	
	/***
	 * 
	 * 			a	b	c	d	e	f
	 * 			0	0	0	0	0	0
	 * 	a	0	1	1	1	1	1	1
	 * 	b	0	1	2	2	2	2	2
	 * 	d	0	1	2	2	3	3	3
	 * 	f	0	1	2	2	3	3	4
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "abcdef";
		String s2 = "abdf";
		LCS.lcs(s1, s2);
	}
}
