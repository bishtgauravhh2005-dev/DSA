class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public  void solve(int index , int[] candidate , int target , List<Integer> curr) {
        if(target == 0){
            ans.add(new ArrayList(curr));
            return;
        }
        if(index == candidate.length){
            return ;
        }
        if(candidate[index] <= target){
            curr.add(candidate[index]);

            solve(index , candidate , target - candidate[index] , curr);

            curr.remove(curr.size() - 1);
        }
        solve(index+1 , candidate , target , curr);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> curr = new ArrayList<>();
        solve(0 , candidates, target , (curr));
        return ans;
    }
}