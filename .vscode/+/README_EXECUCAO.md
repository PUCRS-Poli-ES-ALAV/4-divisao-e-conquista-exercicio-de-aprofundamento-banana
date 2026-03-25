# Como Executar o Projeto - Divisão e Conquista

## 🚀 Execução Rápida

### Opção 1: Maven Exec Plugin (Recomendado)
```bash
# Compilar e executar em um comando
mvn clean compile exec:java

# Ou separadamente:
mvn clean compile
mvn exec:java
```

### Opção 2: Java Direto (após compilação)
```bash
# Compilar
mvn compile

# Executar diretamente
java -cp target/classes br.pucrs.App
```

### Opção 3: Criar JAR executável
```bash
# Criar JAR com dependências
mvn clean package

# Executar o JAR
java -jar target/divisao-e-conquista-exercicio-de-aprofundamento-v1.0-snap.jar
```

## 📊 O que o Programa Executa

O programa testa **dois algoritmos** com **três tamanhos diferentes**:

### 🔄 Merge Sort (Divisão e Conquista)
- **Complexidade:** O(n log n)
- **Tamanhos:** 32, 2.048, 1.048.576 elementos
- **Mede:** Iterações, tempo, validação de ordenação

### 📏 MaxVal1 (Busca Linear)
- **Complexidade:** O(n)
- **Tamanhos:** 32, 2.048, 1.048.576 elementos
- **Mede:** Iterações, tempo, validação do máximo

## 📈 Resultados Esperados

### Saída Típica:
```
================================================================================
TESTE DO ALGORITMO MERGE SORT - DIVISÃO E CONQUISTA
================================================================================

TESTE COM VETOR DE TAMANHO: 32
Número de iterações: 312
Tempo gasto: 0.45 ms
Status de ordenação: ✓ CORRETO
Primeiros 10 elementos: -123456 0 123456 ...

================================================================================
TESTE DO ALGORITMO MAXVAL1 - BUSCA LINEAR (SEM DIVISÃO E CONQUISTA)
================================================================================

TESTE COM VETOR DE TAMANHO: 32
Maior valor encontrado: 999856
Número de iterações: 94
Tempo gasto: 0.02 ms
Status da busca: ✓ CORRETO
Primeiros 10 elementos: -456789 0 123456 ...
```

## 🛠️ Solução de Problemas

### Erro: "Could not find or load main class"
```bash
# Solução: Compilar primeiro
mvn clean compile
mvn exec:java
```

### Erro: "Java version mismatch"
- O projeto usa Java 17
- Verifique se tem JDK 17+ instalado

### Erro: "Maven not found"
```bash
# Instalar Maven se necessário
sudo apt update && sudo apt install maven
```

## 📁 Estrutura do Projeto

```
src/
├── main/java/br/pucrs/
│   ├── App.java           # Classe principal com testes
│   ├── MergeSort.java     # Algoritmo Merge Sort
│   └── MaxVal1.java       # Algoritmo MaxVal1
└── test/java/br/pucrs/
    └── AppTest.java       # Testes unitários
```

## 📚 Documentação

- `MERGE_SORT_EXPLICACAO.md` - Explicação detalhada do Merge Sort
- `VISUALIZACAO_MERGE_SORT.md` - Exemplos visuais
- `MAXVAL1_EXPLICACAO.md` - Explicação do MaxVal1
- `IMPLEMENTACAO_RESUMO.md` - Resumo geral

## 🎯 Próximos Passos

Após executar com sucesso, implemente:
1. **MaxVal2** - Algoritmo de máximo com divisão e conquista
2. **Multiplicação Inteira** - Algoritmo n-bits
3. **Tabela Comparativa** - Todos os algoritmos juntos

---

**Execute `mvn clean compile exec:java` e veja os algoritmos em ação! 🚀**