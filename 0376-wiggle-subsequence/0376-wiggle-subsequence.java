class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int prev = 0;
        int diff =0;
        int c=1;
        for(int i=1 ; i<n ;i++){
            diff = nums[i] - nums[i-1];
            if(prev>=0 && diff <0){
                c++;
                prev = diff;
            }
            else if(prev<=0 && diff>0){
                c++;
                prev = diff;
            }
        }
    return c;
    }
}