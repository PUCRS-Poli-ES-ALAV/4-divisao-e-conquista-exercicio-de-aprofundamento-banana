package br.pucrs;
import java.util.Random;

//testar o algoritmo Merge Sort
//com diferentes tamanhos de vetores
public class App 
{
    public static void main(String[] args) {
        System.out.println("=".repeat(80));
        System.out.println("TESTE DO ALGORITMO MERGE SORT - DIVISÃO E CONQUISTA");
        System.out.println("=".repeat(80));
        System.out.println();
        
        int[] sizes = {32, 2048, 1_048_576};//tamanhos dos vetores a testar

        //executar testes para cada tamanho
        for (int size : sizes) {
            testarMergeSort(size);
            System.out.println();
        }
        System.out.println("=".repeat(80));
        System.out.println("FIM DOS TESTES");
        System.out.println("=".repeat(80));
    }
    
    //Testa o Merge Sort com um tamanho específico
    //@param size tamanho do vetor
    private static void testarMergeSort(int size) {
        System.out.println("TESTE COM VETOR DE TAMANHO: " + size);
        System.out.println("-".repeat(80));
        
        long[] arr = gerarVetorAleatorio(size);// Criar array com valores aleatórios
        long[] arrCopy = arr.clone();// Criar uma cópia para validação
        MergeSort sorter = new MergeSort();// Criar instância do MergeSort
        long startTime = System.nanoTime();// Medir tempo de início
        long iterations = sorter.mergeSort(arr, size);// Executar o algoritmo
        long endTime = System.nanoTime(); //medir tempo de fim

        
        //calcular tempo em milissegundos
        double timeMs = (endTime - startTime) / 1_000_000.0;
        
        //validar a ordenação
        boolean isOrdenado = validarOrdenacao(arr);
        
        // Exibir resultados
        System.out.printf("Número de iterações: %,d%n", iterations);
        System.out.printf("Tempo gasto: %.2f ms%n", timeMs);
        System.out.printf("Status de ordenação: %s%n", isOrdenado ? "✓ CORRETO" : "✗ ERRO");
        
        // Mostrar alguns valores como amostra
        System.out.print("Primeiros 10 elementos: ");
        for (int i = 0; i < Math.min(10, size); i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //Gera um vetor com valores inteiros aleatórios
    //@param size tamanho do vetor
    //@return vetor preenchido com valores aleatórios
    private static long[] gerarVetorAleatorio(int size) {
        long[] arr = new long[size];
        Random random = new Random(System.currentTimeMillis());
        
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextLong() % 1_000_000; // Valores aleatórios entre -1_000_000 e 1_000_000
        }
        return arr;
    }

    //Valida se o vetor está ordenado em ordem crescente
    //@param arr vetor a validar
    //@return true se está ordenado, false caso contrário
    private static boolean validarOrdenacao(long[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
