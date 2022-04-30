public class GaussLegendre {
    static double a;
    static double b;
    static int n = 2;
    static double[] wi = new double[n];
    static double[] ti = new double[n];

    static {
        a = 2;
        b = 3;
        if (n == 2) {
            wi[0] = 1;
            wi[1] = 1;
            ti[0] = -0.5773502691896257;
            ti[1] = 0.5773502691896257;
        } else if (n == 4) {
            wi[0] = 0.6521451548625461;
            wi[1] = 0.6521451548625461;
            wi[2] = 0.3478548451374538;
            wi[3] = 0.3478548451374538;
            ti[0] = -0.3399810435848563;
            ti[1] = 0.3399810435848563;
            ti[2] = -0.8611363115940526;
            ti[3] = 0.8611363115940526;
        } else if (n == 6) {
            wi[0] = 0.3607615730481386;
            wi[1] = 0.3607615730481386;
            wi[2] = 0.4679139345726910;
            wi[3] = 0.4679139345726910;
            wi[4] = 0.1713244923791704;
            wi[5] = 0.1713244923791704;
            ti[0] = 0.6612093864662645;
            ti[1] = -0.6612093864662645;
            ti[2] = -0.2386191860831969;
            ti[3] = 0.2386191860831969;
            ti[4] = -0.9324695142031521;
            ti[5] = 0.9324695142031521;
        } else if (n == 8) {
            wi[0] = 0.3626837833783620;
            wi[1] = 0.3626837833783620;
            wi[2] = 0.3137066458778873;
            wi[3] = 0.3137066458778873;
            wi[4] = 0.2223810344533745;
            wi[5] = 0.2223810344533745;
            wi[6] = 0.1012285362903763;
            wi[7] = 0.1012285362903763;
            ti[0] = -0.1834346424956498;
            ti[1] = 0.1834346424956498;
            ti[2] = -0.5255324099163290;
            ti[3] = 0.5255324099163290;
            ti[4] = -0.7966664774136267;
            ti[5] = 0.7966664774136267;
            ti[6] = -0.9602898564975363;
            ti[7] = 0.9602898564975363;
        } else if (n == 10) {
            wi[0] = 0.2955242247147529;	ti[0] = -0.1488743389816312;
            wi[1] = 0.2955242247147529;	ti[1] = 0.1488743389816312;
            wi[2] = 0.2692667193099963;	ti[2] = -0.4333953941292472;
            wi[3] = 0.2692667193099963;	ti[3] = 0.4333953941292472;
            wi[4] = 0.2190863625159820;	ti[4] = -0.6794095682990244;
            wi[5] = 0.2190863625159820;	ti[5] = 0.6794095682990244;
            wi[6] = 0.1494513491505806;	ti[6] = 0.8650633666889845;
            wi[7] = 0.1494513491505806;	ti[7] = 0.8650633666889845;
            wi[8] = 0.0666713443086881;	ti[8] = -0.9739065285171717;
            wi[9] = 0.0666713443086881;	ti[9] = 0.9739065285171717;
        } else if (n == 16) {
            wi[0] = 0.1894506104550685;	ti[0] = -0.0950125098376374;
            wi[1] = 0.1894506104550685;	ti[1] = 0.0950125098376374;
            wi[2] = 0.1826034150449236;	ti[2] = -0.2816035507792589;
            wi[3] = 0.1826034150449236;	ti[3] = 0.2816035507792589;
            wi[4] = 0.1691565193950025;	ti[4] = -0.4580167776572274;
            wi[5] = 0.1691565193950025;	ti[5] = 0.4580167776572274;
            wi[6] = 0.1495959888165767;	ti[6] = -0.6178762444026438;
            wi[7] = 0.1495959888165767;	ti[7] = 0.6178762444026438;
            wi[8] = 0.1246289712555339;	ti[8] = -0.7554044083550030;
            wi[9] = 0.1246289712555339; ti[9] = 0.7554044083550030;
            wi[10] = 0.0951585116824928; ti[10] = -0.8656312023878318;
            wi[11] = 0.0951585116824928; ti[11] = 0.8656312023878318;
            wi[12] = 0.0622535239386479; ti[12] = -0.9445750230732326;
            wi[13] = 0.0622535239386479; ti[13] = 0.9445750230732326;
            wi[14] = 0.0271524594117541; ti[14] = -0.9894009349916499;
            wi[15] = 0.0271524594117541; ti[15] = 0.9894009349916499;
        }
    }

    public double oblicz() {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += wi[i] * funkcja_podcalkowa(((b - a) * ti[i]) / 2 + (b + a) / 2);
        }
        return sum * (b - a) / 2;
    }

    public double funkcja_podcalkowa(double x) {
        return (x - 1)/(Math.pow(x, 2) + x);
    }

    public static void main(String[] args) {
        GaussLegendre gl = new GaussLegendre();
        System.out.println(gl.oblicz());
    }
}
