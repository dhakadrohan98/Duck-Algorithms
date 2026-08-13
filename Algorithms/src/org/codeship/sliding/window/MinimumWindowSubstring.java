package org.codeship.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    //TC: O(m+n)//m - length of str, n - length of txt
    //SC: O(n)
    public static String minWindow(String str, String txt) {
        int len = str.length();
        int i = 0, j = 0;
        int start = -1, end = -1;
        int minWin = Integer.MAX_VALUE;
        Map<Character, Integer> hmap = new HashMap<>();
        for(char ch : txt.toCharArray()) {
            hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);
        }
        int count = hmap.size();

        while(j < len) {
            //do some calculations
            char ch = str.charAt(j);
            if(hmap.containsKey(ch)) {
                hmap.put(ch, hmap.get(ch) -1 );
                if(hmap.get(ch) == 0 && count > 0) {
                    count -= 1;
                }
            }
            if(count > 0) {
                j++;
            } else if(count == 0) {
                while(count == 0) {
                    //Condition is valid hence calculate ans
                    if(j-i+1 < minWin) {
                        minWin = j-i+1;
                        start = i;
                        end = j;
                    }
                    //remove calculation for i
                    char ch1 = str.charAt(i);
                    if(hmap.containsKey(ch1)) {
                        hmap.put(ch1, hmap.get(ch1) + 1);
                        if(hmap.get(ch1) == 1) {
                            count += 1;
                        }
                    }
                    i++;
                }
                j++;
            }
        }
        if(start == -1) {
            return "";
        }
        return str.substring(start, end+1);
    }

    public static void main(String[] args) {
        String str = "cabwefgewcwaefgcf";
        String txt = "cae";
        System.out.println(minWindow(str, txt));
    }
}
