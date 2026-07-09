class Solution {
    public int[] replaceElements(int[] arr) {
        int end = arr.length-1;
        for(int i = 0; i < arr.length; i++) {
            arr[i] = getMaximum(i+1, end, arr);
        }
        return arr;
    }

    private int getMaximum(int start, int end, int[] arr) {
        int max = -1;
        for(int i = start; i <= end; i++) {
            max = Math.max(arr[i], max);
        }
        return max;
    }
}