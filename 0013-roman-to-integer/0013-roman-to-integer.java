class Solution {
    public int romanToInt(String s) {
       HashMap <String, Integer> map = new HashMap<>();
       map.put("I" , 1);
       map.put("V" , 5);
       map.put("X" , 10);
       map.put("L" , 50);
       map.put("C" , 100);
       map.put("D" , 500);
       map.put("M" , 1000);

       int i = 0 ;
       int ans =0;
       int n = s.length();
       while(i<n){
            int current = map.get(String.valueOf(s.charAt(i)));
            if(i+1 < n){
                int next = map.get(String.valueOf(s.charAt(i+1)));
                if(current < next){
                    ans -= current; 
                }
                else{
                    ans+= current;
                }
            }
            else{
                ans+=current;
            }
            i++; 
        }
       return ans;
    }
}