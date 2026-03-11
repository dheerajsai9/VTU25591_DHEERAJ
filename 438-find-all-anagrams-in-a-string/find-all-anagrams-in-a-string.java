import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;
        
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        
        // Count the frequency of characters in p
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        // Sliding window over string s
        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;

            // When we have a window of size p.length(), check if it's an anagram
            if (i >= p.length()) {
                sCount[s.charAt(i - p.length()) - 'a']--;
            }

            if (Arrays.equals(pCount, sCount)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}