# VISUALIZAÇÃO PRÁTICA - Merge Sort em Ação

## Exemplo Prático Completo: Ordenando [38, 27, 43, 3, 9, 82, 10]

```
ESTADO INICIAL: [38, 27, 43, 3, 9, 82, 10]

╔══════════════════════════════════════════════════════════════╗
║  FASE 1: DIVIDIR (Divide em metades até 1 elemento)         ║
╚══════════════════════════════════════════════════════════════╝

Nível 0:  [38, 27, 43, 3, 9, 82, 10]
          └──────────────┬──────────────┘
          
Nível 1:  [38, 27, 43]  |  [3, 9, 82, 10]
          └──────┬──────┘   └────────┬───────┘
          
Nível 2:  [38, 27] [43]  |  [3, 9] [82, 10]
          └──┬──┘ └┘      └──┬──┘   └──┬────┘
          
Nível 3:  [38] [27] [43]  |  [3] [9] [82] [10]
          └┘   └┘   └┘      └┘   └┘   └┘   └┘


╔══════════════════════════════════════════════════════════════╗
║  FASE 2: CONQUISTAR + COMBINAR (Merge para cima)             ║
╚══════════════════════════════════════════════════════════════╝

Nível 3:  [38] [27] [43] | [3] [9] [82] [10]
          ↓ MERGE ↓       ↓ MERGE ↓ ↓ MERGE ↓
          
Nível 2:  [27, 38] [43]  |  [3, 9] [10, 82]
          └────┬────┘     └────┬────┘
          ↓ MERGE ↓           ↓ MERGE ↓
          
Nível 1:  [27, 38, 43]    |    [3, 9, 10, 82]
          └──────┬────────────────┬──────┘
          ↓      MERGE FINAL       ↓
          
Nível 0:  [3, 9, 10, 27, 38, 43, 82] ✓ ORDENADO!
```

---

## Operação MERGE Detalhada

Exemplo: Mesclar [27, 38, 43] com [3, 9, 10, 82]

```
Arrays de entrada:
Left:  [27, 38, 43]
Right: [3, 9, 10, 82]

Processo de comparação:

Passo 1:  Comparar 27 vs 3  → 3 é menor  → Resultado: [3]
          Left:  [27, 38, 43]
          Right: [9, 10, 82]

Passo 2:  Comparar 27 vs 9  → 9 é menor  → Resultado: [3, 9]
          Left:  [27, 38, 43]
          Right: [10, 82]

Passo 3:  Comparar 27 vs 10 → 10 é menor → Resultado: [3, 9, 10]
          Left:  [27, 38, 43]
          Right: [82]

Passo 4:  Comparar 27 vs 82 → 27 é menor → Resultado: [3, 9, 10, 27]
          Left:  [38, 43]
          Right: [82]

Passo 5:  Comparar 38 vs 82 → 38 é menor → Resultado: [3, 9, 10, 27, 38]
          Left:  [43]
          Right: [82]

Passo 6:  Comparar 43 vs 82 → 43 é menor → Resultado: [3, 9, 10, 27, 38, 43]
          Left:  []
          Right: [82]

Passo 7:  Left vazio, copia restante → Resultado: [3, 9, 10, 27, 38, 43, 82]

RESULTADO: [3, 9, 10, 27, 38, 43, 82] ✓
```

---

## Contagem de Operações (Iterações)

Para o array [38, 27, 43, 3, 9, 82, 10] de 7 elementos:

```
FASE DE DIVISÃO:
├─ Chamada 1: mergeSortRecursive(arr, 0, 6)    iterationCount = 1
├─ Chamada 2: mergeSortRecursive(arr, 0, 3)    iterationCount = 2
├─ Chamada 3: mergeSortRecursive(arr, 0, 1)    iterationCount = 3
├─ Chamada 4: mergeSortRecursive(arr, 0, 0)    iterationCount = 4 (CASO BASE)
├─ Chamada 5: mergeSortRecursive(arr, 1, 1)    iterationCount = 5 (CASO BASE)
├─ Merge(0, 0, 1): 2 cópias + 2 comparações    iterationCount = 9
├─ Chamada 6: mergeSortRecursive(arr, 2, 3)    iterationCount = 10
├─ Chamada 7: mergeSortRecursive(arr, 2, 2)    iterationCount = 11 (CASO BASE)
├─ Chamada 8: mergeSortRecursive(arr, 3, 3)    iterationCount = 12 (CASO BASE)
├─ Merge(2, 2, 3): 2 cópias + 2 comparações    iterationCount = 16
├─ Merge(0, 1, 3): 4 cópias + 4 comparações    iterationCount = 24
├─ Chamada 9: mergeSortRecursive(arr, 4, 6)    iterationCount = 25
├─ Chamada 10: mergeSortRecursive(arr, 4, 5)   iterationCount = 26
├─ Chamada 11: mergeSortRecursive(arr, 4, 4)   iterationCount = 27 (CASO BASE)
├─ Chamada 12: mergeSortRecursive(arr, 5, 5)   iterationCount = 28 (CASO BASE)
├─ Merge(4, 4, 5): 2 cópias + 2 comparações    iterationCount = 32
├─ Chamada 13: mergeSortRecursive(arr, 6, 6)   iterationCount = 33 (CASO BASE)
├─ Merge(5, 5, 6): 2 cópias + 2 comparações    iterationCount = 37
├─ Merge(4, 5, 6): 3 cópias + 3 comparações    iterationCount = 43
└─ Merge(0, 3, 6): 7 cópias + 7 comparações    iterationCount = 57

TOTAL: iterationCount = 57
```

---

## Comparação de Tamanhos Esperados

```
╔════════════════════════════════════════════════════════════════════════╗
║                    ESTIMATIVA DE ITERAÇÕES                             ║
╠════════════════════════════════════════════════════════════════════════╣
║                                                                        ║
║  Tamanho    │  Níveis  │  Iterações Estimadas  │  Tempo Esperado      ║
║─────────────┼──────────┼──────────────────────┼──────────────────────║
║             │          │                      │                      ║
║  32         │  5       │  200 - 400           │  < 1 ms              ║
║  2.048      │  11      │  30.000 - 50.000    │  5 - 15 ms           ║
║  1.048.576  │  20      │  40.000.000+         │  200 - 500 ms        ║
║             │          │  (40 milhões)        │                      ║
║                                                                        ║
╚════════════════════════════════════════════════════════════════════════╝
```

---

## Análise Matemática

Para um array de tamanho n:

```
Número de níveis de recursão: log₂(n)

Operações por nível:
├─ Comparações: O(n)
├─ Cópias: O(n)
└─ Total: O(n)

Complexidade total: O(n) × log₂(n) = O(n log n)


EXEMPLOS:

n = 32:
   Níveis: log₂(32) = 5
   Ops/nível: ~32
   Total: 32 × 5 = 160

n = 2.048:
   Níveis: log₂(2.048) ≈ 11
   Ops/nível: ~2.048
   Total: 2.048 × 11 = 22.528

n = 1.048.576:
   Níveis: log₂(1.048.576) = 20
   Ops/nível: ~1.048.576
   Total: 1.048.576 × 20 = 20.971.520
```

---

## Performance Relativa

Se um arranjo de 32 elementos leva 1 unidade de tempo:

```
Tamanho    │  Esperado    │  Observado Esperado
───────────┼──────────────┼──────────────────
32         │     1x       │     1 ms
2.048      │    112x      │    112 ms ✗ TOO MUCH
           │              │
           │  CORRETO:    │
           │   140x       │    140 comparações (2048/32 = 64 vezes maior)
           │              │       × log₂(2048)/log₂(32) = 11/5 = 2.2x
           │              │       = 64 × 2.2 = 140x ✓
───────────┼──────────────┼──────────────────
1.048.576  │ 250.000x     │   250 segundos ✗
           │              │
           │  CORRETO:    │
           │   ~20.000x   │   20 ms/microsegundo
           │              │   (1M/32) × (20/5) = 32768 × 4 = 131072x
           │              │   Hmm... aproximadamente 20.000x em termos
           │              │   de operações simples
```

---

## Pseudocódigo com Contadores

```
MERGE-SORT-COM-CONTADOR(A, left, right):
    iterations++
    
    IF left >= right
        RETURN  // Caso base
    
    mid ← (left + right) / 2
    
    MERGE-SORT-COM-CONTADOR(A, left, mid)      // Esquerda
    MERGE-SORT-COM-CONTADOR(A, mid+1, right)   // Direita
    
    MERGE-COM-CONTADOR(A, left, mid, right)    // Combina


MERGE-COM-CONTADOR(A, left, mid, right):
    leftLen ← mid - left + 1
    rightLen ← right - mid
    
    // Cópias para arrays temporários
    FOR i ← 0 TO leftLen-1
        iterations++
        leftArray[i] ← A[left + i]
    
    FOR j ← 0 TO rightLen-1
        iterations++
        rightArray[j] ← A[mid + 1 + j]
    
    // Merge
    i ← 0; j ← 0; k ← left
    
    WHILE i < leftLen AND j < rightLen
        iterations++
        IF leftArray[i] ≤ rightArray[j]
            A[k++] ← leftArray[i++]
        ELSE
            A[k++] ← rightArray[j++]
    
    // Cópias finais
    WHILE i < leftLen
        iterations++
        A[k++] ← leftArray[i++]
    
    WHILE j < rightLen
        iterations++
        A[k++] ← rightArray[j++]
```
