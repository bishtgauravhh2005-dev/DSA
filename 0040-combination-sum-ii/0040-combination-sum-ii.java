class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public void solve(int index , int[] candidates , int target , List<Integer> curr){
        if(target == 0 ){
            ans.add(new ArrayList(curr));
            return;
        }
        // if(candidates.length == index){
        //     return ;
        // }
        for(int i = index ; i< candidates.length ; i++){
            if(i > index && candidates[i] == candidates[i-1]){
                continue;
            }
            if(candidates[i] > target){
                break;
            }
            curr.add(candidates[i]);
            solve(i +1 , candidates , target-candidates[i] , curr);
            curr.remove(curr.size() - 1);


        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        solve( 0 , candidates, target , curr);
        return ans;
    }
}