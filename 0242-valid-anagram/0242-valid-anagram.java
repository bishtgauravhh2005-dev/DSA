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
        // int n = s.length();
        // int z = t.length();
        // if(n!=z){
        //     return false;
        // }

        // int [] freq = new int[26];
        // for(int i =0 ;i<n ;i++ ){
        //     freq[s.charAt(i) - 'a']++;
        //     freq[t.charAt(i) - 'a']--;
        // }
        // for(int x : freq){
        //     if(x!=0){
        //         return false;
        //     }
        // }
        // return true;


        int n = s.length();
        int m = t.length();

        if(n!=m) return false;

        HashMap<Character , Integer> map1 = new HashMap<>();
        HashMap<Character , Integer> map2 = new HashMap<>();
        for(int i =0 ; i< n ; i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            map1.put(ch1 , map1.getOrDefault(ch1 , 0)+1);
            map2.put(ch2 , map2.getOrDefault(ch2 , 0)+1);
        }
        return map1.equals(map2);
    }
}