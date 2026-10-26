class Solution {
//     public boolean solve(int[] nums , int i , Boolean[] dp){
//         if(i>=nums.length-1){
//             return true;
//         }

//         if(dp[i] != null){
//             return dp[i];
//         }

//         for(int x = 1 ;x <=nums[i] ; x++){
//             if(solve(nums , i+x, dp))
//             {
//                 return dp[i] = true;
//             }
//         }
//         return dp[i] = false;
//     }
//     public boolean canJump(int[] nums) {
//         int n = nums.length;
//         Boolean dp[] = new Boolean[n];
//         return solve(nums , 0 , dp);
//     }
// }
// In this approach we are trying to find every possible path.
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for(int i =0 ;i<nums.length ; i++){
            if(i>maxReach){
                return false;
            }
            maxReach = Math.max(maxReach , i+nums[i]);

            if(maxReach >= nums.length-1){
                return true;
            }
        }
        return false;
    }
}