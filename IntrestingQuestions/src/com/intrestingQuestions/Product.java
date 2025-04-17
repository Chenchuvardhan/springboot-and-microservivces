package com.intrestingQuestions;

public class Product implements AutoCloseable{

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method 
		System.err.println("executed...");
	}
	
	public static void main(String[] args) {
		
		try(Product p = new Product()) {
			System.err.println("main started...");
			int x = 1/0;
			System.err.println("exception...");
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		
		System.err.println("main ended...");
	}

}

