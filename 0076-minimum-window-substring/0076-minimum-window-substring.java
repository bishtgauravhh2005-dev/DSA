class Solution {
    public String minWindow(String s, String t) {
           if (s.length() < t.length()) {
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : t.toCharArray()){
            map.put(ch , map.getOrDefault(ch,0)+1);
        }
        int n = s.length();
        int c = 0; 
        int s_index =-1;
        int l=0 ;
        int r=0;
        char [] a = s.toCharArray();
        int minlen = Integer.MAX_VALUE;
        while(r<s.length()){
            char ch = s.charAt(r);
            if(map.getOrDefault(ch, 0) > 0){
                c= c+1;
            } 
            map.put(ch ,map.getOrDefault(ch, 0) - 1);

            while(c==t.length()){
                if(r-l+1 < minlen){
                    minlen = r-l+1;
                    s_index = l;
                }
                char lch = s.charAt(l);
                map.put(lch,map.getOrDefault(lch, 0) + 1);
                if(map.get(lch) > 0){
                    c = c-1;
                }
                    
              
                l++;
                
            }
            r=r+1;
            
        }
        if(s_index == -1)
        return "";
        return s.substring(s_index , s_index + minlen); 
    }
}