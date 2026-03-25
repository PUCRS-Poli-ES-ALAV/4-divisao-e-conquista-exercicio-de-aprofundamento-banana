# Desenvolvimento do MaxVal1 - Algoritmo Linear (Sem Divisão e Conquista)

## 📋 VISÃO GERAL DO ALGORITMO

O **MaxVal1** é um algoritmo simples que encontra o maior valor em um vetor usando uma **abordagem linear** (não recursiva). Ele percorre o array uma única vez, mantendo o maior valor encontrado até o momento.

### Pseudocódigo Original:
```java
long maxVal1(long A[], int n) {
    long max = A[0];
    for (int i = 1; i < n; i++) {
        if( A[i] > max )
           max = A[i];
    }
    return max;
}
```

---

## 🔍 ANÁLISE PASSO A PASSO

### **1. INICIALIZAÇÃO**
```java
long max = A[0];  // Começa assumindo que o primeiro elemento é o maior
iterationCount++; // Conta esta operação
```

**Por que começar com A[0]?**
- É o primeiro elemento disponível
- Garante que temos pelo menos um valor para comparar
- Se o array tiver apenas 1 elemento, este já é o máximo

### **2. PERCURSO LINEAR**
```java
for (int i = 1; i < n; i++) {  // Começa do índice 1 (segundo elemento)
    iterationCount++;          // Conta cada iteração do loop
    
    if (A[i] > max) {           // Compara com o máximo atual
        max = A[i];             // Se for maior, atualiza
        iterationCount++;       // Conta a atualização
    }
}
```

**Lógica:**
- Percorre do segundo elemento até o último
- Para cada elemento, compara com o `max` atual
- Se encontrar um maior, atualiza o `max`

### **3. RETORNO DO RESULTADO**
```java
return max;  // Retorna o maior valor encontrado
```

---

## 📊 EXEMPLO DETALHADO

### Array: [5, 8, 2, 9, 1, 7]

| Passo | i | A[i] | max atual | Comparação | Ação | Iterações |
|-------|---|------|-----------|------------|-------|-----------|
| **Inicial** | - | - | 5 | - | max = A[0] | 1 |
| **1** | 1 | 8 | 5 | 8 > 5? | ✓ SIM → max = 8 | 3 (loop + if + atrib) |
| **2** | 2 | 2 | 8 | 2 > 8? | ✗ NÃO | 2 (loop + if) |
| **3** | 3 | 9 | 8 | 9 > 8? | ✓ SIM → max = 9 | 3 (loop + if + atrib) |
| **4** | 4 | 1 | 9 | 1 > 9? | ✗ NÃO | 2 (loop + if) |
| **5** | 5 | 7 | 9 | 7 > 9? | ✗ NÃO | 2 (loop + if) |

**Resultado:** 9 (correto!)
**Total de iterações:** 1 (inicial) + 3 + 2 + 3 + 2 + 2 = **13 iterações**

---

## 🧮 CONTAGEM DE ITERAÇÕES

### **Cenário Ideal (Elemento máximo é o primeiro):**
- Inicialização: 1 iteração
- Loop: n-1 iterações × 2 operações cada = 2(n-1) iterações
- **Total:** 1 + 2(n-1) = **2n - 1**

### **Cenário Pior (Elemento máximo é o último):**
- Inicialização: 1 iteração
- Loop: n-1 iterações × 3 operações cada = 3(n-1) iterações
- **Total:** 1 + 3(n-1) = **3n - 2**

### **Cenário Médio:**
- Depende da posição do máximo no array
- Geralmente entre 2n-1 e 3n-2 iterações

---

## ⏱️ COMPLEXIDADE

### **Tempo: O(n)**
- **Melhor caso:** O(n) - sempre percorre todo o array
- **Caso médio:** O(n) - sempre percorre todo o array
- **Pior caso:** O(n) - sempre percorre todo o array

**Por que sempre O(n)?**
- O algoritmo **sempre** visita cada elemento exatamente uma vez
- Não há atalhos ou otimizações que permitam parar antes
- Mesmo se o máximo estiver na primeira posição, continua verificando os outros

### **Espaço: O(1)**
- Usa apenas uma variável `max` adicional
- Não cria arrays temporários ou estruturas extras

---

## 🔄 COMPARAÇÃO COM DIVISÃO E CONQUISTA

### **MaxVal1 (Linear):**
```java
// Simples, direto, eficiente
long max = A[0];
for (int i = 1; i < n; i++) {
    if (A[i] > max) max = A[i];
}
```

### **MaxVal2 (Divisão e Conquista - do exercício 3):**
```java
// Recursivo, mais complexo
long maxVal2(long A[], int init, int end) {
    if (end - init <= 1)
        return max(A[init], A[end]);
    else {
        int m = (init + end)/2;
        long v1 = maxVal2(A, init, m);
        long v2 = maxVal2(A, m+1, end);
        return max(v1, v2);
    }
}
```

### **Comparação:**

| Aspecto | MaxVal1 (Linear) | MaxVal2 (Divisão e Conquista) |
|---------|------------------|-------------------------------|
| **Complexidade** | O(n) | O(n) |
| **Implementação** | Simples | Recursiva |
| **Chamadas** | 1 função | Múltiplas chamadas recursivas |
| **Legibilidade** | Alta | Média |
| **Performance** | Excelente | Boa (overhead recursão) |

---

## 📈 RESULTADOS ESPERADOS DOS TESTES

### **Tamanho 32:**
```
✓ Iterações: ~64-96 (2n-1 até 3n-2)
✓ Tempo: < 0.1 ms
✓ Status: CORRETO
```

### **Tamanho 2.048:**
```
✓ Iterações: ~4.096-6.144
✓ Tempo: ~0.5-1 ms
✓ Status: CORRETO
```

### **Tamanho 1.048.576:**
```
✓ Iterações: ~2.097.152-3.145.728
✓ Tempo: ~50-100 ms
✓ Status: CORRETO
```

---

## 💡 VANTAGENS E DESVANTAGENS

### ✅ **Vantagens:**
1. **Simples e direto** - Fácil de entender e implementar
2. **Eficiente** - O(n) é ótimo para este problema
3. **Sem overhead** - Não usa recursão ou estruturas extras
4. **Previsível** - Tempo constante independente dos dados

### ❌ **Desvantagens:**
1. **Sempre O(n)** - Mesmo se souber onde está o máximo
2. **Não paralelizável** - Difícil dividir em tarefas independentes
3. **Sequencial** - Deve processar elementos em ordem

---

## 🔧 IMPLEMENTAÇÃO TÉCNICA

### **Classe MaxVal1:**
```java
public class MaxVal1 {
    private long iterationCount;
    
    public long maxVal1(long[] A, int n) {
        iterationCount = 0;
        
        if (n == 0) {
            throw new IllegalArgumentException("Array vazio");
        }
        
        long max = A[0];
        iterationCount++; // Inicialização
        
        for (int i = 1; i < n; i++) {
            iterationCount++; // Iteração do loop
            
            if (A[i] > max) {
                max = A[i];
                iterationCount++; // Atribuição
            }
        }
        
        return max;
    }
}
```

### **Tratamento de Casos Especiais:**
- **Array vazio:** Lança `IllegalArgumentException`
- **Array com 1 elemento:** Retorna diretamente A[0]
- **Valores negativos:** Funciona normalmente (compara corretamente)

---

## 🎯 CONCLUSÃO

O **MaxVal1** é um exemplo perfeito de algoritmo **linear simples** que resolve o problema de encontrar o máximo de forma eficiente. Embora tenha a mesma complexidade O(n) do algoritmo de divisão e conquista, é:

- **Mais simples** de implementar
- **Mais eficiente** (sem overhead de recursão)
- **Mais legível** para programadores
- **Mais adequado** quando não há necessidade de paralelização

Este algoritmo demonstra que nem sempre a divisão e conquista é a melhor abordagem - às vezes, uma solução direta e simples é superior! 🚀