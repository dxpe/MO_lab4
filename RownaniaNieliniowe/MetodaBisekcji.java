public class MetodaBisekcji {
    static double a;
    static double b;
    static double epsilon;
    double x_sr = 1;
    int iteration = 1;

    static {
        a = 1;
        b = 2;
        epsilon = 0.05;
    }

    public double function(double x) {
        return Math.pow(x, 2) + x - 5;
    }

    public boolean check(double a, double b) {
        if (function(a) * function(b) < 0) {
            return true;
        } else {
            return false;
        }
    }

    public void calculate_x_sr(double a, double b) {
        x_sr = (a + b) / 2;
    }

    public void calculate() {
        calculate_x_sr(a, b);;
        while (Math.abs(function(x_sr)) > epsilon) {
            if (x_sr == 0) {
                System.out.println("Iteracja: " + iteration);
                System.out.println("x_sr = " + x_sr + " jest rozwiazaniem");
            }

            if (check(x_sr, a)) {
                b = x_sr;
                calculate_x_sr(a, x_sr);
            } else {
                a = x_sr;
                calculate_x_sr(x_sr, b);
            }
            iteration++;
        }
        System.out.println("Iteracja: " + iteration);
        System.out.println("x_sr = " + x_sr + " jest rozwiazaniem");
    }

    public static void main(String[] args) {
        MetodaBisekcji mb = new MetodaBisekcji();
        mb.calculate();
    }
}
