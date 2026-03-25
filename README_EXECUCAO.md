# Como Executar o Projeto - Divisão e Conquista

## 🚀 Execução Rápida

### ✅ Comando Recomendado:
```bash
mvn clean compile exec:java
```

---

## 🛠️ Solução de Problemas de Java

### **Erro: "Maven 4.x requires Java 17"**
**✅ SOLUÇÃO:** O projeto foi configurado para usar **Java 11** (versão disponível no sistema).

### **Verificar versão Java:**
```bash
java -version
# Deve mostrar: openjdk version "11.x.x"
```

### **Se ainda houver problemas:**
```bash
# Forçar uso do Java 11
export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
mvn clean compile exec:java
```

---

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

---

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

================================================================================
TESTE DO ALGORITMO MAXVAL1 - BUSCA LINEAR (SEM DIVISÃO E CONQUISTA)
================================================================================

TESTE COM VETOR DE TAMANHO: 32
Maior valor encontrado: 999856
Número de iterações: 94
Tempo gasto: 0.02 ms
Status da busca: ✓ CORRETO
```

---

## 🛠️ Outros Problemas Comuns

### **Erro: "Could not find or load main class"**
```bash
# Solução: Compilar primeiro
mvn clean compile
mvn exec:java
```

### **Erro: "Maven not found"**
```bash
# Instalar Maven
sudo apt update && sudo apt install maven
```

### **Erro de compilação:**
- Verifique se todos os arquivos `.java` estão na pasta correta
- Execute `mvn clean` para limpar arquivos temporários

---

## 📁 Estrutura do Projeto

```
src/
├── main/java/br/pucrs/
│   ├── App.java           # Classe principal com testes
│   ├── MergeSort.java     # Algoritmo Merge Sort
│   └── MaxVal1.java       # Algoritmo MaxVal1
└── test/java/br/pucrs/
    └── AppTest.java       # Testes unitários

.mvn/settings.xml          # Configurações Maven
pom.xml                    # Configuração do projeto
run.sh                     # Script de execução
```

---

## 🎯 Status Atual

✅ **Merge Sort** - Implementado e testado  
✅ **MaxVal1** - Implementado e testado  
✅ **Configuração Java 11** - Ajustada  
✅ **Execução Maven** - Configurada  

---

## 📚 Próximos Passos

Após executar com sucesso, implemente:
1. **MaxVal2** - Algoritmo de máximo com divisão e conquista
2. **Multiplicação Inteira** - Algoritmo n-bits
3. **Tabela Comparativa** - Todos os algoritmos juntos

---

**🎉 Execute `mvn clean compile exec:java` e veja os algoritmos funcionando!**