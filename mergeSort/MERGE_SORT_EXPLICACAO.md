# Desenvolvimento do Merge Sort - Explicação Passo a Passo

## 1. VISÃO GERAL DO ALGORITMO

O **Merge Sort** é um algoritmo de ordenação baseado no paradigma **Divisão e Conquista**. Ele funciona em três etapas:

1. **Dividir**: Divide o array em duas metades
2. **Conquistar**: Ordena recursivamente cada metade
3. **Combinar**: Mescla as duas metades ordenadas em um array final ordenado

### Complexidade:
- **Tempo**: O(n log n) em todos os casos (melhor, médio e pior)
- **Espaço**: O(n) para os arrays temporários usados no merge

---

## 2. ESTRUTURA IMPLEMENTADA

### Arquivo: MergeSort.java

#### Análise da classe:

```java
public class MergeSort {
    private long iterationCount;
```
- Variável para contar todas as operações realizadas durante a execução

#### Método principal: mergeSortRecursive()

```java
private void mergeSortRecursive(long[] arr, int left, int right) {
    iterationCount++;  // Conta cada chamada
    
    if (left >= right) {  // CASO BASE
        return;
    }
    
    int mid = (left + right) / 2;  // DIVIDIR
    
    mergeSortRecursive(arr, left, mid);      // CONQUISTAR (esquerda)
    mergeSortRecursive(arr, mid + 1, right); // CONQUISTAR (direita)
    
    merge(arr, left, mid, right);  // COMBINAR
}
```

**Explicação do fluxo:**

1. **Iteração**: Incrementamos o contador a cada chamada recursiva
2. **Caso Base**: Se `left >= right`, o array tem 1 elemento (ou 0), então já está "ordenado"
3. **Dividir**: Calculamos o ponto médio
4. **Conquistar**: Chamamos recursivamente para ordenar cada metade
5. **Combinar**: Mesclamos as duas metades usando a função `merge()`

#### Método merge():

O método `merge()` é a operação mais custosa:

```java
private void merge(long[] arr, int left, int mid, int right) {
    // Criar arrays temporários para armazenar as metades
    long[] leftArr = new long[mid - left + 1];
    long[] rightArr = new long[right - mid];
    
    // Copiar dados para os arrays temporários
    for (int i = 0; i < n1; i++) {
        iterationCount++;
        leftArr[i] = arr[left + i];
    }
    
    // Mesclar comparando elementos
    while (i < n1 && j < n2) {
        iterationCount++;
        if (leftArr[i] <= rightArr[j]) {
            arr[k++] = leftArr[i++];
        } else {
            arr[k++] = rightArr[j++];
        }
    }
    
    // Copiar elementos restantes
    // ...
}
```

**O que acontece:**
1. Criamos dois arrays temporários para armazenar as duas metades
2. Comparamos elementos de cada metade
3. Escolhemos o menor e colocamos no array original
4. Copiamos o restante

---

## 3. ARQUIVO App.java - OS TESTES

Implementamos testes para **3 tamanhos diferentes**:
- 32 elementos
- 2.048 elementos
- 1.048.576 elementos (1 milhão)

### Para cada teste, medimos:

#### a) **Número de Iterações**
Contamos TODAS as operações:
- Cada chamada recursiva
- Cada comparação e troca
- Cada cópia de elemento

#### b) **Tempo de Execução**
```java
long startTime = System.nanoTime();
long iterations = sorter.mergeSort(arr, size);
long endTime = System.nanoTime();
double timeMs = (endTime - startTime) / 1_000_000.0;
```

Usamos `nanoTime()` para precisão máxima

#### c) **Validação**
Verificamos se o array ficou realmente ordenado:
```java
private static boolean validarOrdenacao(long[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
        if (arr[i] > arr[i + 1]) {
            return false;
        }
    }
    return true;
}
```

---

## 4. EXEMPLO DE EXECUÇÃO

Imagine um array pequeno: `[5, 2, 8, 1, 9]`

### Passo 1: DIVIDIR
```
       [5, 2, 8, 1, 9]
           /         \
       [5, 2]      [8, 1, 9]
       /    \       /    \
    [5]  [2]      [8]   [1, 9]
                    /  \
                  [1]  [9]
```

### Passo 2: CONQUISTAR (Ordenação de 1 elemento = trivial)
```
[5]  [2]  [8]  [1]  [9]  ← Todos já "ordenados"
```

### Passo 3: COMBINAR (Merge para cima)
```
[5] e [2] → [2, 5]
[1] e [9] → [1, 9]
[8] e [1, 9] 
    ↓
Comparar: 8 vs 1 → 1 é menor
Comparar: 8 vs 9 → 8 é menor
Resultado: [1, 8, 9]

[2, 5] e [1, 8, 9] → [1, 2, 5, 8, 9] ✓
```

---

## 5. ANÁLISE DE COMPLEXIDADE TEÓRICA

### Número de Divisões:
- Para n elementos, fazemos log₂(n) níveis de divisão
- Com n = 1.048.576 = 2²⁰, temos 20 níveis

### Operações por Nível:
- Cada nível realiza O(n) comparações e cópias
- Total: log₂(n) × n operações

### Com n = 1.048.576:
```
Operações esperadas ≈ 1.048.576 × 20 = 20.971.520
Será um número ligeiramente maior por causa das cópias adicionais
```

---

## 6. O QUE ESPERAR DOS RESULTADOS

### Tamanho 32:
- Iterações: ~200-400
- Tempo: < 1 ms
- Execução: Quase instantânea

### Tamanho 2.048:
- Iterações: ~30.000-50.000
- Tempo: ~5-15 ms
- Execução: Rápida

### Tamanho 1.048.576:
- Iterações: ~40.000.000 (quarenta milhões)
- Tempo: ~200-500 ms (dependendo do processador)
- Execução: Notavelmente mais rápida que um algoritmo O(n²)

---

## 7. VANTAGENS DO MERGE SORT

✓ **Complexidade garantida**: Sempre O(n log n)
✓ **Estável**: Mantém ordem relativa de elementos iguais
✓ **Previsível**: Tempo não varia com dados de entrada
✓ **Divide e Conquista**: Exemplo clássico do paradigma

## Desvantagens

✗ **Espaço extra**: Usa O(n) de memória adicional
✗ **Comparações**: Sempre realiza comparações, mesmo com dados quase ordenados
✗ **Cópia**: Realiza muitas cópias de dados

---

## 8. COMPILAÇÃO E EXECUÇÃO

Para compilar:
```bash
mvn clean compile
```

Para executar:
```bash
mvn exec:java -Dexec.mainClass=br.pucrs.App
```

---

## 9. RESUMO

A implementação completa de Merge Sort foi criada com:

1. **MergeSort.java**: Classe com algoritmo completo
   - Método `mergeSort()`: Interface pública
   - Método `mergeSortRecursive()`: Implementação recursiva
   - Método `merge()`: Operação de combinação

2. **App.java**: Testes abrangentes
   - 3 tamanhos de entrada (32, 2K, 1M)
   - Contagem de iterações
   - Medição de tempo em nanosegundos
   - Validação de ordenação

O algoritmo demonstra como dividir problemas grandes em partes menores
torna a resolução muito mais eficiente!
