class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public void helper(int []a , List<Integer> s , int x ){

        if(x== a.length ){
            ans.add(new ArrayList(s));
            return;
        }
        ans.add(new ArrayList(s));

        for(int i= x ;i<a.length;i++){
            if(i > x && a[i] == a[i-1])
            continue;
            s.add(a[i]);
            helper(a , s ,i+1);
            s.remove(s.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> s = new ArrayList<>();
        // ans.add(new ArrayList<>(s));
        Arrays.sort(nums);
        helper(nums , s , 0);
        return ans;
    }
}