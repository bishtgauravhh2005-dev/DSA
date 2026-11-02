class Solution {
    public int findLongestChain(int[][] pairs) {
        // int n = pairs.length;
        // int c=0;
        // int prevfinish = Integer.MIN_VALUE;
        // Arrays.sort(pairs , (a,b) -> Integer.compare(a[1] , b[1]));
        // for(int i = 0 ;i< n ; i++){
        //     if(prevfinish < pairs[i][0]){
        //         c++;
        //         prevfinish = pairs[i][1];
        //     }
        // }
        // return c;
        int n = pairs.length;
        int prev = Integer.MIN_VALUE;
        Arrays.sort(pairs , (a,b) -> Integer.compare(a[1] , b[1]));
        int c=0;
        for(int i = 0 ;i<n ;i++){
            int st = pairs[i][0];
            int end = pairs[i][1];

            if(prev < st){
                c++;
                prev = end;
            }
        }
        return c;
    }
}