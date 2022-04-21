import java.util.Arrays;

public class MetodaSimpsona {
    static int n;
    static int a;
    static int b;
    static double h;
    static double[] f_x;
    static double[] t_i;

    static {
        a = 1;
        b = 4;
        n = 3;
        f_x = new double[n + 1];
        t_i = new double[n];
    }

    public double oblicz() {
        f_x_calculate();
        double sum = 0;
        for (int i = 1; i < n; i++) {
            sum += funkcjaPodcalkowa(f_x[i]) * 2;
            System.out.println(funkcjaPodcalkowa(f_x[i]));
        }
        for (int i = 0; i < n; i++) {
            sum += funkcjaPodcalkowa(t_i[i]) * 4;
            System.out.println(funkcjaPodcalkowa(f_x[i]));
        }
        System.out.println("sum = " + sum);
        sum += funkcjaPodcalkowa(f_x[0]) + funkcjaPodcalkowa(f_x[n]);
        System.out.println("sum = " + sum);
        sum *= h / 3;
        System.out.println("sum * h = " + sum + " h = " + h);
        return sum;
    }

    private double funkcjaPodcalkowa(double f_x1) {
        return Math.pow(f_x1, 2);
    }

    static void f_x_calculate() {
        for (int i = 1; i < n; i++) {
            f_x[i] = a + (i * 1.0 *(b - a)) / n; // 1 + 3 / 0.75
        }
        f_x[0] = a;
        f_x[n] = b;
        h = (f_x[2] - f_x[1]) / 2;
        System.out.println(Arrays.toString(f_x));
        for (int i = 0; i < n; i++) {
            t_i[i] = (f_x[i + 1] + f_x[i]) / 2;
        }
        System.out.println(Arrays.toString(t_i));
    }

    public static void main(String[] args) {
        MetodaSimpsona simpsona = new MetodaSimpsona();
        System.out.println(simpsona.oblicz());
    }
}
