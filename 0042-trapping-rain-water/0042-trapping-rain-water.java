class Solution {
    public int trap(int[] height) {
        int n= height.length;
        int lmax = 0;
        int rmax = 0;
        int i=0;
        int j=n-1;
        int ans = 0;
        while(i<j){
            lmax = Math.max(lmax, height[i]);
            rmax = Math.max(rmax , height[j]);
            if(lmax<rmax){
            ans += (lmax - height[i]);
            i++;
            }
            else{
            ans += (rmax - height[j]) ;
            j--;
            }
         
        }
        return ans;
    }
}