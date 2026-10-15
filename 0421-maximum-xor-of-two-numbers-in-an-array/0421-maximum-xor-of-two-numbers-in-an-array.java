class Solution {
    static class TrieNode{
        TrieNode left ;
        TrieNode right ;
    }

    TrieNode root = new TrieNode();
    public void insert(int num , TrieNode root){
        TrieNode temp = root;
        for(int i = 31 ; i>= 0 ;i--){
            int ith_bit = (num >>> i) &1 ;
            if(ith_bit == 0 ){//left side
                if(temp.left == null){
                    temp.left = new TrieNode();
                }
                temp = temp.left;
            }
            else{
                if(temp.right == null){
                    temp.right = new TrieNode();
                }
                temp = temp.right;
            }
        }
    }

    public int findMaxXor ( int num ,TrieNode root){
        TrieNode temp = root;
        int max = 0;
        for(int i = 31 ; i>= 0 ;i--){
            int ith_bit = (num >>> i ) & 1;

            if(ith_bit == 1){
                if(temp.left != null){
                    max |= (1<<i) ; // Set the i-th bit to 1 because XOR of opposite bits is 1.
                    temp = temp.left;
                }
                else{
                    // max+=pow(2 , i) * 0 which is equals to zero , that why we not include it.
                    temp = temp.right;
                }
            }
            else{
                if(temp.right != null){
                    max |= (1<<i) ; // Set the i-th bit to 1 because XOR of opposite bits is 1.
                    temp= temp.right;
                }
                else{
                    temp = temp.left;
                }
            }
        
        }

    return max;

    }
    public int findMaximumXOR(int[] nums) {
        int n = nums.length;
        for(int i = 0 ;i<n ;i++){
            insert(nums[i] , root);
        }
        int maxResult = 0;
        for(int i = 0 ;i<n ;i++){
            int ans = findMaxXor(nums[i] , root);
            maxResult = Math.max(maxResult , ans);
        }
        return maxResult;
    }
}