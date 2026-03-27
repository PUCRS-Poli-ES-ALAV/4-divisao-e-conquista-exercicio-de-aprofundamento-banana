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
        System.out.println("TESTE DO ALGORITMO MAXVAL1 - BUSCA LINEAR (SEM DIVISÃO E CONQUISTA)");
        System.out.println("=".repeat(80));
        System.out.println();
        
        //executar testes do MaxVal1 para cada tamanho
        for (int size : sizes) {
            testarMaxVal1(size);
            System.out.println();
        }
        System.out.println("=".repeat(80));
        System.out.println("TESTE DO ALGORITMO MULTIPLICACAO INTEIRA - DIVISAO E CONQUISTA");
        System.out.println("=".repeat(80));
        System.out.println();
        
        int[] bitSizes = {4, 16, 64};
        //executar testes da multiplicação para cada tamanho de bits
        for (int bits : bitSizes) {
            testarMultiply(bits);
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
    
    /**
     * Testa o MaxVal1 com um tamanho específico
     * @param size tamanho do vetor
     */
    private static void testarMaxVal1(int size) {
        System.out.println("TESTE COM VETOR DE TAMANHO: " + size);
        System.out.println("-".repeat(80));
        
        // Criar array com valores aleatórios
        long[] arr = gerarVetorAleatorio(size);
        
        // Criar instância do MaxVal1
        MaxVal1 finder = new MaxVal1();
        
        // Medir tempo de início
        long startTime = System.nanoTime();
        
        // Executar o algoritmo
        long maxValue = finder.maxVal1(arr, size);
        long iterations = finder.getIterationCount();
        
        // Medir tempo de fim
        long endTime = System.nanoTime();
        
        // Calcular tempo em milissegundos
        double timeMs = (endTime - startTime) / 1_000_000.0;
        
        // Validar o resultado (verificar se realmente é o maior)
        boolean isCorrect = validarMaximo(arr, maxValue);
        
        // Exibir resultados
        System.out.printf("Maior valor encontrado: %,d%n", maxValue);
        System.out.printf("Número de iterações: %,d%n", iterations);
        System.out.printf("Tempo gasto: %.2f ms%n", timeMs);
        System.out.printf("Status da busca: %s%n", isCorrect ? "✓ CORRETO" : "✗ ERRO");
        
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
    
    /**
     * Valida se o valor fornecido é realmente o maior no array
     * @param arr vetor a validar
     * @param maxValue valor que deveria ser o máximo
     * @return true se é o maior, false caso contrário
     */
    private static boolean validarMaximo(long[] arr, long maxValue) {
        for (long value : arr) {
            if (value > maxValue) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Testa a multiplicação com números de n bits
     * @param bits número de bits dos operandos
     */
    private static void testarMultiply(int bits) {
        System.out.println("TESTE COM NUMEROS DE " + bits + " BITS");
        System.out.println("-".repeat(80));
        
        // Gerar x e y aleatórios de bits bits
        Random random = new Random(System.currentTimeMillis());
        long mask = (bits == 64) ? -1L : ((1L << bits) - 1);
        long x = random.nextLong() & mask;
        long y = random.nextLong() & mask;
        
        Multiply multiplier = new Multiply();
        
        long startTime = System.nanoTime();
        long result = multiplier.multiply(x, y, bits);
        long endTime = System.nanoTime();
        
        long iterations = multiplier.getIterationCount();
        double timeMs = (endTime - startTime) / 1_000_000.0;
        
        // Calcular resultado esperado
        long expected = x * y;
        
        System.out.printf("x: %,d (%d bits)%n", x, bits);
        System.out.printf("y: %,d (%d bits)%n", y, bits);
        System.out.printf("Resultado: %,d%n", result);
        System.out.printf("Esperado: %,d%n", expected);
        System.out.printf("Correto: %s%n", result == expected ? "✓ SIM" : "✗ NAO");
        System.out.printf("Número de iterações: %,d%n", iterations);
        System.out.printf("Tempo gasto: %.2f ms%n", timeMs);
    }
}
