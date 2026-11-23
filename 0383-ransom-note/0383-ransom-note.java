class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character , Integer> map = new HashMap<>();
        int n = magazine.length();
        for(int i =0 ; i< n ; i++){
            char ch = magazine.charAt(i);
            map.put(ch , map.getOrDefault(ch , 0)+1);
        }

        int m = ransomNote.length();
        for(int i = 0 ;i < m ; i++){
            char ch =ransomNote.charAt(i);
            if(map.getOrDefault(ch , 0) <= 0) return false;
            map.put(ch , map.getOrDefault(ch , 0)-1);
        }

    return true;
    }
}