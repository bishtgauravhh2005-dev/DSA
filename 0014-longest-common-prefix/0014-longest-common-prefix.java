class Solution {
    class Node{
        Node[] children;
        boolean eow;
        int f;
        Node(){
            children = new Node[26];
            eow = false;
            f =0;
        }
    }
    Node root = new Node();
    public void insert(String s){
        Node curr = root;
        for(int i=0 ;i<s.length();i++){
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
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<strs.length;i++){
            insert(strs[i]);
        }
        Node curr = root;
        for(int i=0;i<strs[0].length() ;i++){
           int idx = strs[0].charAt(i) - 'a';
           curr = curr.children[idx];
           if(curr.f != strs.length){
             break;
           }
           sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }
}