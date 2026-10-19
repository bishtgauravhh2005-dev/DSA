class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length ;
        int j = n-1;
        int i =0 ;
        int x =0;
        while(i<=j){
            if(nums[i] == val && nums[j] != val){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
                x++;
            }
            else if(nums[j] == val){
                j--;    
            }
            else{
                i++;
            }
        }
        return j+1;
    }
    
}