class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length ;
        int candies[] = new int[n];
        Arrays.fill(candies , 1);

        for(int left =1 ; left < n ;left++){
            if(ratings[left] > ratings[left-1]){
                candies[left] = candies[left-1] + 1;
            }
        }

        for(int i = n-2 ; i>=0 ; i--){
            if(ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i] , candies[i+1] +1);
            }
        }
        int ans = 0 ;
        for(int x : candies){
            ans+=x;
        }

        return ans;
    }
}