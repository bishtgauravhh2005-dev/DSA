class Solution {
    public String longestPrefix(String s) {
        int p  = 0 ;
        int su=1;
        int lps[] = new int [s.length()];
        while(su<s.length()){
            if(s.charAt(p) == s.charAt(su)){
                lps[su] = p+1;
                p++;
                su++;
            }
            else{
                if(p==0){
                    lps[su] = 0;
                     su++;
                }
                else{
                    p = lps[p-1];
                }
            }
           
        }
        return s.substring(0, lps[s.length() - 1]);
    }
   
}