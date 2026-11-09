class Solution {
    // BRUTE FORCE APPROACH :
    // public int minSubArrayLen(int target, int[] nums) {
    //     int ans = Integer.MAX_VALUE;
    //     int n = nums.length;
    //     for(int i =0 ; i<n ;i++){
    //         int x =0 ;
    //         for(int j=i;j<n;j++){
    //             x+=nums[j];
    //             if(x >= target){
    //                ans =  Math.min(ans , j-i+1);
    //                break;
    //             }
    //         }
    //     } 
    // return ans == Integer.MAX_VALUE ? 0 : ans;
    // }

    // OPTIMAL APPROACH SLIDING WINDOW :
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int left =0 ;
        for(int right = 0 ;right < n ; right++){
            sum+=nums[right];

            while(sum>=target){
                ans = Math.min(ans , right-left+1);

                sum-=nums[left];
                left++;
            }
        }  
    return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}