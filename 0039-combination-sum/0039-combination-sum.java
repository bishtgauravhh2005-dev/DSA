class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public void solve(int index, int[] candidates, int target, List<Integer> curr) {

        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if (index == candidates.length) {
            return;
        }

        if (candidates[index] <= target) {
            curr.add(candidates[index]);

            solve(index, candidates, target - candidates[index], curr);

       
            curr.remove(curr.size() - 1);
        }

        solve(index + 1, candidates, target, curr);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        solve(0, candidates, target, new ArrayList<>());

        return ans;
    }
}