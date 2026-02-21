//https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1

class Solution {
    public int findPages(int[] arr, int k) {
        // code here
        if(k > arr.length) return -1;
        //Maximum page possible
        //Minimum page possible lowest of arr
        int maxPossible = 0, minPossible = 0;
        for(int num : arr){ 
            maxPossible += num;
            minPossible = Math.max(minPossible, num);
        }
        
        //Apply binary search
        int answer = Integer.MAX_VALUE;
        while(maxPossible >= minPossible){
            int canPossibleMaximumPage = minPossible + (maxPossible - minPossible)/2;
            if(studentsRequired(canPossibleMaximumPage, arr) <= k){
                answer = Math.min(canPossibleMaximumPage, answer);
                maxPossible = canPossibleMaximumPage - 1;
            }else{
                minPossible = canPossibleMaximumPage + 1;
            }
        }
        if(answer == Integer.MAX_VALUE) return -1;
        
        return answer;
    }
    
    private int studentsRequired(int pages, int[] arr){
        if(pages < arr[0]) return 0;
        int count = 1;
        int sum = 0;
        for(int page : arr){
            sum += page;
            if(sum > pages){
                sum = page;
                count++;
            }
        }
        return count;
    }
}