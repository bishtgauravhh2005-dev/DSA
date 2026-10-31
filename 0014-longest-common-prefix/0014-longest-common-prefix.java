class Solution {
    class Node{
        Node [] children;
        boolean eow;
        int f;
        public Node(){
            children = new Node[26];
            eow = false;
            f = 0;
        }
    }
    public Node root = new Node() ;
    public void insert(String s){
        Node curr = root;
        int n = s.length();
        for(int i = 0 ;i <n ;i++){
            int idx = s.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
            curr.f++;
        }
        curr.eow = true;

    }
    public String longestCommonPrefix(String[] strs) {
        // int n = strs.length;
        // StringBuilder ans = new StringBuilder();
        // for(int i =0 ;i<strs[0].length() ; i++){
        //     char curr = strs[0].charAt(i);
        //     boolean match = true;
        //     for(int j=1 ; j<n ; j++){
        //         if(i >= strs[j].length() || strs[j].charAt(i) != curr){
        //             match = false;
        //             break;
        //         }
        //     }

        //     if(match == false){
        //         return ans.toString();
        //     }else{
        //         ans.append(curr);
        //     }
        // }
        // return ans.toString();
        int n = strs.length;    
        for(int i =0 ;i< n ;i++){
            insert(strs[i]);
        }
        Node curr = root;
        StringBuilder ans = new StringBuilder();
        for(int i=0 ;i<strs[0].length();i++){
            int idx = strs[0].charAt(i) -'a';

            if(curr.children[idx] == null || curr.children[idx].f != n){
                break;
            }
            ans.append(strs[0].charAt(i));
            curr = curr.children[idx];
        }
    return ans.toString();
    }
}