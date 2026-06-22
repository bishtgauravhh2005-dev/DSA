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
        int[] ans = new int[n - k + 1];

        Deque<Integer> dq = new ArrayDeque<>();

        // Process first window
        for (int i = 0; i < k; i++) {

            while (!dq.isEmpty() &&
                   nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);
        }

        ans[0] = nums[dq.peekFirst()];

        int idx = 1;

        // Process remaining windows
        for (int i = k; i < n; i++) {

            // Remove indices outside current window
            while (!dq.isEmpty() &&
                   dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Remove smaller elements
            while (!dq.isEmpty() &&
                   nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            ans[idx++] = nums[dq.peekFirst()];
        }

        return ans;
    }
}