class Solution {
    public boolean checkDivisibility(int n) {
        if(n<10){
            return false;
         }
        int sum =0 ;
        int x = n;
        int p = 1;
        while(n>0){
            int s = n%10;
            sum += s;
            p *= s;
            n = n/10;
        }
        if(x % (sum + p)  == 0){
            return true;
        }
        return false;
    }
}