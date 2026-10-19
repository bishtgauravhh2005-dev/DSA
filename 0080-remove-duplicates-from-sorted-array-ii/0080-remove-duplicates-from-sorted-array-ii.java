class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;

        HashMap<Integer , Integer> map = new HashMap<>();
        int i =0 ;
        for(int j =0 ;j<n ;j++){
            if((map.getOrDefault(nums[j] , 0)) < 2){
                nums[i] = nums[j];
                i++;
                map.put(nums[j], (map.getOrDefault(nums[j] , 0)) + 1);
            }
        }
        return i;
    }
}