//https://leetcode.com/problems/minimum-operations-to-transform-array-into-alternating-prime/

class Solution {
    public int minOperations(int[] nums) {
        
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(i % 2 == 0){ //Even
            int c = 0;
                while(!isPrime(nums[i])){
                    nums[i]++;
                    c++;
                }
                count+=c;
            }else{ //Odd
            int c = 0;
                while(isPrime(nums[i])){
                    nums[i]++;
                    c++;
                }
                count+=c;
            }
        }

        return count;




    }
    boolean isPrime(int num){
        if(num <= 1) return false;
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num%i ==  0) return false;
        }
        return true;
    }
}