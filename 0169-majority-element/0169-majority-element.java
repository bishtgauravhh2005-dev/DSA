class Solution {
    public int majorityElement(int[] nums) {
    int f = 0;
    int i=0;
    int ans = 0;
    while(i < nums.length){
        if (f==0){
            ans = nums[i];
            f++;
        }
        else if(ans == nums[i]){
            f++;
        }
        else{
            f--;
        }
        i++;
    }
    return ans;
}
}