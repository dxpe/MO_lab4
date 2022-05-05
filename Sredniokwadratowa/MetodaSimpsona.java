import java.util.Arrays;

public class MetodaSimpsona {
    int n = 30;
    int a;
    int b;
    double h;
    double[] f_x;
    double[] t_i;
    int potega_i, potega_j;
    boolean bi_true;

    MetodaSimpsona(int a, int b) {
        this.a = a;
        this.b = b;
        this.f_x = new double[n + 1];
        this.t_i = new double[n];
        bi_true = false;
    }

    MetodaSimpsona(int a, int b, boolean bi_true) {
        this.a = a;
        this.b = b;
        this.f_x = new double[n + 1];
        this.t_i = new double[n];
        this.bi_true = bi_true;
    }

    public double oblicz(int potega_i, int potega_j) {
        this.potega_i = potega_i;
        this.potega_j = potega_j;
        f_x_calculate();
        double sum = 0;
        for (int i = 1; i < n; i++) {
            sum += funkcjaPodcalkowa(f_x[i]) * 2;
        }
        for (int i = 0; i < n; i++) {
            sum += funkcjaPodcalkowa(t_i[i]) * 4;
        }
        sum += funkcjaPodcalkowa(f_x[0]) + funkcjaPodcalkowa(f_x[n]);
        sum *= h / 3;
        return sum;
    }

    private double funkcjaPodcalkowa(double f_x1) {
        if (bi_true) {
            return Math.pow(f_x1, potega_i) * Math.sqrt(f_x1);
        } else {
            return Math.pow(f_x1, potega_i) * Math.pow(f_x1, potega_j);
        }
    }

    void f_x_calculate() {
        for (int i = 1; i < n; i++) {
            f_x[i] = a + (i * 1.0 *(b - a)) / n; // 1 + 3 / 0.75
        }
        f_x[0] = a;
        f_x[n] = b;
        h = (f_x[2] - f_x[1]) / 2;
        for (int i = 0; i < n; i++) {
            t_i[i] = (f_x[i + 1] + f_x[i]) / 2;
        }
    }

//    public static void main(String[] args) {
//        MetodaSimpsona simpsona = new MetodaSimpsona();
//        System.out.println(simpsona.oblicz());
//    }
}