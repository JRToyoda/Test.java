import java.util.Arrays;
import java.util.Random;

public class LinearSearching2 {
    public static void main(String[] args) {
        int num[] = LinearSearching2.addElements();
        System.out.println("New Array\t\t: " + Arrays.toString(LinearSearching2.removeOutliers(num)));
        System.out.println("\nJaen Rafael M. Toyoda");
    }
    public static int[] addElements() {
        int num[] = new int[Integer.MAX_VALUE/100];
        Random rnd = new Random();
        int val = 0;
        for (int i = 0; i < num.length; i++) {
            val = rnd.nextInt(Integer.MAX_VALUE) - num.length;
            num[i] = val;
        }
        return num;
    }
    public static int[] removeOutliers(int num[]) {
        int outlier = 0;
        for (int val : num) {
            if (val < 0) {
                outlier++;
            }
        }
        int arr[] = new int[num.length - outlier];
        for (int n = 0, m = 0; n < num.length; n++) { // removes all negative numbers from the array
            if (num[n] < 0) {
                continue;
            }
            arr[m] = num[n];
            m++;
        }
        return arr;
    }
} // Jaen Rafael M. Toyoda

