import java.util.*;

public class CyclicSubstringMaxSum {

    public static int maxCyclicSubstringSum(String S) {
        int n = S.length();
        String S2 = S + S;  

        Set<Character> set = new HashSet<>();
        int left = 0;
        int currentSum = 0;
        int maxSum = 0;

        for (int right = 0; right < S2.length(); right++) {
            char ch = S2.charAt(right);
            int val = ch - 'a' + 1;

           
            while (set.contains(ch)) {
                char leftChar = S2.charAt(left);
                set.remove(leftChar);
                currentSum -= (leftChar - 'a' + 1);
                left++;
            }

            
            set.add(ch);
            currentSum += val;

          
            if (right - left + 1 > n) {
                char leftChar = S2.charAt(left);
                set.remove(leftChar);
                currentSum -= (leftChar - 'a' + 1);
                left++;
            }

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        String S = "abca";
        System.out.println(maxCyclicSubstringSum(S));  // Output: 6
    }
}
