class Solution {

    public int findNext(int [][] jobs , int left , int target){
        int right = jobs.length;

        while(left < right){
            int mid = left + (right - left)/2;

            if(jobs[mid][0] < target){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        int [][] jobs = new int[n][3];

        for(int i =0 ;i<n; i++){
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        Arrays.sort(jobs, (a,b)->Integer.compare(a[0] , b[0]));

        int[] dp = new int[n+1];

        for(int i = n-1 ;i>=0 ; i--){
            int next = findNext(jobs , i+1 , jobs[i][1]);

            int take = jobs[i][2] + dp[next];
            int skip = dp[i+1];

            dp[i] = Math.max(take , skip);
        }
        return dp[0];
    }


}