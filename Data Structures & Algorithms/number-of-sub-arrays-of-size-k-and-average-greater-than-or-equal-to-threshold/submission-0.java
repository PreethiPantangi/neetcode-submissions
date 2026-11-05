class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        
        int total = 0;
        int left = 0;        
        int sum = 0;
        for(int right = 0; right < arr.length; right++) {

            if(right - left + 1 > k) {
                sum -= arr[left];
                left += 1;
            }

            sum += arr[right];

            if(right - left + 1 == k && sum/k >= threshold) {
                total += 1;
            }
        }
        return total;
    }
}