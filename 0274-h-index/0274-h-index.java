class Solution {
    public int hIndex(int[] citations) {
        int max = 0;
        int n = citations.length;
        for(int h=1 ; h<=n ;h++){
            int c =0;
            for(int i =0 ;i<n ; i++){
                if(h <= citations[i]){
                    c++;
                }
            }
            if(c>=h){
                max = h;
            }
        }
    return max;
    }
}