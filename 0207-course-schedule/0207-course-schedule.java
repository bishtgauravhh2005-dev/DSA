class Solution {
    public boolean dfs(List<List<Integer>> graph , int[] vis , int [] pathvis , int i){
        if(pathvis[i] == 1){
            return true;
        }
        if(vis[i] == 1){
            return false;
        }
        pathvis[i] = 1;
        vis[i] = 1;
        for(int n : graph.get(i)){
            if(dfs(graph , vis, pathvis , n)){
                return true;
            }
        }

        pathvis[i] = 0;
        return false;

    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i =0 ;i<numCourses ;i++){
            graph.add(new ArrayList<>());
        }
        for(int arr[] : prerequisites){
            graph.get(arr[0]).add(arr[1]);
        }
        int [] visited = new int[numCourses];
        int [] pathvisited = new int [numCourses];

        for(int i=0 ;i<numCourses;i++){
            if(dfs(graph , visited , pathvisited ,i)){
                return false;
            }
        }
        return true;
    }
}