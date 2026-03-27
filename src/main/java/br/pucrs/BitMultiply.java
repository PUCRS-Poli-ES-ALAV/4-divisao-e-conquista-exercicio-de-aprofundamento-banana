package br.pucrs;

/**
 * Classe que implementa a multiplicação de grandes inteiros representados como strings binárias
 * usando divisão e conquista
 */
public class BitMultiply {

    private static long iterationCount;

    /**
     * Multiplica duas strings de bits x e y
     * e retorna o resultado como um inteiro "long".
     * @param X string binária
     * @param Y string binária
     * @return produto como long
     */
    public static long multiply(String X, String Y) {
        iterationCount = 0;

        // Padding com zeros à esquerda para igualar comprimentos
        int n = Math.max(X.length(), Y.length());
        X = String.format("%" + n + "s", X).replace(' ', '0');
        Y = String.format("%" + n + "s", Y).replace(' ', '0');

        return multiplyHelper(X, Y, n);
    }

    private static long multiplyHelper(String X, String Y, int n) {
        iterationCount++;
        if (n == 1) {
            return (X.charAt(0) - '0') * (Y.charAt(0) - '0');
        } else {
            int m = (n + 1) / 2;
            String a = X.substring(0, n - m);
            String b = X.substring(n - m);
            String c = Y.substring(0, n - m);
            String d = Y.substring(n - m);

            long e = multiplyHelper(a, c, m);
            long f = multiplyHelper(b, d, m);
            long g = multiplyHelper(b, c, m);
            long h = multiplyHelper(a, d, m);

            long pow2m = 1L << (2 * m);
            long powM_gh = (1L << m) * (g + h);
            return pow2m * e + powM_gh + f;
        }
    }

    /**
     * Retorna o número de iterações da última execução
     */
    public static long getIterationCount() {
        return iterationCount;
    }
}