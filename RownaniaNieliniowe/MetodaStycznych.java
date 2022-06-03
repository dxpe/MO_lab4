public class MetodaStycznych {
    static double a;
    static double b;
    static double epsilon;
    int iteration = 1;
    int n = 1;

    static {
        a = 1;
        b = 2;
        epsilon = 0.01;
    }

    public double func(double x) {
        return Math.pow(x, 2) + x - 5;
    }

    public double func_prim(double x) {
        return 2 * x + 1;
    }

    public double func_bis(double x) {
        return 2;
    }

    public void warunek() {
        if (func(a) * func(b) < 0 && func_prim(a) * func_prim(b) >= 0 && func_bis(a) * func_bis(b) >= 0) {
            System.out.println("Warunek konieczny spełniony");
        } else {
            System.out.println("Warunek konieczny niespełniony");
        }
    }

    public double xn1(int n) {
        if (n == 0) {
            return x0();
        } else {
            return xn1(n - 1) - func(xn1(n - 1)) / func_prim(xn1(n - 1));
        }
    }

    public double x0() {
        if (func_bis(a) * func(a) >= 0) {
            return a;
        } else {
            return b;
        }
    }

    public void oblicz() {
        warunek();
        double xn1_func = func(xn1(n));
        double xn1_n1 = xn1(n);
        double xn1_n = xn1(n - 1);
        while(Math.abs(xn1_func) >= epsilon && Math.abs(xn1_n1 - xn1_n) >= epsilon) {
            n++;
            iteration++;
            xn1_func = func(xn1(n));
            xn1_n1 = xn1(n);
            xn1_n = xn1(n - 1);
        }
        System.out.println("Iteracja: " + iteration + " rozwiazanie: " + xn1_n1 + ", funkcja: " + func(xn1_n1));
    }

    public static void main(String[] args) {
        MetodaStycznych ms = new MetodaStycznych();
        ms.oblicz();
    }
}
