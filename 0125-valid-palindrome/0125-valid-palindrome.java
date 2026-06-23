class Solution {
    public boolean isPalindrome(String s) {
    StringBuilder sb = new StringBuilder();

    for(char ch : s.toCharArray()) {

        if(Character.isLetterOrDigit(ch)) {
            sb.append(Character.toLowerCase(ch));
        }
    }

    String str = sb.toString();
    int n = str.length();
    int i = 0;
    int j = n-1;
    while(i<j){
        if(str.charAt(i)!=str.charAt(j)){
            return false;
        }
        i++;
        j--;
    }
    return true;
    }
}