class Solution {
    public boolean isfreqsame(int []f1 , int[] f2){
        for(int i=0 ;i<f1.length;i++){
            if(f1[i]!= f2[i]){
                return false;
            }
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int wind_size = s1.length();
        int n = s2.length();

        int freq[] = new int[26];
        for(int i = 0 ;i<wind_size ;i++){
            freq[s1.charAt(i) - 'a']++;
        }

        for(int i = 0 ;i<n ;i++){
            int idx= i;
            int w_index =0;
            int wind_freq[] = new int [26];
            while(w_index < wind_size && idx<n){
                wind_freq[s2.charAt(idx) - 'a']++;
                w_index++ ;
                idx++;
            }

            if(isfreqsame(freq, wind_freq)){
                return true;
            }
        }
        return false;
    }
}