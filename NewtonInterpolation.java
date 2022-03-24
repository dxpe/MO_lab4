import java.util.Scanner;

public class NewtonInterpolation {
    static int n = 5;
    static double[] xi = new double[n];
    static double[] f_xi = new double[n];

    static {
//        0 2 3 4 6
//        1 3 2 5 7
        xi[0] = 0;
        xi[1] = 2;
        xi[2] = 3;
        xi[3] = 4;
        xi[4] = 6;

        f_xi[0] = 1;
        f_xi[1] = 3;
        f_xi[2] = 2;
        f_xi[3] = 5;
        f_xi[4] = 7;
    }

    public double iloraz(int rzad, int wiersz) {
        if (rzad == 1) {
            return (f_xi[wiersz + 1] - f_xi[wiersz]) / (xi[wiersz + rzad] - xi[wiersz]);
        } else {
            return (iloraz(rzad - 1, wiersz + 1) - iloraz(rzad - 1, wiersz)) / (xi[wiersz + rzad] - xi[wiersz]);
        }
    }

    public double wielomian(double x) {
        double sum = f_xi[0];
        for (int i = 1; i < n; i++) {
            sum = sum + iloraz(i, 0) * f_iloczyn(x, i);
        }
        return sum;
    }

    public double f_iloczyn(double x, int n) {
        double sum = 1;
        for (int i = 0; i < n; i++) {
            sum = sum * (x - xi[i]);
        }
        return sum;
    }
    public static void main(String[] args) {
        NewtonInterpolation ni = new NewtonInterpolation();

        System.out.println(ni.wielomian(1));
    }
}
