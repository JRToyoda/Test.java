public class binary {
    public static void main(String[] args) {
        int[] arr = {10, 12, 14, 15, 16, 20};
        int answer = 15;
        int first = 0;
        int last = arr.length;
        boolean found = false;
        while (first <= last) {
            int mid = (first + last)/2;
            if (arr[mid] == answer) {
                found = true;
                break;
            } else if (answer > arr[mid]) {
                first = mid + 1;
            } else if (answer < arr[mid]) {
                last = mid - 1;
            }
        }
        if (found == true) {
            System.out.println("The number is in the dataset");
        } else {
            System.out.println("Thu number is not in the dataset");
        }
    }
}
