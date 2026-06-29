class Solution {
    public boolean isValid(int []a , int m , int max_value){
        int store = 0;
        for(int i=0;i<a.length;i++){
           int remaining = a[i];
           store += (remaining + max_value-1)/max_value;
           
        }
        return store<=m;
    }
    public int minimizedMaximum(int m, int[] q) {
        int n = q.length-1;
        int low = 1; // products cannot be zero;
        int high =0;
        int ans =0;
        for(int i=0 ;i<=n;i++){
             high = Math.max(high , q[i]);
        }
        while(low<=high){
            int mid = low +(high-low)/2;
            if(isValid(q,m,mid)){
                 ans = mid ;
                high = mid-1;
            }
            else{
                low = mid +1;
            }
        }
        return ans;
    }

}