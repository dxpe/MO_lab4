import java.util.Scanner;

public class LagrangeInterpolation {
    static int n = 5;
    static int[] x = new int[n];
    static int[] x_value = new int[n];

    static {
        x[0] = -4;
        x[1] = -2;
        x[2] = 0;
        x[3] = 2;
        x[4] = 4;

        x_value[0] = 180;
        x_value[1] = 12;
        x_value[2] = 4;
        x_value[3] = -36;
        x_value[4] = -300;

        for (int i = 0; i < n; i++) {
            x[i]--;
        }

//        x[0] = 0;
//        x[1] = 1;
//        x[2] = 2;
//
//        x_value[0] = 7;
//        x_value[1] = 9;
//        x_value[2] = 18;
    }
    public static void main(String[] args) {
        double sum = 1;
        double interpolation = 0;
        Scanner scanner = new Scanner(System.in);
        double x_search = scanner.nextDouble() - 1;

        for (int i = 0; i < n; i++) {
            sum = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    sum *= (x_search - x[j])/(x[i] - x[j]);
                }
            }
            System.out.println(sum);
            sum *= x_value[i];
//            System.out.println(sum);
            interpolation += sum;
        }
        System.out.println(interpolation);
    }
}
