package com.aurionpro.stringbuilderAssignment;

public class ReplaceSubstring {
	public static void main(String[] args) {
		String str = "This is a bad idea. I like bad idea";
		StringBuilder sb = new StringBuilder(str);

		String toReplace = "bad";
		String replacement = "good";

		int start = sb.indexOf(toReplace); // 10 because bad is at 10th position

		if (start != -1) {
			int end = start + toReplace.length();  // 10 + 3
			sb.replace(start, end, replacement);   // 10 till 13 -> 10, 11, 12 it will change
		}

		System.out.println(sb.toString());
	}
}
