package chapter1;

import java.util.HashSet;

//implement an algorithm to detect if a string has all unique characters
public class P1d1 {
	public static void main(String[] args) {
		System.out.println(hasAllUniqueCharacters("jcwoerijcw98erjc9w83jv"));//false
		System.out.println(hasAllUniqueCharacters("andkwet"));//true
		
		

	}
	//this function uses a HashSet
	private static boolean hasAllUniqueCharacters(String str) {
		//edge case
		if(str == null || str == "") {
			return true;
		}
		char[] strChared = str.toCharArray();
		HashSet<Character> hs = new HashSet<>();
		//Iteration
		for (int i = 0; i < strChared.length; i++) {
			char c = strChared[i];
			if(hs.contains(c)) {
				return false;
			}
			hs.add(c);
			
		}
		return true;
	}
}
