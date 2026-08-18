class Solution {
    class info{
        int minval;
        int minvalIdx ;
        int listIdx;
        info(int minval , int minvalIdx , int listIdx){
            this.minval = minval;
            this.minvalIdx = minvalIdx;
            this.listIdx = listIdx;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        PriorityQueue<info> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.minval,b.minval));
        int maxelement = Integer.MIN_VALUE; 
        for(int i=0 ; i<k ;i ++){
            int value = nums.get(i).get(0);
            pq.offer(new info(value, 0, i));
            maxelement = Math.max(maxelement, value);
        }
                int bestStart = 0;
        int bestEnd = Integer.MAX_VALUE;

        // We need one element from every list
        while (pq.size() == nums.size()) {

            // Get the current minimum
            info current = pq.poll();

            int minelement = current.minval;

            // Check current range
            if (maxelement - minelement <
                bestEnd - bestStart) {

                bestStart = minelement;
                bestEnd = maxelement;
            }

            // Move to the next element in the same list
            int nextIndex = current.minvalIdx + 1;

            // If this list is exhausted, we cannot make
            // another valid range containing all lists
            if (nextIndex >= nums.get(current.listIdx).size()) {
                break;
            }
            int nextValue =
                nums.get(current.listIdx).get(nextIndex);

            // Add next element of this list to heap
            pq.offer(
                new info(
                    nextValue,
                    nextIndex,
                    current.listIdx
                )
            );

            // Update maximum
            maxelement = Math.max(maxelement, nextValue);
        }

        return new int[]{bestStart, bestEnd};

    }
}