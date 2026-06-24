class Solution {
    public boolean isAnagram(String s, String t) {
        // List<Character> l = new ArrayList<>();
        // int n = s.length();
        // int m = t.length();
        // if(n != m ){
        //     return false;
        // }
        // for(int i=0 ;i<n;i++){
        //         l.add(s.charAt(i));
            
        // }
        // for(int i =0 ; i<m ;i++){
        //     if(!l.contains(t.charAt(i))){
        //         return false;
        //     }
        //     l.remove(Character.valueOf(t.charAt(i)));
        // }
        // return true;
        int n = s.length();
        int z = t.length();
        if(n!=z){
            return false;
        }

        int [] freq = new int[26];
        for(int i =0 ;i<n ;i++ ){
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        for(int x : freq){
            if(x!=0){
                return false;
            }
        }
        return true;
    }
}