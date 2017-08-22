package chapter1;

import java.util.HashSet;

//implement an algorithm to detect if a string has all unique characters
public class P1d1 {
	public static void main(String[] args) {
		System.out.println(hasAllUniqueCharacters("jhcweriucwhreiuwvyrowery"));//false
		System.out.println(hasAllUniqueCharacters("andkwet"));//true
		System.out.println(hasAllUniqueCharactersNoExtraDS("wejvriowejrinovwerunweu"));//false
		System.out.println(hasAllUniqueCharactersNoExtraDS("andkwet"));//true
		//testing out the solution from the book
		isUniqueChar("cqwecqwevqsasd");
		

	}
	//this function uses a HashSet - O(N) 
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
	
	//O(N^2) - can we do better? yep. O(NlogN)
	private static boolean hasAllUniqueCharactersNoExtraDS(String str) {
		if(str == null || str == "") {
			return true;
		}
		char[] strChared = str.toCharArray();
		//without additional data structure
		quickSort(strChared, 0, strChared.length-1);
		//O(N)
		for (int i = 1; i < strChared.length; i++) {
			char c = strChared[i];
			char b = strChared[i-1];
			if(b ==c ) {
				return false;
			}
		}
		return true;
	}
	private static void	 quickSort(char[] strChared,int low, int high) {
		int i = low; 
		int j= high;
		int pivot = strChared[low +(high-low)/2];
		while(i <= j) {
			while(strChared[i] < pivot) {
				i++;
			}
			while(strChared[j] > pivot) {
				j--;
			}
			if(i <=j) {
				char temp = strChared[i];
				strChared[i] = strChared[j];
				strChared[j] = temp;
				i++;
				j--;
			}
		}
		if(low<j) {
			quickSort(strChared,low,j);
		}
		if(i<high) {
			quickSort(strChared,i,high);
		}
		
	}
	private static boolean isUniqueChar(String str) {
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if((checker & (1 << val))>0) {
				return false;
			}
			checker |= (1 << val);
		}
		return true;
	}

}
