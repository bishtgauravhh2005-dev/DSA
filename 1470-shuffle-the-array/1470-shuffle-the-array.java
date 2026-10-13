class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2*n];
        int k= 0;
        int i=0 ;
        int j = n;
        while(i < n && j<2*n){
            ans[k++] = nums[i++];
            ans[k++] = nums[j++];
        }
        return ans;
    }
}