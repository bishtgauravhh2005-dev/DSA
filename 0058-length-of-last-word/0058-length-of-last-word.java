class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int i = n-1;
        while(s.charAt(i) == ' ' && i>=0){
            i--;
        }
        int c=0 ;
        while(i>=0 && s.charAt(i) != ' '){
            c++;
            i--;
        }
    return c;
    }
}