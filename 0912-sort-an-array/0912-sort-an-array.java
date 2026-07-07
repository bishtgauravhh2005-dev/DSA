class Solution {
    public void merge(int []a , int st , int mid , int end){
        int[] temp = new int[end-st+1];
        int i = st ;
        int j = mid+1;
        int k = 0;
        while(i<=mid && j<=end){
            if(a[i]<=a[j]){
                temp[k++]= a[i];  
                i++;           
            }
            else{
                temp[k++]= a[j];
                j++;
            }
        }
        while(i<=mid){
            temp[k++] = a[i];
            i++;
        }
        while(j<=end){
            temp[k++] = a[j];
            j++;
        }

        for(int x = 0 ;x<temp.length;x++){
            a[x+st] = temp[x];
        }

    }
    public void mergeSort(int [] a, int st, int end){
        if(st<end){
        int mid = st + (end-st)/2;

        mergeSort(a , st , mid );
        mergeSort(a , mid+1 , end);

        merge(a , st ,mid, end);
        }
    }
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0 , nums.length-1);
        return nums;
    }
}