public class MetodaStycznych {
    static double a;
    static double b;
    static double epsilon;
    int iteration = 0;
    double x0;
    double xn1;
    double xn;
    int n = 1;

    static {
        a = 1;
        b = 2;
        epsilon = 0.01;
    }

    public double function(double x) {
        return Math.pow(x, 2) + x - 5;
    }

    public double function_prim(double x) {
        return 2 * x + 1;
    }

    public double function_bis(double x) {
        return 2;
    }

    public void calculate_x0(){
        if (function(a) * function_bis(a) >= 0) {
            x0 = a;
        } else {
            x0 = b;
        }
        xn = x0;
    }

    public boolean check(double a, double b) {
        if (function(a) * function(b) < 0) {
            return true;
        } else {
            return false;
        }
    }

    public double calculate_x_n(int n) {
        if (n == 0) {
            return xn;
        } else {
            return calculate_x_n(n - 1) - function(calculate_x_n(n - 1)) / function_prim(calculate_x_n(n - 1));
        }
    }

    public void calculate() {
        calculate_x0();
        xn1 = xn;
        while (Math.abs(function(xn1)) > epsilon){
            xn1 = calculate_x_n(n);
            iteration++;
            n++;
            System.out.println(xn1);
        }
        System.out.println("Iteracja: " + iteration);
        System.out.println("xn1 = " + xn1 + " jest rozwiazaniem");
    }

    public static void main(String[] args) {
        MetodaStycznych ms = new MetodaStycznych();
        ms.calculate();
    }
}
