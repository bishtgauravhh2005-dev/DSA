class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int i =0;
        int j=0;
        int index = 0;

        while(j<n){
            int c = 0;
            while( j<n && chars[i] == chars[j] ) {
                c++;
                j++;
            }
            chars[index] = chars[i];
            index++;
            if(c >1){
                String st = Integer.toString(c);
                for(char ch : st.toCharArray()){
                    chars[index] = ch;
                    index++;
                }
            }
            i=j;

        }
        return index;
    }
}