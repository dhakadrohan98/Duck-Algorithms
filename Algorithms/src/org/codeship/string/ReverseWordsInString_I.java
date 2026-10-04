package org.codeship.string;

public class ReverseWordsInString_I {
	
	public String reverseWords(String s) {
        s = s.trim();
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = str.length - 1; i >= 0; i--) {
            String temp = str[i];
            if(temp.length() > 0) {
                sb.append(temp);
                if(i != 0) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
