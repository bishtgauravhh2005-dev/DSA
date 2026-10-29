class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    //     int totalgas = 0;
    //     int totalcost = 0;
    //     for(int i = 0 ;i<gas.length ;i++){
    //         totalgas += gas[i];
    //     }
    //     for(int i=0;i<cost.length ;i++){
    //         totalcost += cost[i];
    //     }

    //     if(totalgas < totalcost){
    //         return -1;
    //     }

    //     int st =0 ;
    //     int curr = 0;
    //     for(int i=0 ;i<gas.length;i++){
    //         curr += gas[i] - cost[i];

    //         if(curr < 0 ){
    //             st = i+1;
    //             curr =0;
    //         }

    //     }
    // return st;
    // }
        int n = gas.length;
        int totalCost=0 ;
        int totalGas = 0 ;
        for(int i =0 ;i< n; i++){
            totalCost += cost[i];
            totalGas += gas[i];
        }
        if(totalGas < totalCost){
            return -1;
        }
        int curr = 0;
        int st =0 ;
        for(int i=0 ;i < n ;i++){
            curr += gas[i] - cost[i];

            if(curr < 0 ){
                st = i+1;
                curr = 0;
            }
        }
        return st ;
    }
}