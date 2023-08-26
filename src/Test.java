public class Test {
    public static void main(String[] args) {
        System.out.println(12345 % 10);

    }
    public static int max(int data[]) {                         // 1
        int highest = data[0];                                  // 1
        for (int i = 1; i < data.length; i++) {                 // 2n+2
            if (highest < data[i]) {                            // n
                highest = data[i];                              // n
            }
        }
        return highest;                                         // 1
    }
                                                                // Total : 4n+5
    public static int reverse(int num) {                        // 1
        int rev = 0;                                            // 1
        for (; num != 0;) {                                     // n + 1
            int lastDigit = num % 10;                           // n
            rev = rev * 10 + lastDigit;                         // n
            num /= 10;                                          // n
        }
        return rev;                                             // 1
    }
                                                                // Total : 4n+4
    public int reverseS(int num) {                              // 1
        String rev = "", val = num + "";                        // 2
        for (int i = val.length() - 1; i >= 0; i--) {           // 2n+2
            rev += val.charAt(i);                               // n
        }
        return Integer.parseInt(rev);                           // 1
    }
                                                                // Total: 3n+6
}
// Jaen Rafael M. Toyoda
