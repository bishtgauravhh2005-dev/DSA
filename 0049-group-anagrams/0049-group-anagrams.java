class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // Brute Force approach:
    //     List<List<String>> ans = new ArrayList<>();
    //     boolean visited[] = new boolean[strs.length];
    //     for(int i= 0 ;i<strs.length;i++){
    //         if(visited[i]) {
    //             continue;
    //         }
    //         List<String> group = new ArrayList<>();
    //         group.add(strs[i]);
    //         visited[i] = true;
    //         for(int j = i+1;j<strs.length;j++){
    //             if(!visited[j] && isAnagram(strs[i], strs[j])){
    //                 group.add(strs[j]);
    //                 visited[j] = true;
    //             }
    //         }
    //         ans.add(group);

    //     }
    //     return ans;
    // }
    // public boolean isAnagram(String str1 , String str2){
    //     char[] s = str1.toCharArray();
    //     char[] s2 = str2.toCharArray();

    //     Arrays.sort(s);
    //     Arrays.sort(s2);
    //     if(Arrays.equals(s,s2)){
    //         return true;
    //     }
    //     return false; 
    
    // optimal approach using hashmap and string:

    HashMap <String , List<String>> helper = new HashMap<>();
    for(String str : strs){
        char ch[] = str.toCharArray();
        Arrays.sort(ch);
        String k = new String(ch);
        if(!helper.containsKey(k)){
            helper.put(k ,new ArrayList<>());
        }
        helper.get(k).add(str);
     }
    return new ArrayList<>(helper.values());
   }
}