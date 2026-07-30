class Solution {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < num2.length(); i++) {
            list.add(new StringBuilder());
        }

        int sum = 0;
        int power = 0;
        int carry = 0;
        int maxLength = 0;

        for (int i = num2.length() - 1; i >= 0; i--) {
            int number = num2.charAt(i) - '0';
            StringBuilder builder = list.get(i);
            carry = 0;
            sum = 0;
            for (int j = num1.length() - 1; j >= 0; j--) {
                sum = ((num1.charAt(j) - '0') * number) + carry;
                builder.append(sum % 10);
                carry = sum / 10;
            }
            builder.reverse();
            if (carry != 0) {
                builder.insert(0, carry);
            }
            for (int k = 0; k < power; k++) {
                builder.append('0');
            }
            maxLength = Math.max(maxLength, builder.length());
            power++;
        }

        // for (StringBuilder sb: list) {
        //     System.out.println(sb.toString());
        // }
        StringBuilder result = new StringBuilder();
        if (list.size() == 1) {
            return list.get(0).toString();
        }
        carry = 0;
        for (int i = 0; i < maxLength; i++) {
            sum = 0;
            for (StringBuilder sb: list) {
                if (sb.length() - 1 - i >= 0) {
                    // System.out.print(sb.charAt(sb.length() - 1 - i) + " ");
                    sum = sum + sb.charAt(sb.length() - 1 - i) - '0';
                }
            }
            sum += carry;
            // System.out.println(sum);
            result.append(sum % 10);
            carry = sum / 10;
        }

        return result.reverse().toString();
    }
}
