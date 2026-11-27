class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }


    private void mergeSort(int[] nums, int start, int end) {

        if(start >= end) return;
        int mid = start + ( end - start ) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid+1, end);
        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end) {

        ArrayList<Integer> temp = new ArrayList<>();
        int i = start;
        int j = mid + 1;

        while(i <= mid && j <= end) {

            if(nums[i] <= nums[j]) {
                temp.add(nums[i]);
                i += 1;
            } else {
                temp.add(nums[j]);
                j += 1;
            }

        }

        while(i <= mid) {
            temp.add(nums[i]);
            i += 1;
        }

        while(j <= end) {
            temp.add(nums[j]);
            j += 1;
        }

        for( i = start; i <= end; i++) {
            nums[i] = temp.get(i - start);
        }

    }
}