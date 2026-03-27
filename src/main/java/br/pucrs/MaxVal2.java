package br.pucrs;

/**
 * Classe que implementa o algoritmo de divisão e conquista para encontrar o maior valor em um vetor
 */
public class MaxVal2 {

    private long iterationCount;

    /**
     * Encontra o maior valor no array usando divisão e conquista
     * @param A array de entrada
     * @param init índice inicial
     * @param end índice final (inclusivo)
     * @return maior valor encontrado
     */
    public long maxVal2(long[] A, int init, int end) {
        iterationCount++;
        if (end - init <= 1) {
            return Math.max(A[init], A[end]);
        } else {
            int m = (init + end) / 2;
            long v1 = maxVal2(A, init, m);
            long v2 = maxVal2(A, m + 1, end);
            return Math.max(v1, v2);
        }
    }

    /**
     * Método wrapper para iniciar a busca com contador resetado
     * @param A array de entrada
     * @param n tamanho do array
     * @return maior valor encontrado
     */
    public long findMax(long[] A, int n) {
        iterationCount = 0;
        if (n == 0) {
            throw new IllegalArgumentException("Array vazio");
        }
        return maxVal2(A, 0, n - 1);
    }

    /**
     * Retorna o número total de iterações da última execução
     */
    public long getIterationCount() {
        return iterationCount;
    }
}