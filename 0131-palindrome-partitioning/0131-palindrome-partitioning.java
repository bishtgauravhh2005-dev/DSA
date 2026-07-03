class Solution {
    List<List<String>> ans = new ArrayList<>();
    public void palindrome_fun(String s,List<String> part){
        if (s.length() == 0){
            ans.add(new ArrayList(part));
            return;
        }
        for(int i=0 ;i<s.length() ;i++){
            String sub_part = s.substring(0,i+1);
            if(ispalindrome(sub_part)){
                part.add(sub_part);
                palindrome_fun(s.substring(i+1), part);
                part.remove(part.size()-1);
            }

        }
    }
    public boolean ispalindrome(String str){
        int st = 0 ;
        int end = str.length()-1;
        while(st<end){
            if(str.charAt(st) != str.charAt(end)){
                return false;
            }
            st++;
            end--;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<String> part = new ArrayList<>();
        palindrome_fun(s, part);
        return ans;
    }
}