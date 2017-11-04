package org.coding.stringUtil;

public class App {

	public static boolean considerOnlyAscii = false;

	/**
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
			if (isAlphabeticChar(in.charAt(i))) {// Lets examine if char is alphabet
				start = i;
				while (i < len && isAlphabeticChar(in.charAt(i))) {
					i++;
				}
				sb.append(getModifiedString(in, start, i - 1));// either max len reached or non-word char found
				if (i < len) {
					sb.append(in.charAt(i));// store the non-word character
				}
			} else {
				sb.append(in.charAt(i));
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
