package com.intrestingQuestions;

public class Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 1, 2, 3 }, { 0, 7, 6 }, { 9, 2, 7 } };
		for (int[] i : arr) {
			for (int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		int a = 0, b = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 0) {
					a = i;
					b = j;
					System.out.println("a-" + a + " b-" + b);
				}
			}
		}
		arr[a - 1][b] = 0;
		arr[a + 1][b] = 0;
		arr[a][b + 1] = 0;
		arr[a][b + 2] = 0;
		for (int[] i : arr) {
			for (int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
}
