class Solve {
    public int findKthPositive(int[] arr, int k) {
        //holds the missed values 
        int missed = 0;
        
        for(int i = 0; i < arr.length; i++){
            if(i == 0){
                // in the case, where the value appears before the first element in the array
                missed += arr[0] - 1;
                if(missed >= k){
                    return k;
                }
            }
            
            else{
                //so now you find the amount of missing values between two array elements
                missed += arr[i] - arr[i - 1] - 1;
                // if you find out that the missed is already between two values
                if(missed >= k){
                    // get the value missed was before it got two elements
                    missed -= arr[i] - arr[i - 1] - 1;
                    // so with us knowing the numbers of missing values before this element and knowing the missed value is between ar[i-1] and ar[i-1] we search from them till we find the correct missing value
                    int result = arr[i - 1];
                    
                    while(missed++ < k){
                        result++;
                    }
                    
                    return result;
                }
            }
        }
        
        //if we have looped through the array and found no missing value what we will do next is get the value of arr[arr.length - 1] and then loop till we get to the value of k
        int result = arr[arr.length - 1];
        while(missed++ < k){
            result++;
        }
        
        return result;
    }
}
