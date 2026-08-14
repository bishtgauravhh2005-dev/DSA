class Solution {

    class Node{
        int val ;
        int row;
        int col;
        public Node(int val , int row , int col){
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
         // TC : O(n2logn ).  SC: O(n2)
    //     PriorityQueue<Integer> pq = new PriorityQueue<>();
    //     for(int i=0 ;i<matrix.length;i++){
    //         for(int j=0 ; j<matrix[0].length;j++){
    //             pq.offer(matrix[i][j]);
    //         }
    //     }
    //     for(int i=0 ;i<k-1;i++){
    //         pq.poll();
    //     }

    //     return pq.poll();
    // }


    // TC : (klogn)
    // SC : O(n)
    PriorityQueue<Node> pq = new PriorityQueue<>((a,b)-> (a.val - b.val));
    for(int row =0 ; row < matrix.length;row++){
        pq.offer(new Node(matrix[row][0] ,row , 0 ));
    }
    for(int i = 0 ; i<k-1 ;i++){
        Node curr = pq.poll();

        int row = curr.row;
        int col = curr.col;

        if(col < matrix[0].length-1){
            pq.offer(new Node(matrix[row][col+1] , row , col+1));

        }
    }
    return pq.poll().val;

}
}