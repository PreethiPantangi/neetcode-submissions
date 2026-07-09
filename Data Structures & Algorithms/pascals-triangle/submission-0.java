class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(numRows == 0) return result;
        result.add(Arrays.asList(1));

        for(int i = 1; i < numRows; i++) {
            List<Integer> prevRow = result.get(i-1);
            List<Integer> row = new ArrayList<>();

            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i) row.add(1);
                else {
                    row.add(prevRow.get(j-1) + prevRow.get(j));
                }
            }
            result.add(row);
        }
        return result;
    }
}