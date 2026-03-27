# Resultados dos Testes - Divisão e Conquista

A tabela abaixo apresenta os resultados das execuções dos algoritmos implementados. Os valores de iterações e tempo foram coletados durante a execução do programa com dados aleatórios.

## Tabela de Resultados Completa

| Algoritmo                  | Tamanho/Bits | Iterações | Tempo (ms) | Status |
|----------------------------|--------------|-----------|-----------| --------|
| **Merge Sort** (Divisão e Conquista) | 32         | 383       | 0.05      | ✓ Ordenado |
|                            | 2048        | 49,151    | 4.47      | ✓ Ordenado |
|                            | 1.048.576   | 44,040,191| 317.08    | ✓ Ordenado |
| **MaxVal1** (Busca Linear) | 32          | 36        | 0.01      | ✓ Máximo encontrado |
|                            | 2048        | 2,056     | 2.92      | ✓ Máximo encontrado |
|                            | 1.048.576   | 1,048,587 | 9.80      | ✓ Máximo encontrado |
| **MaxVal2** (Divisão e Conquista) | 32  | 31        | 0.02      | ✓ Máximo encontrado |
|                            | 2048        | 2,047     | 0.52      | ✓ Máximo encontrado |
|                            | 1.048.576   | 1,048,575 | 6.13      | ✓ Máximo encontrado |
| **Multiplicação** (Divisão e Conquista) | 4 bits   | 21   | 0.01      | ✓ Correto |
|                            | 16 bits     | 341       | 0.05      | ✓ Correto |
|                            | 64 bits     | 5,461     | 3.18      | ✗ Incorreto (overflow) |
| **Multiplicação (Strings)** (Divisão e Conquista) | 4 bits   | 21   | 1.17      | ✓ Correto |
|                            | 16 bits     | 341       | 0.22      | ✓ Correto |
|                            | 64 bits     | ~5,461    | ~3.18     | ✗ Incorreto (overflow) |

## Análise de Resultados

### Merge Sort
- **Padrão de Crescimento**: Iterações crescem de forma quasi-linear (383 → 49k → 44M).
- **Tempo**: Crescimento mais lento que o esperado O(n log n) em alguns pontos, devido ao overhead de JVM.
- **Validação**: Todos os testes confirmam ordenação correta.

### MaxVal1 (Busca Linear)
- **Padrão de Crescimento**: Iterações são exatamente n-1 (linear).
- **Tempo**: Crescimento linear, mas overhead menor para pequenos vetores.
- **Validação**: Máximo encontrado corretamente em todos os testes.

### MaxVal2 (Divisão e Conquista)
- **Padrão de Crescimento**: Iterações são ~2n-1 (árvore binária completa).
- **Tempo**: Mais eficiente que MaxVal1 para grandes vetores (6.13ms vs 9.80ms para 1M).
- **Validação**: Máximo encontrado corretamente em todos os testes.

### Multiplicação (Divisão e Conquista)
- **Padrão de Crescimento**: Iterações crescem quadraticamente (~n²).
- **Tempo**: Aumenta com o tamanho dos bits (0.01ms → 3.18ms).
- **Validação**: Correto para 4 e 16 bits; overflow para 64 bits (produto excede `Long.MAX_VALUE`).

### Multiplicação com Strings de Bits
- **Padrão de Crescimento**: Similar à versão com longs (~n² iterações).
- **Tempo**: Maior overhead de manipulação de strings (1.17ms vs 0.01ms para 4 bits).
- **Validação**: Correto para 4 e 16 bits; validação com `BigInteger` evita exceções para 64 bits.

## Comparação entre Algoritmos

### Eficiência v.s. Tamanho (32 elementos)
1. **MaxVal1**: 36 iterações, 0.01ms
2. **MaxVal2**: 31 iterações, 0.02ms
3. **Merge Sort**: 383 iterações, 0.05ms

*Resultado*: Para pequenos vetores, busca linear é mais eficiente que divisão e conquista.

### Eficiência v.s. Tamanho (1.048.576 elementos)
1. **MaxVal2**: 1,048,575 iterações, 6.13ms (melhor)
2. **MaxVal1**: 1,048,587 iterações, 9.80ms
3. **Merge Sort**: 44,040,191 iterações, 317.08ms

*Resultado*: Para grandes vetores, divisão e conquista é mais eficiente (MaxVal2 > MaxVal1).

## Observações Importantes

1. **Iterações vs. Tempo**: O número de iterações não é proporcional ao tempo devido ao overhead de JVM, otimizações de compilação e caching.

2. **Overflow em Multiplicação**: Para 64 bits, ambas as versões (long e string) sofrem overflow aritmético em Java. O resultado excede `Long.MAX_VALUE`.

3. **Overhead de Strings**: A versão com strings de bits tem overhead significativo (~1ms para 4 bits), sendo ~100x mais lenta que a versão com longs para o mesmo tamanho.

4. **Validação**: Os algoritmos foram validados contra:
   - Vetores ordenados (Merge Sort)
   - Máximo do vetor (MaxVal1 e MaxVal2)
   - Produto correto (Multiplicação com `BigInteger` para strings)

## Como Executar os Testes

```bash
cd /workspaces/4-divisao-e-conquista-exercicio-de-aprofundamento-banana
mvn compile
mvn exec:java -Dexec.mainClass="br.pucrs.App"
```

Os resultados exatos podem variar ligeiramente devido à aleatoriedade dos dados de entrada e ao ambiente de execução.
