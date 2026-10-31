class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        StringBuilder ans = new StringBuilder();
        for(int i =0 ;i<strs[0].length() ; i++){
            char curr = strs[0].charAt(i);
            boolean match = true;
            for(int j=1 ; j<n ; j++){
                if(i >= strs[j].length() || strs[j].charAt(i) != curr){
                    match = false;
                    break;
                }
            }

            if(match == false){
                return ans.toString();
            }else{
                ans.append(curr);
            }
        }
        return ans.toString();
    }
}