public class WielomianOrtagonalny {
    double[] c_i;
    static int a;
    static int b;
    static int n;

    static {
        a = -1;
        b = 1;
        n = 2;
    }

    public static double wielomian(double x, double i) {
        if (i == 0) {
            return 1;
        } else if (i == 1) {
            return x;
        } else {
            return (1.0 / ((i - 1) + 1)) * ((2 * (i - 1)) + 1) * x * wielomian(x, i - 1) - ((i - 1) / ((i - 1) + 1)) * wielomian(x, i - 2);
        }
    }

    public double oblicz(double x) {
        oblicz_c_i(x);
        double suma = 0;
        for (int i = 0; i <= n; i++) {
            suma += c_i[i] * wielomian(x, i);
        }
        return suma;
    }

    private void oblicz_c_i(double x) {
        c_i = new double[n + 1];
        for (int i = 0; i <= n; i++) {
            c_i[i] = 1/lambda(i) * (new MetodaSimpsona(-1, 1, i, true).oblicz());
        }
    }

    private double lambda(int i) {
        return new MetodaSimpsona(-1, 1, i).oblicz();
    }

    public static void main(String[] args) {
        WielomianOrtagonalny wo = new WielomianOrtagonalny();
        System.out.println(wo.oblicz(0.5));
        System.out.println("Funkcja = " + Math.exp(0.5));
    }
}
