package org.codeship.twopointers;

public class ValidPalindrome {
	
	//TC: O(n * m) | m is the average length of string in phrase
    //SC: O(n * m)
    public static boolean isPalindrome(String s) {
        s = s.trim();
        s = s.toLowerCase();
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < split.length; i++) {
        	String str =  split[i];
        	if(str.length() == 0) {
        		continue;
        	}
        	for(int j = 0; j < str.length(); j++) {
        		char ch = str.charAt(j);
        		if((ch >= 48 && ch <= 57) || (ch >= 97 && ch <= 122)) {
        			sb.append(ch);
        		}
        	}
        }
        
        int l = 0, r = sb.length() - 1;
        while(l <= r) {
        	if(sb.charAt(l) == sb.charAt(r)) {
            	l++;
            	r--;
            } else {
            	return false;
            }
        }
        
        return true;
    }
	
	public static void main(String[] args) {
		String str = "A man, a plan, a canal: Panama";
		String str1 = " race   a car ";
		String str2 = " d  u"; 
		System.out.println(isPalindrome(str));
		System.out.println(isPalindrome(str2));

	}

}
