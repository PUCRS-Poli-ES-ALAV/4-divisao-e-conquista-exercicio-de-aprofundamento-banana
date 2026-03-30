# Resultados dos Testes

## Tabela de Resultados
| Algoritmo | Tamanho | Iterações | Tempo (ms) | Correto |
|-----------|---------|-----------|-----------|---------|
| Merge Sort | 32 | 383 | 0.05 | ✓ |
| | 2048 | 49,151 | 4.47 | ✓ |
| | 1.048.576 | 44,040,191 | 317.08 | ✓ |

| MaxVal1 (Linear) | 32 | 36 | 0.01 | ✓ |
| | 2048 | 2,056 | 2.92 | ✓ |
| | 1.048.576 | 1,048,587 | 9.80 | ✓ |

| MaxVal2 (D&C) | 32 | 31 | 0.02 | ✓ |
| | 2048 | 2,047 | 0.52 | ✓ |
| | 1.048.576 | 1,048,575 | 6.13 | ✓ |

| Multiplicação | 4 bits | 21 | 0.01 | ✓ |
| | 16 bits | 341 | 0.05 | ✓ |
| | 64 bits | 5,461 | 3.18 | ✗ |

| Multiplicação (Strings) | 4 bits | 21 | 1.17 | ✓ |
| | 16 bits | 341 | 0.22 | ✓ |
| | 64 bits | 5,461 | 3.18 | ✗ |

## Observações
- **Merge Sort**: 
Crescimento quadrático em iterações, todos os testes corretos

- **MaxVal1 vs MaxVal2**:
 Ambos encontram o máximo corretamente. MaxVal2 é mais rápido para grandes vetores

- **Multiplicação**:
 Funciona corretamente para 4 e 16 bits. Overflow em 64 bits (produto > Long.MAX_VALUE)

- **Strings**: 
Maior overhead de processamento, mas mesma lógica de algoritmo

## Como Executar
mvn compile
mvn exec:java -Dexec.mainClass="br.pucrs.App"

