package org.coding.stringUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class App {

	static String convertString(String in) {
		String result = "";
		if (in == null || in.isEmpty())
			return result;

		int start = 0, end = 0, len = in.length(), i = 0;
		while (i < len) {
			// stop if char is alphabet
			start = i;
			if (isAsciiAlphabet(in.charAt(i))) {
				while (i < len && isAsciiAlphabet(in.charAt(i))) {
					i++;
				}
				// either max len reached or non-word char found
				end = i - 1;
			}

			i++; // iterate over chars
		}
		return result;
	}

	static boolean isAsciiAlphabet(char c) {
		// A - 65, Z - 90
		// a - 97 z- 122
		if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
			return true;
		}
		return false;
	}

	static long findDistinctCharacters(String str, int start, int end) {
		int last = -1;
		if (str == null || str.isEmpty() || start > end || end > str.length()) {
			return last;
		}
		if (end == str.length()) {
			last = end;
		} else {
			last = end + 1;
		}
		String sub = str.substring(start, last);
		return sub.chars().distinct().count();
	}

	public static void main(String[] args) {
		System.out.println(findDistinctCharacters("bbbb13add", 0, 9));
	}
}
