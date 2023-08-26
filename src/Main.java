public class Main {
    public static void main(String[] args) {
        //int num[] = {20, 30, 50, 100, 70, 30, 90, 15, 30, 40, 70, 150, 500, 1000, 1, 8, 350};
        int num[] = new int[2000000];
        for (int i = 0; i < num.length; i++) {
            num[i] = i;
        }
        System.out.println("Found\t\t: " + Main.search(1, num));
        System.out.println("Found\t\t: " + Main.search(1000, num));
        System.out.println("Found\t\t: " + Main.search(100000, num));
        System.out.println("Found\t\t: " + Main.search(1500000, num));
        System.out.println("Jaen Rafael M. Toyoda");
    }

    public static boolean search(int find, int num[]) {
        long start = System.nanoTime();
        boolean found = false;
        for (int i = 0; i < num.length; i++) {
            if (find == num[i]) {
                found = true;
                break;
            }
        }
        long end = System.nanoTime();
        System.out.println("Processing Time\t: " + (end - start) + " units");
        return found;
    }
}
//Jaen Rafael M. Toyoda