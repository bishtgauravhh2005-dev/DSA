class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int x : nums){
            set.add(x);
        }
        int ans = 0;
        for(Integer x : set){
            if(!set.contains(x-1)){
                int current = x;
                int c = 1;
                while (set.contains(current + 1)) {
                    current++;
                    c++;
                }

                ans = Math.max(ans, c);
            }
        }
    return ans;
    }
}