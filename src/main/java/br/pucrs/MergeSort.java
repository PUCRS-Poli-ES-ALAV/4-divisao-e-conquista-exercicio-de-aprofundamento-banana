package br.pucrs;
public class MergeSort {//algoritmo Merge Sort com contagem de iterações
    private long iterationCount;
    
    //Executa o Merge Sort no array fornecido
    //@param arr array a ser ordenado
    //@param n tamanho do array
    //@return número de iterações executadas
    public long mergeSort(long[] arr, int n) {
        iterationCount = 0;
        if (n > 1) {
            mergeSortRecursive(arr, 0, n - 1);
        }
        return iterationCount;
    }
    
    //Implementação recursiva do Merge Sort
    //@param arr array a ser ordenado
    //@param left índice esquerdo
    //@param right índice direito
    private void mergeSortRecursive(long[] arr, int left, int right) {
        iterationCount++; //conta cada chamada recursiva
        
        if (left >= right) {//caso base: lista com um elemento
            return;
        }
        int mid = (left + right) / 2;//divide o array em duas metades
        mergeSortRecursive(arr, left, mid);//ordena recursivamente a metade esquerda
        mergeSortRecursive(arr, mid + 1, right);//ordena recursivamente a metade direita
        merge(arr, left, mid, right);//mescla as duas metades ordenadas

    }
    
     //Mescla dois subarrays ordenados em um array ordenado
     //@param arr array principal
     //@param left índice esquerdo
     //@param mid índice do meio
     //@param right índice direito
    private void merge(long[] arr, int left, int mid, int right) {
        //tamanhos dos dois subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;
        //arrays temporários
        long[] leftArr = new long[n1];
        long[] rightArr = new long[n2];
        //copia dados para os arrays temporários
        for (int i = 0; i < n1; i++) {
            iterationCount++;
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            iterationCount++;
            rightArr[j] = arr[mid + 1 + j];
        }
        //mescla os arrays temporários de volta no array principal
        int i = 0;
        int j = 0;
        int k = left;
        
        while (i < n1 && j < n2) {
            iterationCount++;
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        
        while (i < n1) {//copia os elementos restantes da metade esquerda
            iterationCount++;
            arr[k++] = leftArr[i++];
        }
        
        while (j < n2) {//copia os elementos restantes da metade direita
            iterationCount++;
            arr[k++] = rightArr[j++];
        }
    }
    
    public long getIterationCount() {//retorna o número total de iterações da última execução
        return iterationCount;
    }
}
