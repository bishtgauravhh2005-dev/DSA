class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // brute force approach:
        // int[] a = new int[nums.length - k + 1];

        // for(int i = 0; i <= nums.length - k; i++) {

        //     int max = nums[i];

        //     int j = i;

        //     while(j < i + k) {
        //         max = Math.max(max, nums[j]);
        //         j++;
        //     }

        //     a[i] = max;
        // }

        // return a;

        //  optimal approach :
        // using dequeue: double ended queue:
        int n = nums.length;
        int [] ans = new int[n-k+1];
        Deque <Integer> dq = new ArrayDeque<>();
        int idx =0 ;
        for(int i =0 ;i< n ;i++){
            // Removes all the elements which are out of the window:
            while(!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                dq.pollLast();
            }

            dq.offerLast(i);

            if(i>=k-1){
                ans[idx++] = nums[dq.peekFirst()];
            }
       
        }
        return ans ;
    }
    
}