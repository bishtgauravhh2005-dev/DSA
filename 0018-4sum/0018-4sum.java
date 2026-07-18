class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        long s = Long.MIN_VALUE;
        int n = nums.length;
        for (int i = 0 ;i< n-3 ;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            for(int j = i+1; j<n-2; j++){
                if(j>i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int p= j+1;
                int k = n-1;
                while(p<k){
                    s = (long)nums[i] + nums[j] + nums[p] + nums[k];

                    if(s > target){
                        k--;
                    }
                    else if(s < target){
                        p++;
                    }
                    else{
                      result.add(Arrays.asList(nums[i] , nums[j] , nums[p] , nums[k])); 
                    
                    p++;
                    k--;
                    while(p<k && nums[p]==nums[p-1]) p++;
                    while(p<k && nums[k] == nums[k+1]) k--;
                    }
                }
                
            }
            
        }
    return result;
    }
}