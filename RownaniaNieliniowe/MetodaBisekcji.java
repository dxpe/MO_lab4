public class MetodaBisekcji {
    static double a;
    static double b;
    static double epsilon;
    double x_sr;
    int iteration = 1;

    static {
        a = 1;
        b = 2;
        epsilon = 0.05;
    }

    public void warunek() {
        if (function(a) * function(b) < 0) {
            System.out.println("Warunek konieczny spełniony");
        } else {
            System.out.println("Warunek konieczny niespełniony");
        }
    }

    public boolean warunek_x_sr() {
        return function(x_sr) * function(a) < 0;
    }

    public double function(double x) {
        return Math.pow(x, 2) + x - 5;
    }

    public void calc_x_sr() {
        x_sr = (a + b) / 2;
    }

    public void calc_przedzial() {
        if (warunek_x_sr()) {
            b = x_sr;
        } else {
            a = x_sr;
        }
    }

    public void oblicz() {
        warunek();
        calc_x_sr();
        if (x_sr == 0) {
            System.out.println("Wynik = " + x_sr);
        } else {
            iteration++;
        }
        while (!(Math.abs(function(x_sr)) < epsilon)) {
            calc_przedzial();
            calc_x_sr();
            iteration++;
        }

        System.out.println("Iteracja: " + iteration + " rozwiazanie: " + x_sr + ", funkcja: " + function(x_sr));
    }

    public static void main(String[] args) {
        MetodaBisekcji mb = new MetodaBisekcji();
        mb.oblicz();
    }
}
