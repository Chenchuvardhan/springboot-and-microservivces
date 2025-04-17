package com.intrestingQuestions;

public class GeneratePassword {
	   public String generatePasswordForUser() {
		  
		   Double random = Math.random();
		   String string = random.toString();
		   String str="";
		   for(int i=string.length()-1;i>=string.length()-4;i--) {
			 str+=string.charAt(i);
		   }
		   return str;
	   }
	   public static void main(String[] args) {
		   String passwordForUser = new GeneratePassword().generatePasswordForUser();
		   System.out.println(passwordForUser);
	   }
	}