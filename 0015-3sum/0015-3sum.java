class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    // List<List<Integer>> list = new ArrayList<>();
    // Arrays.sort(nums);
    // int sum=0;
    
    //     for (int i=0 ;i<nums.length ;i++){
    //         if(i>0 && nums[i] == nums[i-1]){
    //             continue;
    //         }
    //         int j = i+1;
    //         int k = nums.length-1;
    //         while(j<k){
    //             sum = nums[i] + nums[j] + nums[k];
    //             if(sum < 0){
    //                 j++;
    //             }

    //             else if (sum > 0){
    //                 k--;
    //             }

    //             else{
    //                 list.add(Arrays.asList(nums[i], nums[j], nums[k]));
    //                 j++;
    //                 k--;


    //                 while(j<k && nums[j] == nums[j-1]){
    //                     j++;
    //                 }

    //             }
    //         }
    //     }
    // return list;
        List<List<Integer>> ans = new ArrayList<>();
        int sum = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0 ;i<n-2 ; i++){
            int start = i+1;
            int end = nums.length-1;
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            while(start<end){
                sum = nums[i] + nums[start] + nums[end];

                if(sum == 0){
                    ans.add(Arrays.asList(nums[i] , nums[start] , nums[end]));
                    start++;
                    end--;

                    while(start < end && nums[start] == nums[start-1]){
                        start++;
                    }
                }
                else if(sum > 0){
                    end--;
                }
                else{
                    start++;
                }
            }
        }
    return ans;
    }
}