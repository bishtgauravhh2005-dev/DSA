class Solution {
    public void solve(int[] arr , int left , int right){
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length ;

        k = k%n;
        solve(nums , 0 , n-1);
        solve(nums , 0 , k-1);
        solve(nums , k , n-1);

    }
}