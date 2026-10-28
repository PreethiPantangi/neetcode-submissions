class Solution {

    public String encode(List<String> strs) {
        String result = "";
        for(int i = 0; i < strs.size(); i++) {
            result += strs.get(i).length() + "#" + strs.get(i);
        }
        return result;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int startingIndex = 0;
        while(startingIndex < str.length()) {

            int index = startingIndex;

            while(str.charAt(index) != '#') {
                index++;
            }

            int length = Integer.parseInt(str.substring(startingIndex, index));

            int stringStart = index + 1;
            int stringEnd = stringStart + length;

            result.add(str.substring(stringStart, stringEnd));

            startingIndex = stringEnd;
        }
        return result;
    }
}
