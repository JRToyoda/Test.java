public class BigOh {
    public static void main(String[] args) {

    }
    // Algorithm 1
    public int printFirst(int data[]) {                     // O(1)
        return data[0];
    }
    // Algorithm 2
    public int printByIndex(int data[], int i) {            // O(1)
        return data[i];
    }
    // Algorithm 3
    public String printAll(int data[]) {                    // O(n)
        String hold = "";
        for (int value : data) {
            hold += value + " ";
        }
        return hold;
    }
    // Algorithm 4
    public String printSquareOfN(int n) {                   // O(n)
        int prod = 1;
        String hold = "";
        for (int a = 1; a <= n; a++) {
            prod = a * a;
            hold += a + "^2" + "=" + prod + "\n";
        }
        return hold;
    }
    // Algorithm 5
    public int sumOfCube(int n) {                           // O(log(n))
        int sum = 0;
        for (int a = 1; a <= n; a *= 3) {
            sum += a;
        }
        return sum;
    }
    // Algorithm 6
    public String printMultiplication(int row, int column) { // O(n^2)
        int product = 0;
        String hold = "";
        for (int multiplicand = 1; multiplicand <= row; multiplicand++) {
            for (int multiplier = 1; multiplier <= column; multiplier++) {
                product = multiplicand*multiplier;
                hold += multiplier + "x" + multiplicand + "=" + product + "\t";
            }
            hold += "\n";
        }
        return hold;
    }
}
// Jaen Rafael M. Toyoda