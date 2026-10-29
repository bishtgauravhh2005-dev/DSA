class Solution {
    public int[] productExceptSelf(int[] nums) {
        // brute force approach :
    //     int [] ans = new int[nums.length];
    //     for(int i=0 ;i< nums.length ; i++){
    //         int product = 1 ;
    //         for(int j= 0; j< nums.length ;j++){
    //             if(i!= j){
    //                 product = product * nums[j];
    //             }
    //         }
    //         ans[i] = product;
    //     }
    // return ans;

    // optimal aproach is prefix + sufix ()
    // int n = nums.length;
    // int ans[] = new int[n];
    // int prefix = 1;
    // ans[0] = prefix;
    // for(int i=1 ;i< n ; i++){
    //     prefix = prefix * nums[i-1];
    //     ans[i] = prefix;
    // }

    // int suffix =1 ;
    // for(int i = n-1 ; i>=0 ;i--){
    //     ans[i] = ans[i] * suffix;
    //     suffix =suffix * nums[i];
    // }
    // return ans;
    // }
        int n = nums.length;
        int ans[] = new int[n];

        int prefix = 1;
        ans[0] = prefix;
        for(int i =1 ; i<n ;i++){
            prefix = prefix * nums[i-1];
            ans[i] = prefix;
        }
        int suffix = 1;
        for(int i = n-1 ; i>=0 ; i--){
            ans[i] = suffix * ans[i];
            suffix = suffix * nums[i];
        }
    return ans;
    }
    
}