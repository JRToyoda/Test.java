import java.util.Random;
public class LinearSearching {
    public static void main(String[] args) {
        int num[] = LinearSearching.addElements();
        System.out.println("Max\t\t: " + LinearSearching.MAX(num));
        System.out.println("Jaen Rafael M. Toyoda");
    }
    public static int[] addElements() {
        int num[] = new int[Integer.MAX_VALUE/5];
        Random rnd = new Random();
        int val = 0;
        for (int i = 0; i < num.length; i++) {
            val = rnd.nextInt(Integer.MAX_VALUE) - num.length;
            num[i] = val;
        }
        return num;
    }
    public static int MAX(int num[]) {
        long start = System.nanoTime();
        int highest = 0;
        for (int val : num) {
            if (val > highest) {
                highest = val;
            }
        }
        long end = System.nanoTime();
        System.out.println("Processing Time\t: " + (end - start) + " units");
        return highest;
    }
    public static int Best(int num[]) {
        long start = System.nanoTime();
        int best = num[0];
        long end = System.nanoTime();
        System.out.println("Processing Time\t: " + (end - start) + " units");
        return best;
    }
    public static int Worst(int num[]) {
        long start = System.nanoTime();
        int i = 0;
        for (int val : num) {
            i++;
        }
        int worst = num[i-1];
        long end = System.nanoTime();
        System.out.println("Processing Time\t: " + (end - start) + " units");
        return worst;
    }

}
//Jaen Rafael M. Toyoda
