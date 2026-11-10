class Solution {
    public int lengthOfLongestSubstring(String s) {
        //  Brute force approach :
        // int n = s.length();
        // int maxlen = -1;
        // for(int i = 0 ;i< n ;i++){
        //     Set<Character> f = new HashSet<>();
        //     for(int j = i ;j< n ;j++){
        //         if(f.contains(s.charAt(j))){
        //             break;
        //         }
        //         f.add(s.charAt(j));
        //         maxlen = Math.max(maxlen , j-i+1);
        //     }
        // }
        // if (s.isEmpty()) return 0 ;
        // else return maxlen;


        //  optimal approach :
        // here we are using hashmap with 2 pointers :
        // int right =0 ;
        // int left = 0 ;
        // int n = s.length();
        // int maxlen = 0 ;
        // Set <Character> f = new HashSet<>();
        // while( right < n){
        //     if(!f.contains(s.charAt(right))){
        //         f.add(s.charAt(right));
        //         maxlen = Math.max(maxlen , f.size());
        //         right++;
        //     }
        //     else{
        //         f.remove(s.charAt(left));
        //         left++;
        //     }
        // }
        // return maxlen;
       int n = s.length();
       if(n==0){
        return 0;
       }
       int right = 0;
       int left = 0 ;
       int maxlength = -1;
       Set<Character> c = new HashSet<>();
       while(right < n ){
            if(!c.contains(s.charAt(right))){
                c.add(s.charAt(right));
                maxlength= Math.max(maxlength , c.size());
                right++;
            }
            else{
                c.remove(s.charAt(left));
                left++;
            } 
       }
       return maxlength == -1 ? -1 : maxlength;
    }
}