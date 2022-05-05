import java.util.Arrays;

public class Sredniokwadratowa {
    static int a;
    static int b;
    static int p;
    static int n;
    static double[][] matrix;
    static double[] matrix_bi;
    double[] niewiadome;

    static {
        a = 1;
        b = 3;
        p = 1;
        n = 2;
        matrix = new double[n + 1][n + 1];
        matrix_bi = new double[n + 1];
    }

    public double funkcja(double x) {
        return Math.sqrt(x);
    }

    public double wielomian(double x){
        oblicz_matrix();
        double sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += niewiadome[i] * Math.pow(x, i);
        }
        return sum;
    }

    public void oblicz_matrix() {
        MetodaSimpsona mt = new MetodaSimpsona(a, b);
        MetodaSimpsona mt2 = new MetodaSimpsona(a, b, true);
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                matrix[i][j] = mt.oblicz(i, j);
                System.out.println("i " + i + " j " + j + " = " + mt.oblicz(i,j));
            }
            matrix_bi[i] = mt2.oblicz(i, 0);
            System.out.println(mt2.oblicz(i, 0));
        }
        niewiadome = new double[n + 1];
        niewiadome = Gauss.lsolve(matrix, matrix_bi);
        System.out.println(Arrays.toString(niewiadome));
    }

    public static void main(String[] args) {
        Sredniokwadratowa sk = new Sredniokwadratowa();
        System.out.println("Funkcja = " + sk.funkcja(1) + " wielomian = " + sk.wielomian(1));
        System.out.println("Funkcja = " + sk.funkcja(2) + " wielomian = " + sk.wielomian(2));
    }
}
