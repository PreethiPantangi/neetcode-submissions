class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int low = 1;
        int high = 0;
        
        for(int pile: piles) {
            high = Math.max(pile, high);
        }

        int result = 0;
        while(low <= high) {

            int mid = low + (high - low) / 2;
            long hours = getEatingHours(piles, mid);
            if(hours > h) {
                low = mid + 1;
            } else {
                result = mid;
                high = mid - 1;
            }
        }
        return result;
    }

    private long getEatingHours(int[] piles, long k) {
        if(k == 0) return 0;
        long hours = 0;
        for(int pile: piles) {
            hours += (pile + k - 1) / k;
        }
        return hours;
    }
}
