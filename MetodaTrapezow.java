import java.util.Arrays;

public class MetodaTrapezow {
    static int n;
    static int a;
    static int b;
    static double h;
    static double[] f_x;

    static {
        a = 1;
        b = 4;
        n = 10;
        h = (b - a) * 1.0 / n;
        f_x = new double[n + 1];
    }

    public double oblicz() {
        f_x_calculate();
        double sum = 0;
        for (int i = 1; i < n; i++) {
            sum += funkcjaPodcalkowa(f_x[i]);
            System.out.println(funkcjaPodcalkowa(f_x[i]));
        }
        System.out.println("sum = " + sum);
        sum += funkcjaPodcalkowa(f_x[0])/2.0 + funkcjaPodcalkowa(f_x[n])/2;
        System.out.println("sum = " + sum);
        sum *= h;
        System.out.println("sum * h = " + sum + " h = " + h);
        return sum;
    }

    private double funkcjaPodcalkowa(double f_x1) {
        return Math.pow(f_x1, 2);
    }

    private void f_x_calculate() {
        for (int i = 1; i < n; i++) {
            f_x[i] = a + (i * 1.0 *(b - a)) / n; // 1 + 3 / 0.75
        }
        f_x[0] = a;
        f_x[n] = b;
        System.out.println(Arrays.toString(f_x));
    }

    public static void main(String[] args) {
        MetodaTrapezow trapezow = new MetodaTrapezow();
        System.out.println(trapezow.oblicz());
    }
}
