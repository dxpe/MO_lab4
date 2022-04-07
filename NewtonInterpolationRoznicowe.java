public class NewtonInterpolationRoznicowe {
    static int n = 5;
    static double[] xi = new double[n];
    static double[] f_xi = new double[n];
    static int h;

    static {
//        (-4,180) (-2,12) (0,4) (2,-36) (4,-300) pochodne (-4,-156),(4,-220) x=3

//        0 2 3 4 6
//        1 3 2 5 7
        xi[0] = -4;
        xi[1] = -2;
        xi[2] = 0;
        xi[3] = 2;
        xi[4] = 4;

        f_xi[0] = 180;
        f_xi[1] = 12;
        f_xi[2] = 4;
        f_xi[3] = -36;
        f_xi[4] = -300;

        h = (int) Math.abs((xi[1] - xi[0]));
    }

    public double roznica(int rzad, int wiersz) {
        if (rzad == 1) {
            return (f_xi[wiersz + 1] - f_xi[wiersz]);
        } else {
            return (roznica(rzad - 1, wiersz + 1) - roznica(rzad - 1, wiersz));
        }
    }

    public double wielomian(double x) {
        double sum = f_xi[0];
        for (int i = 1; i < n; i++) {
            sum = sum + (roznica(i, 0) / (silnia(i) * Math.pow(h, i)))  * f_iloczyn(x, i);
        }
        return sum;
    }

    public double silnia(double n) {
        double sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
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
        NewtonInterpolationRoznicowe ni = new NewtonInterpolationRoznicowe();

        System.out.println(ni.wielomian(3));
    }
}