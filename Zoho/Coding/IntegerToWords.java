
public class IntegerToWords {
    String convertToWords(int n) {
        String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String [] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] hundreds = {"", "Thousand", "Million", "Billion"};
        
        if(n == 0) return "Zero";
        if(n < 20) return ones[n];
        if(n < 100) return tens[n / 10] + (n % 10 == 0 ? "" : " " + ones[n % 10]);
        if(n < 1000) return ones[(n / 100)] + " Hundred" + ((n % 100 == 0) ? "" : " " + convertToWords(n % 100));
        
        for(int i = 0; i < hundreds.length; i++) {
            if(n < Math.pow(1000, i + 1)) {
                return convertToWords(n / (int) Math.pow(1000, i)) + " " + hundreds[i] + (((n % (int) Math.pow(1000, i)) == 0) ? "" : " " + convertToWords(n % (int) Math.pow(1000, i)));
            }
        }
        return "";
    }
}
