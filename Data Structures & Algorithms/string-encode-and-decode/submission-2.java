class Solution {

    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for(String string: strs) {
            builder.append(string.length()).append('#');
            builder.append(string);
        }
        // System.out.println(builder.toString());
        return builder.toString();
    }

    public List<String> decode(String str) {
        int end = 0;
        List<String> list = new ArrayList<>();
        while (end < str.length()) {
            int length = 0;
            while (end < str.length() && Character.isDigit(str.charAt(end))) {
                length = length * 10 + (str.charAt(end) - '0');
                end++;
            }
            end++;
            list.add(str.substring(end, end + length));
            end += length;
        }
        return list;
    }
}
