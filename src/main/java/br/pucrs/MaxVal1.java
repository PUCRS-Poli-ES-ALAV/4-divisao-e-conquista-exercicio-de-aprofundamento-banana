package br.pucrs;

/**
 * Classe que implementa o algoritmo linear para encontrar o maior valor em um vetor
 * (não utiliza divisão e conquista)
 */
public class MaxVal1 {

    private long iterationCount;

    /**
     * Encontra o maior valor no array usando busca linear
     * @param A array de entrada
     * @param n tamanho do array
     * @return maior valor encontrado
     */
    public long maxVal1(long[] A, int n) {
        iterationCount = 0;

        if (n == 0) {
            throw new IllegalArgumentException("Array vazio");
        }

        long max = A[0]; // Inicializa com primeiro elemento
        iterationCount++; // Conta a inicialização

        // Percorre o array comparando cada elemento
        for (int i = 1; i < n; i++) {
            iterationCount++; // Conta cada iteração do loop

            if (A[i] > max) {
                max = A[i];
                iterationCount++; // Conta a atribuição quando encontra maior
            }
        }

        return max;
    }

    /**
     * Retorna o número total de iterações da última execução
     */
    public long getIterationCount() {
        return iterationCount;
    }
}