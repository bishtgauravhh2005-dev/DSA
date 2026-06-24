import java.util.*;

class Solution {
    public String reverseWords(String s) {

        // StringBuilder ans = new StringBuilder();
        // int i = s.length() - 1;

        // while(i >= 0) {

        //     while(i >= 0 && s.charAt(i) == ' ')
        //         i--;

        //     if(i < 0)
        //         break;

        //     StringBuilder word = new StringBuilder();

        //     while(i >= 0 && s.charAt(i) != ' ') {
        //         word.append(s.charAt(i));
        //         i--;
        //     }

        //     ans.append(word.reverse());

        //     while(i >= 0 && s.charAt(i) == ' ')
        //         i--;

        //     if(i >= 0)
        //         ans.append(' ');
        // }

        // return ans.toString();


        // using single loop:
        int n = s.length();
        String ans = "";
        String rev = new StringBuilder(s).reverse().toString();
        StringBuilder word = new StringBuilder();
        for(int i =0 ;i<n;){
            word.setLength(0);
            while(i<n && rev.charAt(i) == ' '){
                i++;
            }
            while( i<n &&rev.charAt(i) != ' '){
                word.append(rev.charAt(i));
                i++;
            }
            word.reverse();
            while(i<n && rev.charAt(i) == ' '){
                i++;
            }
            
            ans += ' ' + word.toString();
            
        }
        return ans.substring(1);
    }
}