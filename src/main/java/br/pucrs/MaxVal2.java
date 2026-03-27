package br.pucrs;

// Implementa divisão e conquista para encontrar o maior valor em um array
// Divide o array recursivamente e compara os máximos das metades
public class MaxVal2 {
    // Armazena o número de iterações realizadas
    private long iterationCount;

    // Encontra o maior valor recursivamente usando divisão e conquista
    // init: índice inicial, end: índice final (inclusivo)
    // Complexidade: O(n) - visita cada elemento uma vez, ~2n-1 chamadas
    private long maxVal2(long[] A, int init, int end) {
        // Incrementa contador para cada chamada recursiva
        iterationCount++;
        // Caso base: quando há apenas 1 ou 2 elementos
        if (end - init <= 1) {
            // Retorna o maior entre os dois elementos
            return Math.max(A[init], A[end]);
        } else {
            // Encontra o meio do array para fazer a divisão
            int m = (init + end) / 2;
            // Recursivamente encontra o máximo da primeira metade
            long v1 = maxVal2(A, init, m);
            // Recursivamente encontra o máximo da segunda metade
            long v2 = maxVal2(A, m + 1, end);
            // Retorna o maior entre os dois máximos
            return Math.max(v1, v2);
        }
    }

    // Método inicial que reseta o contador e inicia a busca recursiva
    // n: tamanho do array
    public long findMax(long[] A, int n) {
        // Reseta o contador antes de iniciar
        iterationCount = 0;
        // Valida se o array não está vazio
        if (n == 0) {
            throw new IllegalArgumentException("Array vazio");
        }
        // Inicia a busca com índices do primeiro e último elemento
        return maxVal2(A, 0, n - 1);
    }

    // Retorna o total de iterações da última execução
    public long getIterationCount() {
        return iterationCount;
    }
}