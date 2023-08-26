import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// Jaen Rafael M. Toyoda
public class Algorithm {
    public static void main(String[] args) {
        Integer num[] = {23, 56, -10, 100, 45, -78, 90, 45, 69, -7};
        List data = new ArrayList(Arrays.asList(num));
        for (int val : num) {
            if (val < 0) {
                data.remove(Integer.valueOf(val));
            }
        }
        System.out.println(data);
        System.out.println("Jaen Rafael M. Toyoda");
    }
}
