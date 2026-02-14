//https://www.geeksforgeeks.org/problems/merge-sort/1
class Solution {

    void mergeSort(int arr[], int l, int r) {
        // code here
        if(l < r){
            int m = l + (r - l)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }
    
    private void merge(int arr[], int l, int m, int r){
        int n1 = m - l + 1; //Size of 1st array
        int n2 = r - m; //Size of 2nd array
        int leftArr[] = new int[n1];
        int rightArr[] = new int[n2];
        
        //Put recursive left and right value into left and righ arr.
        for(int i = 0; i < n1; i++){
            leftArr[i] = arr[l+i];
        }
        
        for(int i = 0; i < n2; i++){
            rightArr[i] = arr[m+1 + i];
        }
        
        //Now comparing and swap
        int i = 0;
        int j = 0;
        int k = l;
        while(i < n1 && j < n2){
            if(leftArr[i] > rightArr[j]){
                arr[k] = rightArr[j]; 
                j++;
            }else{
                arr[k] = leftArr[i];
                i++;
            };
            k++;
        }
        
         while(i < n1) {
        arr[k] = leftArr[i];
        i++; k++;
    }

    while(j < n2) {
        arr[k] = rightArr[j];
        j++; k++;
    }
    }
}