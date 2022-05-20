import java.util.Arrays;

public class MetodaNajmniejszychKwadratow {
    static double[] x;
    static double[] y;
    static int n;
    static int m;
    static double[][] skj;
    static double[] tk;
    static double[] a;

    static {
        n = 4;
        m = 2;
        x = new double[4];
        y = new double[4];
        skj = new double[m + 1][m + 1];
        tk = new double[m + 1];
        a = new double[m + 1];

        x[0] = 1;
        x[1] = 2;
        x[2] = 3;
        x[3] = 4;

        y[0] = 6;
        y[1] = 19;
        y[2] = 40;
        y[3] = 69;
    }

    public void calc_skj() {
        for (int i = 0; i <= m ; i++) {
            for (int j = 0; j <= m; j++) {
                double suma = 0;
                for (int k = 0; k < n; k++) {
                    suma += Math.pow(x[k], i + j);
                }
                skj[i][j] = suma;
            }
        }
    }

    public void calc_tk() {
        for (int k = 0; k <= m; k++) {
            double suma = 0;
            for (int i = 0; i < n; i++) {
                suma += Math.pow(x[i], k) * y[i];
            }
            tk[k] = suma;
        }
    }

    public void calc(double x) {
        calc_skj();
        calc_tk();
        a = Gauss.lsolve(skj, tk);

        System.out.print(a[0]);
        double wx = a[0];
        for (int i = 1; i <= m; i++) {
            if (i > 1) {
                System.out.print(" + " + a[i] + "x" + "^" + i);
            } else {
                System.out.print(" + " + a[i] + "x");
            }
            wx += Math.pow(x, i) * a[i];
        }

        System.out.println("\nW(" + x + ") = " + wx);
    }

    public static void main(String[] args) {
        MetodaNajmniejszychKwadratow mnk = new MetodaNajmniejszychKwadratow();
        mnk.calc(2.5);
    }
}
