package br.pucrs;
import java.util.Random;
import java.math.BigInteger;

// Classe principal para executar testes de todos os algoritmos de divisão e conquista
// Testa Merge Sort, MaxVal1, MaxVal2, Multiplicação e Multiplicação com Strings
public class App 
{
    // Método principal que executa todos os testes
    public static void main(String[] args) {
        System.out.println("=".repeat(80));
        System.out.println("TESTE DO ALGORITMO MERGE SORT - DIVISÃO E CONQUISTA");
        System.out.println("=".repeat(80));
        System.out.println();
        
        // Define tamanhos dos vetores para os testes
        int[] sizes = {32, 2048, 1_048_576};

        // Executa testes de Merge Sort para cada tamanho
        for (int size : sizes) {
            testarMergeSort(size);
            System.out.println();
        }
        System.out.println("=".repeat(80));
        System.out.println("TESTE DO ALGORITMO MAXVAL1 - BUSCA LINEAR (SEM DIVISÃO E CONQUISTA)");
        System.out.println("=".repeat(80));
        System.out.println();
        
        // Executa testes de MaxVal1 para cada tamanho
        for (int size : sizes) {
            testarMaxVal1(size);
            System.out.println();
        }
        System.out.println("=".repeat(80));
        System.out.println("TESTE DO ALGORITMO MAXVAL2 - DIVISAO E CONQUISTA");
        System.out.println("=".repeat(80));
        System.out.println();
        
        // Executa testes de MaxVal2 para cada tamanho
        for (int size : sizes) {
            testarMaxVal2(size);
            System.out.println();
        }
        System.out.println("=".repeat(80));
        System.out.println("TESTE DO ALGORITMO MULTIPLICACAO INTEIRA - DIVISAO E CONQUISTA");
        System.out.println("=".repeat(80));
        System.out.println();
        
        // Define tamanhos em bits para teste de multiplicação
        int[] bitSizes = {4, 16, 64};
        // Executa testes de multiplicação para cada tamanho de bits
        for (int bits : bitSizes) {
            testarMultiply(bits);
            System.out.println();
        }
        System.out.println("=".repeat(80));
        System.out.println("TESTE DO ALGORITMO MULTIPLICACAO INTEIRA (STRINGS) - DIVISAO E CONQUISTA");
        System.out.println("=".repeat(80));
        System.out.println();
        
        // Executa testes de multiplicação com strings para cada tamanho de bits
        for (int bits : bitSizes) {
            testarBitMultiply(bits);
            System.out.println();
        }
        System.out.println("=".repeat(80));
        System.out.println("FIM DOS TESTES");
        System.out.println("=".repeat(80));
    }
    
    // Executa testes do Merge Sort com um tamanho específico
    // Cria um array aleatório, ordena e valida o resultado
    private static void testarMergeSort(int size) {
        System.out.println("TESTE COM VETOR DE TAMANHO: " + size);
        System.out.println("-".repeat(80));
        
        // Gera um array com valores aleatórios
        long[] arr = gerarVetorAleatorio(size);
        // Cria uma cópia para possível validação posterior
        long[] arrCopy = arr.clone();
        // Cria uma instância do Merge Sort
        MergeSort sorter = new MergeSort();
        // Registra o tempo de início em nanosegundos
        long startTime = System.nanoTime();
        // Executa o algoritmo e obtém o número de iterações
        long iterations = sorter.mergeSort(arr, size);
        // Registra o tempo de fim
        long endTime = System.nanoTime();

        // Calcula o tempo decorrido convertendo para milissegundos
        double timeMs = (endTime - startTime) / 1_000_000.0;
        
        // Valida se o array foi ordenado corretamente
        boolean isOrdenado = validarOrdenacao(arr);
        
        // Exibe o número de iterações executadas
        System.out.printf("Número de iterações: %,d%n", iterations);
        // Exibe o tempo gasto em milissegundos
        System.out.printf("Tempo gasto: %.2f ms%n", timeMs);
        // Exibe o status de validação da ordenação
        System.out.printf("Status de ordenação: %s%n", isOrdenado ? "✓ CORRETO" : "✗ ERRO");
        
        // Mostra os primeiros 10 elementos ordenados como amostra
        System.out.print("Primeiros 10 elementos: ");
        for (int i = 0; i < Math.min(10, size); i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    // Executa testes do MaxVal1 (busca linear) com um tamanho específico
    // Percorre sequencialmente o array para encontrar o máximo
    private static void testarMaxVal1(int size) {
        System.out.println("TESTE COM VETOR DE TAMANHO: " + size);
        System.out.println("-".repeat(80));
        
        // Gera um array com valores aleatórios
        long[] arr = gerarVetorAleatorio(size);
        
        // Cria uma instância do MaxVal1
        MaxVal1 finder = new MaxVal1();
        
        // Registra o tempo de início
        long startTime = System.nanoTime();
        
        // Executa o algoritmo de busca linear
        long maxValue = finder.maxVal1(arr, size);
        // Obtém o número de iterações realizadas
        long iterations = finder.getIterationCount();
        
        // Registra o tempo de fim
        long endTime = System.nanoTime();
        
        // Calcula o tempo decorrido em milissegundos
        double timeMs = (endTime - startTime) / 1_000_000.0;
        
        // Valida se o valor encontrado é realmente o máximo
        boolean isCorrect = validarMaximo(arr, maxValue);
        
        // Exibe o valor máximo encontrado
        System.out.printf("Maior valor encontrado: %,d%n", maxValue);
        // Exibe o número de iterações
        System.out.printf("Número de iterações: %,d%n", iterations);
        // Exibe o tempo gasto
        System.out.printf("Tempo gasto: %.2f ms%n", timeMs);
        // Exibe o status de validação
        System.out.printf("Status da busca: %s%n", isCorrect ? "✓ CORRETO" : "✗ ERRO");
        
        // Mostra alguns elementos como amostra
        System.out.print("Primeiros 10 elementos: ");
        for (int i = 0; i < Math.min(10, size); i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    // Executa testes do MaxVal2 (divisão e conquista) com um tamanho específico
    // Divide recursivamente o array para encontrar o máximo
    private static void testarMaxVal2(int size) {
        System.out.println("TESTE COM VETOR DE TAMANHO: " + size);
        System.out.println("-".repeat(80));
        
        // Gera um array com valores aleatórios
        long[] arr = gerarVetorAleatorio(size);
        
        // Cria uma instância do MaxVal2
        MaxVal2 finder = new MaxVal2();
        
        // Registra o tempo de início
        long startTime = System.nanoTime();
        
        // Executa o algoritmo de divisão e conquista
        long maxValue = finder.findMax(arr, size);
        // Obtém o número de iterações realizadas
        long iterations = finder.getIterationCount();
        
        // Registra o tempo de fim
        long endTime = System.nanoTime();
        
        // Calcula o tempo decorrido em milissegundos
        double timeMs = (endTime - startTime) / 1_000_000.0;
        
        // Valida se o valor encontrado é realmente o máximo
        boolean isCorrect = validarMaximo(arr, maxValue);
        
        // Exibe o valor máximo encontrado
        System.out.printf("Maior valor encontrado: %,d%n", maxValue);
        // Exibe o número de iterações
        System.out.printf("Número de iterações: %,d%n", iterations);
        // Exibe o tempo gasto
        System.out.printf("Tempo gasto: %.2f ms%n", timeMs);
        // Exibe o status de validação
        System.out.printf("Status da busca: %s%n", isCorrect ? "✓ CORRETO" : "✗ ERRO");
        
        // Mostra alguns elementos como amostra
        System.out.print("Primeiros 10 elementos: ");
        for (int i = 0; i < Math.min(10, size); i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Gera um vetor com valores inteiros aleatórios
    // Usa Random com seed do tempo atual para variedade
    private static long[] gerarVetorAleatorio(int size) {
        // Cria um array do tamanho especificado
        long[] arr = new long[size];
        // Cria gerador de números aleatórios com seed diferente cada execução
        Random random = new Random(System.currentTimeMillis());
        
        // Preenche o array com valores aleatórios
        for (int i = 0; i < size; i++) {
            // Gera números aleatórios entre -1.000.000 e 1.000.000
            arr[i] = random.nextLong() % 1_000_000;
        }
        return arr;
    }

    // Valida se um array está ordenado em ordem crescente
    // Percorre verificando se cada elemento ≤ ao próximo
    private static boolean validarOrdenacao(long[] arr) {
        // Compara cada elemento com o próximo
        for (int i = 0; i < arr.length - 1; i++) {
            // Se encontrar um elemento fora de ordem, retorna falso
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        // Se passar por todos, está ordenado
        return true;
    }
    
    // Valida se um valor é realmente o máximo do array
    // Percorre todo o array procurando valor maior
    private static boolean validarMaximo(long[] arr, long maxValue) {
        // Verifica cada elemento do array
        for (long value : arr) {
            // Se encontrar um valor maior, o máximo está errado
            if (value > maxValue) {
                return false;
            }
        }
        // Se nenhum valor for maior, está correto
        return true;
    }
    
    // Gera uma string binária aleatória com n bits (0s e 1s)
    // Útil para testes de multiplicação com strings
    private static String gerarStringBinaria(int bits, Random random) {
        // Cria um StringBuilder para construir a string
        StringBuilder sb = new StringBuilder();
        // Gera cada bit aleatoriamente
        for (int i = 0; i < bits; i++) {
            // nextInt(2) retorna 0 ou 1 aleatoriamente
            sb.append(random.nextInt(2));
        }
        return sb.toString();
    }
    
    // Executa testes da multiplicação com dois números long de n bits
    // Verifica se o resultado está correto
    private static void testarMultiply(int bits) {
        System.out.println("TESTE COM NUMEROS DE " + bits + " BITS");
        System.out.println("-".repeat(80));
        
        // Cria gerador de números aleatórios
        Random random = new Random(System.currentTimeMillis());
        // Cria uma máscara para limitar os bits (ex: 15 para 4 bits = 0xF)
        long mask = (bits == 64) ? -1L : ((1L << bits) - 1);
        // Gera dois números aleatórios com no máximo n bits
        long x = random.nextLong() & mask;
        long y = random.nextLong() & mask;
        
        // Cria uma instância do algoritmo de multiplicação
        Multiply multiplier = new Multiply();
        
        // Registra tempo de início
        long startTime = System.nanoTime();
        // Executa a multiplicação
        long result = multiplier.multiply(x, y, bits);
        // Registra tempo de fim
        long endTime = System.nanoTime();
        
        // Obtém o número de iterações
        long iterations = multiplier.getIterationCount();
        // Calcula o tempo em milissegundos
        double timeMs = (endTime - startTime) / 1_000_000.0;
        
        // Calcula o resultado esperado (multiplicação nativa Java)
        long expected = x * y;
        
        // Exibe o primeiro operando
        System.out.printf("x: %,d (%d bits)%n", x, bits);
        // Exibe o segundo operando
        System.out.printf("y: %,d (%d bits)%n", y, bits);
        // Exibe o resultado obtido
        System.out.printf("Resultado: %,d%n", result);
        // Exibe o resultado esperado
        System.out.printf("Esperado: %,d%n", expected);
        // Valida se os resultados coincidem
        System.out.printf("Correto: %s%n", result == expected ? "✓ SIM" : "✗ NAO");
        // Exibe número de iterações
        System.out.printf("Número de iterações: %,d%n", iterations);
        // Exibe tempo gasto
        System.out.printf("Tempo gasto: %.2f ms%n", timeMs);
    }
    
    // Executa testes de multiplicação usando strings binárias
    // Compara resultado com cálculo usando BigInteger
    private static void testarBitMultiply(int bits) {
        System.out.println("TESTE COM STRINGS DE " + bits + " BITS");
        System.out.println("-".repeat(80));
        
        // Cria gerador de números aleatórios
        Random random = new Random(System.currentTimeMillis());
        // Gera primeira string binária aleatória
        String X = gerarStringBinaria(bits, random);
        // Gera segunda string binária aleatória
        String Y = gerarStringBinaria(bits, random);
        
        // Registra tempo de início
        long startTime = System.nanoTime();
        // Executa a multiplicação com strings
        long result = BitMultiply.multiply(X, Y);
        // Registra tempo de fim
        long endTime = System.nanoTime();
        
        // Obtém o número de iterações
        long iterations = BitMultiply.getIterationCount();
        // Calcula o tempo em milissegundos
        double timeMs = (endTime - startTime) / 1_000_000.0;
        
        // Converte X binária para BigInteger para calcular resultado esperado
        BigInteger xVal = new BigInteger(X, 2);
        // Converte Y binária para BigInteger
        BigInteger yVal = new BigInteger(Y, 2);
        // Calcula o produto verdadeiro com BigInteger
        BigInteger expectedBig = xVal.multiply(yVal);
        
        // Exibe a primeira string binária
        System.out.printf("X: %s (%d bits)%n", X, bits);
        // Exibe a segunda string binária
        System.out.printf("Y: %s (%d bits)%n", Y, bits);
        // Exibe o resultado obtido
        System.out.printf("Resultado: %,d%n", result);
        // Exibe o resultado esperado
        System.out.printf("Esperado: %s%n", expectedBig.toString());
        // Valida se o resultado está em range e é correto
        System.out.printf("Correto: %s%n", expectedBig.bitLength() <= 64 && expectedBig.longValue() == result ? "✓ SIM" : "✗ NAO");
        // Exibe número de iterações
        System.out.printf("Número de iterações: %,d%n", iterations);
        // Exibe tempo gasto
        System.out.printf("Tempo gasto: %.2f ms%n", timeMs);
    }
}
