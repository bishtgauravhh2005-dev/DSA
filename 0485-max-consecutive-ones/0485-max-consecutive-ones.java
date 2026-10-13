class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int f =0;
        int ans = Integer.MIN_VALUE;
        int i=0 ;
        while(i<nums.length){
            if(nums[i] == 1){
                f++;
            }
            else{
                f=0;
            }
            ans = Math.max(f, ans);
            i++;
        }
        return ans;
    }
}