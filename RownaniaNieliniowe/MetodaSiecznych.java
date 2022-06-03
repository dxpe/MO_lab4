public class MetodaSiecznych {
    static double a;
    static double b;
    static double epsilon;
    int iteration;
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
        if (func(a) * func(b) < 0) {
            System.out.println("Warunek konieczny spełniony");
        } else {
            System.out.println("Warunek konieczny niespełniony");
        }
    }

    public boolean nieruchoma_a() {
        return func(a) * func_bis(a) >= 0;
    }

    public double xn1_a(int n) {
        if (n == 0) {
            return b;
        } else {
            return xn1_a(n - 1) - (func(xn1_a(n - 1)) / (func(xn1_a(n - 1)) - func(a))) * (xn1_a(n - 1) - a);
        }
    }

    public double xn1_b(int n) {
        if (n == 0) {
            return a;
        } else {
            return xn1_b(n - 1) - (func(xn1_b(n - 1)) / (func(b) - func(xn1_b(n - 1)))) * (b - xn1_b(n - 1));
        }
    }

    public void oblicz() {
        warunek();
        if (nieruchoma_a()) {
            while(Math.abs(func(xn1_a(n))) > epsilon && Math.abs(xn1_a(n) - xn1_a(n - 1)) > epsilon) {
                n++;
                iteration++;
            }
            System.out.println("Iteracja: " + iteration + " rozwiazanie: " + xn1_a(n));
        } else {
            while(Math.abs(func(xn1_b(n))) > epsilon && Math.abs(xn1_b(n) - xn1_b(n - 1)) > epsilon) {
                n++;
                iteration++;
            }
            System.out.println("Iteracja: " + iteration + " rozwiazanie: " + xn1_b(n));
        }
    }

    public static void main(String[] args) {
        MetodaSiecznych ms = new MetodaSiecznych();
        ms.oblicz();
    }
}
