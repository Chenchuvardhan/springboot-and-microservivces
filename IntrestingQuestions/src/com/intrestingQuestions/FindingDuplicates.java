package com.intrestingQuestions;

import java.util.LinkedHashSet;
import java.util.Set;

public class FindingDuplicates {
	public static void main(String[] args) {
		String str="malayalam";
		Set<Character> set=new  LinkedHashSet<>();
		str.chars().filter(i->!set.add((char)(i))).distinct().forEach(k->System.out.println((char)k));
		System.out.println(set);
		str.chars().distinct().forEach(i->System.out.print((char)i+" "));
		
	}
}
