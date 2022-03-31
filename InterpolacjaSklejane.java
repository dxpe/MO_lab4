import java.util.Arrays;

public class InterpolacjaSklejane {
    static int n = 4;
    static double[] x = new double[n];
    static double[] f_x = new double[n];
    static double f_x0_dx; // pochodna pierwsza
    static double f_xn_dx; // pochodna druga
    static double[][] matrix = new double[n + (n - 1)][n + (n - 1)];

    static {
        x[0] = 1;
        x[1] = 3;
        x[2] = 5;
        x[3] = 7;

        f_x[0] = 1;
        f_x[1] = 8;
        f_x[2] = 9;
        f_x[3] = 17;

        f_x0_dx = 1;
        f_xn_dx = 1;
    }

    public static double[] suma(int xi, double x_search) {
        if (xi == 0) {
            double[] tab = new double[n + (n - 2)];
            for (int i = 0; i < n; i++) {
                tab[i] = Math.pow(x_search, i);
            }
            return tab;
        } else {
            int length = n + xi;
            double[] tab = new double[n + (n - 2)];
            for (int i = 0; i < n; i++) {
                tab[i] = Math.pow(x_search, i);
            }
            int index = 1;
            for (int i = n; i < length - 1; i++) {
                tab[i] = Math.pow(x_search - x[index], 3);
                index++;
            }
            return tab;
        }
    }

    public static double[] suma_pochodna(int pochodna, double x_search) {
        if (pochodna == 0) {
            // pierwsza pochodna
            double[] tab = new double[n + (n - 2)];
            tab[0] = 0;
            for (int i = 1; i < n; i++) {
                tab[i] = i * Math.pow(x_search, i - 1);
            }
            return tab;
        } else if (pochodna == 1){
            int length = n + (n - 2);
            double[] tab = new double[length];
            for (int i = 1; i < n; i++) {
                tab[i] = i * Math.pow(x_search, i - 1);
            }
            int index = 1;
            for (int i = n; i < length; i++) {
                tab[i] = 3 * Math.pow(x_search - x[index], 2);
                index++;
            }
            return tab;
        } else {
            return new double[0];
        }
    }

    public static void oblicz() {
        for (int j = 0; j < n + (n - 1) - 2; j++) {
            double tab[] = suma(j, x[j]);
            for (int i = 0; i < n + (n - 1); i ++) {
                matrix[i][j] = tab[i];
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void main(String[] args) {
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(suma(i, x[i])));
        }
//        System.out.println(Arrays.toString(suma_pochodna(0, 1)));
//        System.out.println(Arrays.toString(suma_pochodna(1, 7)));

        System.out.println();

        oblicz();
    }
}
