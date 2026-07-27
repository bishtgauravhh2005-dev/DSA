import java.util.*;
class Solution {
    public int largestRectangleArea(int[] heights) {
        // using stack by calculating width by finding of right smaller nearest value and left smaller nearest val
        // width = (right nearest - left nearest smaller -1)
        int n = heights.length;
        Stack<Integer> s = new Stack<>();
        int right[] = new int[n];
        int left[] = new int[n];
        for(int i= n-1; i>=0 ;i--){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }
            right[i] = s.isEmpty() ? n : s.peek(); 
            s.push(i);
        }
         s.clear();
        for(int i= 0; i<n ;i++){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }
            left[i] = s.isEmpty() ? -1 : s.peek(); 
            s.push(i);
        }
        int ans = 0 ;
        int area =0;
        for(int i= 0 ;i< n ; i++){
            area = heights[i] * (right[i] - left[i] -1);
            ans = Math.max(ans , area);
        }
    return ans;
    }
}