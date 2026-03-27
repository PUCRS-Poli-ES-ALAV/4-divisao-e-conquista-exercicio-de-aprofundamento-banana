package br.pucrs;

// Implementa o algoritmo Merge Sort usando divisão e conquista
// Conta o número de iterações (chamadas recursivas) durante a execução
public class MergeSort {
    // Variável para armazenar a contagem total de iterações
    private long iterationCount;
    
    // Inicia o Merge Sort pelo método recursivo
    // Retorna o número total de iterações executadas
    public long mergeSort(long[] arr, int n) {
        iterationCount = 0;
        if (n > 1) {
            mergeSortRecursive(arr, 0, n - 1);
        }
        return iterationCount;
    }
    
    // Implementação recursiva: divide o array e ordena recursivamente
    // left e right definem os índices do subarray atual
    private void mergeSortRecursive(long[] arr, int left, int right) {
        // Incrementa contador para cada chamada recursiva do algoritmo
        iterationCount++;
        
        // Caso base: quando há apenas um elemento, o array está ordenado
        if (left >= right) {
            return;
        }
        // Encontra o ponto do meio para dividir o array em duas metades
        int mid = (left + right) / 2;
        // Ordena recursivamente a primeira metade (esquerda)
        mergeSortRecursive(arr, left, mid);
        // Ordena recursivamente a segunda metade (direita)
        mergeSortRecursive(arr, mid + 1, right);
        // Mescla as duas metades ordenadas
        merge(arr, left, mid, right);
    }
    
    // Mescla dois subarrays ordenados em um único array ordenado
    // left a mid: primeira metade, mid+1 a right: segunda metade
    private void merge(long[] arr, int left, int mid, int right) {
        // Calcula o tamanho do subarray da esquerda
        int n1 = mid - left + 1;
        // Calcula o tamanho do subarray da direita
        int n2 = right - mid;
        // Cria array temporário para a metade esquerda
        long[] leftArr = new long[n1];
        // Cria array temporário para a metade direita
        long[] rightArr = new long[n2];
        
        // Copia os elementos para o array temporário esquerdo
        for (int i = 0; i < n1; i++) {
            iterationCount++;
            leftArr[i] = arr[left + i];
        }
        // Copia os elementos para o array temporário direito
        for (int j = 0; j < n2; j++) {
            iterationCount++;
            rightArr[j] = arr[mid + 1 + j];
        }
        
        // Inicializa os índices para o processo de mesclagem
        int i = 0;      // Índice para leftArr
        int j = 0;      // Índice para rightArr
        int k = left;   // Índice para o array original
        
        // Compara elementos dos dois arrays e coloca o menor no array original
        while (i < n1 && j < n2) {
            iterationCount++;
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        
        // Copia os elementos restantes do array esquerdo (se houver)
        while (i < n1) {
            iterationCount++;
            arr[k++] = leftArr[i++];
        }
        
        // Copia os elementos restantes do array direito (se houver)
        while (j < n2) {
            iterationCount++;
            arr[k++] = rightArr[j++];
        }
    }
    
    // Retorna o número total de iterações da última execução do algoritmo
    public long getIterationCount() {
        return iterationCount;
    }
}
