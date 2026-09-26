class Solution {
    public void solve(List<String> ans ,StringBuilder sb , int n, int open , int close  ){
        if(sb.length() == 2*n){
            ans.add(sb.toString());
            return ;
        }

        if(open < n){
            sb.append('(');
            solve(ans , sb , n , open+1 , close);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(open > close){
            sb.append(')');
            solve(ans , sb , n , open , close+1);
            sb.deleteCharAt(sb.length() - 1);
        }

        
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        solve(ans,sb , n , 0 , 0);
        return ans;
    }
}