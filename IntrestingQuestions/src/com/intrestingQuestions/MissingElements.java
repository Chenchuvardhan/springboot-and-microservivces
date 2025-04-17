package com.intrestingQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingElements {

public static void main(String[] args) {
	int[] arr= {1,3,8,7,4,9};
	Arrays.sort(arr);
	List<Integer> asList=new ArrayList<>();
	for(Integer i:arr) {
		asList.add(i);
	}
    for(int i=1;i<=10;i++) {
    	if(asList.contains((Object)i))
    	{
    	}
    	else {
    		System.out.println(i);
    	}
    }
}
}
