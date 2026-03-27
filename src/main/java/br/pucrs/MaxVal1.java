package br.pucrs;

// Implementa busca linear para encontrar o maior valor em um array
// Não usa divisão e conquista, percorre sequencialmente o array
public class MaxVal1 {
    // Armazena o número de iterações realizadas
    private long iterationCount;

    // Busca pelo maior valor percorrendo o array sequencialmente
    // Complexidade: O(n) - percorre todos os elementos uma vez
    public long maxVal1(long[] A, int n) {
        iterationCount = 0;

        // Valida se o array não está vazio
        if (n == 0) {
            throw new IllegalArgumentException("Array vazio");
        }

        // Inicializa o máximo com o primeiro elemento
        long max = A[0];
        // Incrementa contador de operações
        iterationCount++;

        // Loop que percorre todo o array procurando o maior valor
        for (int i = 1; i < n; i++) {
            // Conta cada iteração do loop principal
            iterationCount++;

            // Se encontra um valor maior, atualiza o máximo
            if (A[i] > max) {
                max = A[i];
                // Incrementa contador extra para a atribuição
                iterationCount++;
            }
        }

        return max;
    }

    // Retorna o total de iterações da última execução
    public long getIterationCount() {
        return iterationCount;
    }
}