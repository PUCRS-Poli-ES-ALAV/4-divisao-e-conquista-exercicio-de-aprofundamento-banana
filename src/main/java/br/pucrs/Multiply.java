package br.pucrs;

public class Multiply {
    private long iterationCount;

    public Multiply() {
        this.iterationCount = 0;
    }

    public long multiply(long x, long y, int n) {
        iterationCount++;
        if (n == 1) {
            return x * y;
        } else {
            int m = (n + 1) / 2; // ceil(n/2)
            long powM = 1L << m;
            long a = x / powM;
            long b = x % powM;
            long c = y / powM;
            long d = y % powM;
            long e = multiply(a, c, m);
            long f = multiply(b, d, m);
            long g = multiply(b, c, m);
            long h = multiply(a, d, m);
            long pow2m = 1L << (2 * m);
            long powM_gh = (1L << m) * (g + h);
            return pow2m * e + powM_gh + f;
        }
    }

    public long getIterationCount() {
        return iterationCount;
    }

    public void resetIterationCount() {
        iterationCount = 0;
    }
}