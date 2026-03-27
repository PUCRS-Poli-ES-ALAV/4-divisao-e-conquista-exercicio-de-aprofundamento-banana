package br.pucrs;

// Implementa multiplicação de números representados como strings binárias
// Usa divisão e conquista aplicada aos dígitos binários
public class BitMultiply {
    // Armazena o número de iterações realizadas
    private static long iterationCount;

    // Multiplica duas strings binárias (sequências de 0 e 1)
    // Retorna o resultado como long
    public static long multiply(String X, String Y) {
        // Reseta o contador antes de iniciar
        iterationCount = 0;

        // Encontra o comprimento máximo entre as duas strings
        int n = Math.max(X.length(), Y.length());
        // Adiciona zeros à esquerda em X para igualar comprimentos
        X = String.format("%" + n + "s", X).replace(' ', '0');
        // Adiciona zeros à esquerda em Y para igualar comprimentos
        Y = String.format("%" + n + "s", Y).replace(' ', '0');

        // Inicia a multiplicação recursiva
        return multiplyHelper(X, Y, n);
    }

    // Implementação recursiva da multiplicação usando divisão e conquista
    // X e Y são strings binárias com n dígitos cada
    private static long multiplyHelper(String X, String Y, int n) {
        // Incrementa contador para cada chamada recursiva
        iterationCount++;
        // Caso base: quando há apenas 1 dígito binário
        if (n == 1) {
            // Converte o caractere '0' ou '1' em inteiro e multiplica
            return (X.charAt(0) - '0') * (Y.charAt(0) - '0');
        } else {
            // Calcula m = ceil(n/2) para dividir as strings em duas partes
            int m = (n + 1) / 2;
            // Extrai a parte alta de X (primeiros n-m caracteres)
            String a = X.substring(0, n - m);
            // Extrai a parte baixa de X (últimos m caracteres)
            String b = X.substring(n - m);
            // Extrai a parte alta de Y
            String c = Y.substring(0, n - m);
            // Extrai a parte baixa de Y
            String d = Y.substring(n - m);

            // Recursivamente multiplica as partes altas: a*c
            long e = multiplyHelper(a, c, m);
            // Recursivamente multiplica as partes baixas: b*d
            long f = multiplyHelper(b, d, m);
            // Recursivamente multiplica: b*c
            long g = multiplyHelper(b, c, m);
            // Recursivamente multiplica: a*d
            long h = multiplyHelper(a, d, m);

            // Calcula 2^(2m) para deslocar os produtos
            long pow2m = 1L << (2 * m);
            // Calcula 2^m * (g + h)
            long powM_gh = (1L << m) * (g + h);
            // Retorna a combinação: 2^(2m)*e + 2^m*(g+h) + f
            return pow2m * e + powM_gh + f;
        }
    }

    // Retorna o total de iterações da última execução
    public static long getIterationCount() {
        return iterationCount;
    }
}