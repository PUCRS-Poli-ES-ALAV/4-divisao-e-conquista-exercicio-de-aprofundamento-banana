# Resumo da Implementação - Merge Sort

## 📋 Arquivos Criados/Modificados

### 1. **MergeSort.java**
   - Implementação completa do algoritmo Merge Sort
   - Contagem de iterações durante execução
   - Validação da ordenação

### 2. **App.java**
   - Testes com três tamanhos: 32, 2.048 e 1.048.576
   - Geração de dados aleatórios
   - Medição de tempo em nanosegundos
   - Validação de ordenação para cada teste

### 3. **MERGE_SORT_EXPLICACAO.md**
   - Explicação detalhada do algoritmo
   - Análise de complexidade matemática
   - Descrição passo a passo da implementação
   - O que esperar dos resultados

### 4. **VISUALIZACAO_MERGE_SORT.md**
   - Exemplo visual com array [38, 27, 43, 3, 9, 82, 10]
   - Processo completo de divisão e conquista
   - Detalhamento da operação merge
   - Contagem de operações
   - Análise comparativa de tamanhos

---

## 🚀 Como Executar

### Compilar o projeto:
```bash
mvn clean compile
```

### Executar os testes:
```bash
mvn exec:java -Dexec.mainClass=br.pucrs.App
```

---

## 📊 Estrutura do Merge Sort Implementado

```
MergeSort
├── mergeSort(long[] arr, int n): long
│   └── Ponto de entrada - inicia a ordenação
│
└── mergeSortRecursive(long[] arr, int left, int right)
    ├── Caso Base: left >= right
    ├── Dividir: mid = (left + right) / 2
    ├── Conquistar: 
    │   ├─ mergeSortRecursive(left, mid)
    │   └─ mergeSortRecursive(mid+1, right)
    └── Combinar: merge(left, mid, right)
        ├── Copiar elementos para arrays temporários
        ├── Comparar e mesclar
        └── Copiar elementos restantes
```

---

## 📈 Esperado na Execução

### Tamanho 32:
```
✓ Iterações: ~200-400
✓ Tempo: < 1 ms
✓ Status: CORRETO (array ordenado)
```

### Tamanho 2.048:
```
✓ Iterações: ~30.000-50.000
✓ Tempo: ~5-15 ms
✓ Status: CORRETO
```

### Tamanho 1.048.576:
```
✓ Iterações: ~40.000.000+
✓ Tempo: ~200-500 ms
✓ Status: CORRETO
```

---

## 🔑 Conceitos-Chave Implementados

1. **Divisão e Conquista**
   - Problema dividido em subproblemas menores
   - Subproblemas resolvidos recursivamente
   - Soluções combinadas para resolver o original

2. **Contagem de Iterações**
   - Contador incrementado em cada operação significativa
   - Chamadas recursivas
   - Comparações
   - Cópias

3. **Medição de Performance**
   - Tempo em nanosegundos
   - Cálculo em milissegundos para legibilidade
   - Validação de corretude

---

## 💡 Diferenciais da Implementação

✅ **Contagem precisa**: Todas as operações contadas
✅ **Testes validados**: Verifica se está realmente ordenado
✅ **Escalabilidade**: Testa desde pequenos até 1 milhão de elementos
✅ **Documentação**: Inclui exemplos visuais e matemática

---

## 🎯 Próximos Passos (Conforme Exercício)

O exercício solicitava também:
- [ ] Algoritmo `maxVal1()` (linear, sem divisão-e-conquista)
- [ ] Algoritmo `maxVal2()` (com divisão-e-conquista)
- [ ] Algoritmo de Multiplicação Inteira (n-bits)
- [ ] Tabela comparativa com todos os algoritmos

Estes podem ser implementados seguindo o mesmo padrão:
1. Criar classe com o algoritmo
2. Adicionar contagem de iterações
3. Testar com tamanhos específicos
4. Medir tempo de execução
5. Compilar resultados em tabela

---

## 📝 Notas Técnicas

- **Linguagem**: Java 17
- **Framework**: Maven para build
- **Precisão de Tempo**: Nanosegundos (System.nanoTime())
- **Validação**: Verificação O(n) de ordenação
- **Dados**: Números aleatórios long entre -1.000.000 e 1.000.000
