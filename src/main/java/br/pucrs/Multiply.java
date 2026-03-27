package br.pucrs;

// Implementa multiplicação de inteiros de n-bits usando divisão e conquista
// Divide os números em duas partes e resolve submultiplicações recursivas
public class Multiply {
    // Armazena o número de iterações realizadas
    private long iterationCount;

    // Construtor que inicializa o contador
    public Multiply() {
        this.iterationCount = 0;
    }

    // Multiplica dois números x e y de n bits usando divisão e conquista
    // Complexidade: O(n^2) onde n é o número de bits
    public long multiply(long x, long y, int n) {
        // Incrementa contador para cada chamada recursiva
        iterationCount++;
        // Caso base: quando há apenas 1 bit, multiplicação é trivial
        if (n == 1) {
            return x * y;
        } else {
            // Calcula m = ceil(n/2) para dividir o número em duas partes
            int m = (n + 1) / 2;
            // Calcula 2^m como potência de 2 usando shift bits
            long powM = 1L << m;
            // Extrai a parte alta de x (dígitos mais significativos)
            long a = x / powM;
            // Extrai a parte baixa de x (dígitos menos significativos)
            long b = x % powM;
            // Extrai a parte alta de y
            long c = y / powM;
            // Extrai a parte baixa de y
            long d = y % powM;
            // Recursivamente multiplica as partes altas: a*c
            long e = multiply(a, c, m);
            // Recursivamente multiplica as partes baixas: b*d
            long f = multiply(b, d, m);
            // Recursivamente multiplica: b*c
            long g = multiply(b, c, m);
            // Recursivamente multiplica: a*d
            long h = multiply(a, d, m);
            // Calcula 2^(2m) para deslocar os produtos corretamente
            long pow2m = 1L << (2 * m);
            // Calcula 2^m * (g + h)
            long powM_gh = (1L << m) * (g + h);
            // Combina os resultados: 2^(2m)*e + 2^m*(g+h) + f
            return pow2m * e + powM_gh + f;
        }
    }

    // Retorna o total de iterações da última execução
    public long getIterationCount() {
        return iterationCount;
    }

    // Reseta o contador para zero (útil para múltiplas execuções)
    public void resetIterationCount() {
        iterationCount = 0;
    }
}