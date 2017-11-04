package org.coding.stringUtil;

public class App {

	public static boolean considerOnlyAscii = false;

	/**
	 * In the programming language of your choice, write a method that modifies a
	 * string using the following rules:
	 * 
	 * 1. Each word in the input string is replaced with the following: the first
	 * letter of the word, the count of distinct letters between the first and last
	 * letter, and the last letter of the word. For example, "Automotive" would be
	 * replaced by "A6e".
	 * 
	 * 2. A "word" is defined as a sequence of alphabetic characters, delimited by
	 * any non-alphabetic characters.
	 * 
	 * 3. Any non-alphabetic character in the input string should appear in the
	 * output string in its original relative location.
	 * 
	 * We are looking for: accuracy - 50% efficiency - 15% solution completeness -
	 * 10% clean code? readable? concise? straight forward? - 25% code documented -
	 * bonus 5% test case included? - bonus 5% Please include this problem
	 * description in the comment at the top of your solution. The problem is
	 * designed to take approximately 1-2 hours.
	 * 
	 * @param in
	 * @return
	 */
	static String convertString(String in) {
		if (in == null || in.isEmpty()) // we could add a check for a string with only whitespaces
			return "";
		StringBuilder sb = new StringBuilder();
		int start = 0, len = in.length();
		for (int i = 0; i < len; i++) {
			if (isAlphabeticChar(in.charAt(i))) {// Lets examine if its start of word
				start = i;
				while (i < len && isAlphabeticChar(in.charAt(i))) {
					i++;
				}
				sb.append(getModifiedString(in, start, i - 1));// either max len reached or non-word char found
			}
			if (i < len) {
				sb.append(in.charAt(i));// store the non-word character
			}
		}
		return sb.toString();
	}

	static String getModifiedString(String str, int start, int end) {
		StringBuilder stringBuilder = new StringBuilder();
		if (start > end || str == null || str.isEmpty() || start >= str.length() || end >= str.length()) {
			return stringBuilder.toString();
		}
		// "a"
		if (start == end) {
			return stringBuilder.append(str.charAt(start)).toString();
		}
		// "ab"
		if (end - start == 1) {
			String modified = str.charAt(start) + "0" + str.charAt(end);
			return stringBuilder.append(modified).toString();
		}
		String sub = str.substring(start + 1, end);
		long uniqCharCnt = sub.chars().distinct().count();
		String modified = "" + str.charAt(start) + uniqCharCnt + str.charAt(end);
		return stringBuilder.append(modified).toString();
	}
	/**
	 *  User can use {@code App.considerOnlyAscii} flag to consider ascii or more general alphabet
	 * @param c
	 * @return
	 */
	static boolean isAlphabeticChar(char c) {
		if (App.considerOnlyAscii) {
			if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) { // A - 65, Z - 90 a - 97 z- 122
				return true;
			}
			return false;
		} else {
			return Character.isAlphabetic(c);
		}
	}

}
