package org.codeship.string;

public class ReverseEachWordsInStringAndReverseString {
	
	public static String reverseWords(String s) {
        s = s.trim();
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = str.length - 1; i >= 0; i--) {
            String temp = str[i];
            if(temp.length() > 0) {
            	for(int j = temp.length() - 1; j >= 0; j--) {
            		sb.append(temp.charAt(j));
            	}
            	if(i != 0) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		String s = "the sky is blue";
		String res = reverseWords(s);
		System.out.println(res);

	}

}
