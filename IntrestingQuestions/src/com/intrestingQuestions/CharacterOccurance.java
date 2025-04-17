package com.intrestingQuestions;

import java.util.LinkedHashMap;
import java.util.Map;

public class CharacterOccurance {
	public static void main(String[] args) {
		String input = "java";
		char[] charArray = input.toCharArray();
		Map<Character, Integer> map = new LinkedHashMap<>();
		for (char c : charArray) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			}
			else {
				map.put(c, 1);
			}
		}
		System.out.println(map);
	}
}

