class Solution {
    public int firstUniqChar(String s) {

        HashMap<Character, Integer> freq = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Update frequency
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

            // Store index
            q.offer(i);

            // Remove indices whose characters are no longer unique
            while (!q.isEmpty() && freq.get(s.charAt(q.peek())) > 1) {
                q.poll();
            }
        }

        return q.isEmpty() ? -1 : q.peek();
    }
}