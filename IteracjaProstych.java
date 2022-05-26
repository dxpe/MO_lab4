public class IteracjaProstych {
    double a11, a12, a13;
    double a21, a22, a23;
    double a31, a32, a33;
    double b1, b2, b3;
    double x1, x2, x3;
    double iteracja = 1;
    double epsilon = 0.001;

    IteracjaProstych() {
        a11 = 3; a12 = 1; a13 = 2;
        a21 = 1; a22 = -4; a23 = 1;
        a31 = 1; a32 = 2; a33 = 3;
        b1 = 5;
        b2 = -7;
        b3 = 2;
    }

    public double calc_x1(double x2, double x3) {
        return b1/a11 - a12/a11 * x2 - a13/a11 * x3;
    }

    public double calc_x2(double x1, double x3) {
        return b2/a22 - a21/a22 * x1 - a23/a22 * x3;
    }

    public double calc_x3(double x1, double x2) {
        return b3/a33 - a31/a33 * x1 - a32/a33 * x2;
    }

    public void calc() {
        x1 = calc_x1(0, 0);
        x2 = calc_x2(0, 0);
        x3 = calc_x3(0, 0);

        double x1_temp = x1;
        double x2_temp = x2;
        double x3_temp = x3;

        x1 = calc_x1(x2, x3);
        x2 = calc_x2(x1, x3);
        x3 = calc_x3(x1, x2);

        while (Math.abs(x1 - x1_temp) > epsilon || Math.abs(x2 - x2_temp) > epsilon || Math.abs(x3 - x3_temp) > epsilon) {
            x1_temp = x1;
            x2_temp = x2;
            x3_temp = x3;

            x1 = calc_x1(x2, x3);
            x2 = calc_x2(x1, x3);
            x3 = calc_x3(x1, x2);
            iteracja++;
        }

        System.out.println(x1 + " " + x2 + " " + x3 + " iteracja: " + iteracja);
    }

    public static void main(String[] args) {
        IteracjaProstych ip = new IteracjaProstych();
        ip.calc();
    }
}
